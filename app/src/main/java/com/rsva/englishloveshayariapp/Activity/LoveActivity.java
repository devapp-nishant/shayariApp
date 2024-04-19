package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.R;
import com.rsva.englishloveshayariapp.databinding.ActivityLoveBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoveActivity extends AppCompatActivity {
    private ActivityLoveBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        makeToolbar();

        shayariModel = new ArrayList<>();

        shayariModel.add(new ShayariModel("In your eyes, I found my home, my world, and my eternity."));
        shayariModel.add(new ShayariModel("Your presence is my favorite place to be."));
        shayariModel.add(new ShayariModel("Love is not a choice; it's a feeling that chooses you."));
        shayariModel.add(new ShayariModel("When words fall short, let love express what your heart desires."));
        shayariModel.add(new ShayariModel("In the symphony of life, love is the most beautiful melody."));
        shayariModel.add(new ShayariModel("Every love story is beautiful, but ours is my favorite."));
        shayariModel.add(new ShayariModel("Love isn't about perfection; it's about acceptance and understanding."));
        shayariModel.add(new ShayariModel("With you, every moment feels like a lifetime of happiness."));
        shayariModel.add(new ShayariModel("Two lines, endless emotions – that's the beauty of love."));
        shayariModel.add(new ShayariModel("In your eyes, I see the world I've always dreamed of."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.loveRecView.setHasFixedSize(true);
        binding.loveRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.loveRecView.setAdapter(adapter);

    }

    private void makeToolbar() {
        setSupportActionBar(binding.loveToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Love Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.loveToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}