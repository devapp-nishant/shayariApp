package com.rsva.englishloveshayariapp.Adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.R;

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
            Intent shareIntent = new Intent(Intent.ACTION_SEND);

            // setting type of data shared as text
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

            // Adding the text to share using putExtra
            shareIntent.putExtra(Intent.EXTRA_TEXT, shayariModel.get(position).getShayariText());
            context.startActivity(Intent.createChooser(shareIntent, "Share Via"));
        });

        holder.copyBtn.setOnClickListener(v -> {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData data = (ClipData) ClipData.newPlainText("text", shayariModel.get(position).getShayariText());
            clipboardManager.setPrimaryClip(data);
            Toast.makeText(context, "Text Copied!", Toast.LENGTH_SHORT).show();
        });

        holder.whatsappBtn.setOnClickListener(v -> {
            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("text/plain");
            whatsappIntent.setPackage("com.whatsapp");
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, shayariModel.get(position).getShayariText());
            try {
                context.startActivity(whatsappIntent);
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(context, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();
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
