package com.rsva.englishlovesharariapp.Adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsva.englishlovesharariapp.Model.ShayariModel;
import com.rsva.englishlovesharariapp.R;

import java.util.List;

public class ShayariAdapter extends RecyclerView.Adapter<ShayariAdapter.ShayariViewHolder> {

    Context context;
    List<ShayariModel> shayariModel;

    public ShayariAdapter(Context context, List<ShayariModel> shayariModel) {
        this.context = context;
        this.shayariModel = shayariModel;
    }

    @NonNull
    @Override
    public ShayariAdapter.ShayariViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shayari_item, parent, false);
        return new ShayariViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShayariAdapter.ShayariViewHolder holder, int position) {
        holder.shayariItemText.setText(shayariModel.get(position).getShayariText());

        holder.sharebtn.setOnClickListener(v -> {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plane");
            share.putExtra(Intent.EXTRA_INTENT, shayariModel.get(position).getShayariText());
            context.startActivity(share);
        });
        holder.copyBtn.setOnClickListener(v -> {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData data = (ClipData) ClipData.newPlainText("text", shayariModel.get(position).getShayariText());
            clipboardManager.setPrimaryClip(data);
            Toast.makeText(context, "Text Copied!", Toast.LENGTH_SHORT).show();
        });
        holder.whatsappBtn.setOnClickListener(v -> {
            try {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plane");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_INTENT, shayariModel.get(position).getShayariText());
                context.startActivity(whatsappIntent);
            }catch (Exception e){
                Log.e("Whataspp", e.getLocalizedMessage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return shayariModel.size();
    }

    public class ShayariViewHolder extends RecyclerView.ViewHolder {
        TextView shayariItemText;
        ImageView sharebtn, copyBtn, whatsappBtn;

        public ShayariViewHolder(@NonNull View itemView) {
            super(itemView);
            sharebtn = itemView.findViewById(R.id.shayariShareBtn);
            copyBtn = itemView.findViewById(R.id.shayariCopyBtn);
            whatsappBtn = itemView.findViewById(R.id.shayariWhatsappBtn);
            shayariItemText = itemView.findViewById(R.id.shayariItemText);
        }
    }
}
