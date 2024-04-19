package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.databinding.ActivityCoupleBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoupleActivity extends AppCompatActivity {
    private ActivityCoupleBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoupleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        makeToolbar();

        shayariModel = new ArrayList<>();

        shayariModel.add(new ShayariModel("Every love story is beautiful, but ours is my favorite."));
        shayariModel.add(new ShayariModel("Love is a journey and ours is my favorite destination."));
        shayariModel.add(new ShayariModel("Love you to the moon and back."));
        shayariModel.add(new ShayariModel("We’re not a perfect couple, but we’re perfectly weird together."));
        shayariModel.add(new ShayariModel("Relationship status: WiFi connected, but looking for a stronger signal."));
        shayariModel.add(new ShayariModel("Relationship status: Ring finger still empty, pizza box not"));
        shayariModel.add(new ShayariModel("We finish each other’s sandwiches… oops, I mean sentences."));
        shayariModel.add(new ShayariModel("We’re the dynamic duo that’s always up to mischief."));
        shayariModel.add(new ShayariModel("Love is sharing your dessert, even when it’s really, really good."));
        shayariModel.add(new ShayariModel("Every love story is beautiful, but ours is my favorite fairytale."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.coupleRecView.setHasFixedSize(true);
        binding.coupleRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.coupleRecView.setAdapter(adapter);
    }

    private void makeToolbar() {
        setSupportActionBar(binding.coupleToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Couple Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.coupleToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}