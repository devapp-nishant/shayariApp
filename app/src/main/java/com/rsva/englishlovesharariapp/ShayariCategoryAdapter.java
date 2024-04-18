package com.rsva.englishlovesharariapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShayariCategoryAdapter extends RecyclerView.Adapter<ShayariCategoryAdapter.ShayariCategoryViewHolder> {

    Context context;
    List<ShayariCategoryModel> catModel;

    public ShayariCategoryAdapter(Context context, List<ShayariCategoryModel> catModel) {
        this.context = context;
        this.catModel = catModel;
    }

    @NonNull
    @Override
    public ShayariCategoryAdapter.ShayariCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shayari_category_item, parent, false);
        return new ShayariCategoryAdapter.ShayariCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShayariCategoryAdapter.ShayariCategoryViewHolder holder, int position) {
        holder.categoryName.setText(catModel.get(position).getShayariCatName());
        holder.itemView.setOnClickListener(v -> {
            Intent shayariCatIntent = new Intent(context, AllShayariActivity.class);
            shayariCatIntent.putExtra("CategoryName", catModel.get(position).getShayariCatName());
            shayariCatIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(shayariCatIntent);
        });
    }

    @Override
    public int getItemCount() {
        return catModel.size();
    }

    public class ShayariCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;

        public ShayariCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
        }
    }
}
