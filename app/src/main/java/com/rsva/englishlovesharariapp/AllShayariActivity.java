package com.rsva.englishlovesharariapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishlovesharariapp.databinding.ActivityAllShayariBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllShayariActivity extends AppCompatActivity {
    private ActivityAllShayariBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;
    private String CategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllShayariBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        if (getIntent().getStringExtra("CategoryName") != null)
            CategoryName = getIntent().getStringExtra("CategoryName");

        makeToolbar();

        shayariModel = new ArrayList<>();
        adapter = new ShayariAdapter(this, shayariModel);
        binding.allShayariRecView.setHasFixedSize(true);
        binding.allShayariRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.allShayariRecView.setAdapter(adapter);


        shayariModel.add(new ShayariModel("Best Friend Toh Woh Hote Hain Jinka Name,\n" +
                "Sunke Aur Baatein Yaad Karke Hamare\n" +
                "Face Par Smile, Ah Aajaye.."));

        shayariModel.add(new ShayariModel("doston se mile jamaanaa ho gayaa,\n" +
                "lagataa hai ab vo dost begaanaa ho gayaa,\n" +
                "kaash phir se doston kii mahafil sajatii,\n" +
                "doston se bichhade jamaanaa ho gayaa."));

        shayariModel.add(new ShayariModel("kisi ke ishq mein barbaad hona\n" +
                "humein aaya nahin farhaad hona"));

        shayariModel.add(new ShayariModel("bhula paana bahut mushkil hai sab kuch yaad rehta hai\n" +
                "mohabbat karne waala is liye barbaad rehta hai"));

    }

    private void makeToolbar() {
        setSupportActionBar(binding.allShayariToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(CategoryName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.allShayariToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}