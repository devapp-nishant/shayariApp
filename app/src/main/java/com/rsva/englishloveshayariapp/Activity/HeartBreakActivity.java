package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HeartBreakActivity extends AppCompatActivity {

    private com.rsva.englishloveshayariapp.databinding.ActivityHeartBreakBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.rsva.englishloveshayariapp.databinding.ActivityHeartBreakBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shayariModel = new ArrayList<>();

        setSupportActionBar(binding.heartBreaktoolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Heart Break Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.heartBreaktoolbar.setNavigationOnClickListener(view -> {
            finish();
        });

        shayariModel.add(new ShayariModel("When we miss someone often, what we really miss is the part of us that with this someone awakens."));
        shayariModel.add(new ShayariModel("One day you’re going to remember me and how much I loved you … then you’re going to hate yourself for letting me go."));
        shayariModel.add(new ShayariModel("Every time your heart is broken, a doorway cracks open to a world full of new beginnings, new opportunities."));
        shayariModel.add(new ShayariModel("I’d rather love a million times and have my heart broken every time, than hold a permanently empty heart forever."));
        shayariModel.add(new ShayariModel("The broken heart. You think you will die, but you keep living, day after day after terrible day."));
        shayariModel.add(new ShayariModel("Tis better to have loved and lost than never to have loved at all."));
        shayariModel.add(new ShayariModel("Stab the body and it heals, but injure the heart and the wound lasts a lifetime."));
        shayariModel.add(new ShayariModel("The heart was made to be broken."));
        shayariModel.add(new ShayariModel("When you are in love, and you get hurt, it’s like a cut—it will heal, but there will always be a scar."));
        shayariModel.add(new ShayariModel("The human heart is the only thing whose worth increases the more it is broken."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.heartBreakRecView.setHasFixedSize(true);
        binding.heartBreakRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.heartBreakRecView.setAdapter(adapter);
    }
}