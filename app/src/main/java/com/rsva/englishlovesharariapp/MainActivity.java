package com.rsva.englishlovesharariapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishlovesharariapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<ShayariCategoryModel> categoryModel;
    private ShayariCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        makeToolbar();

        categoryModel = new ArrayList<>();
        initList();

        binding.shayariCategoryRecView.setHasFixedSize(true);
        binding.shayariCategoryRecView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShayariCategoryAdapter(this, categoryModel);
        binding.shayariCategoryRecView.setAdapter(adapter);

    }

    private void initList() {
        categoryModel.add(new ShayariCategoryModel("Love Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Dillagi Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Mohabbat Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Dosti Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Bewafa Shayari English"));
    }

    private void makeToolbar() {
        setSupportActionBar(binding.shayariCategoryToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("English Love Shayari");

    }

}