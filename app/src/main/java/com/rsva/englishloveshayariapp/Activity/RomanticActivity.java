package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.R;
import com.rsva.englishloveshayariapp.databinding.ActivityRomanticBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RomanticActivity extends AppCompatActivity {
    private ActivityRomanticBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRomanticBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        makeToolbar();

        shayariModel = new ArrayList<>();

        shayariModel.add(new ShayariModel("I saw that you were perfect, and so I loved you. Then I saw that you were not perfect and I loved you even more."));
        shayariModel.add(new ShayariModel("You know you’re in love when you can’t fall asleep because reality is finally better than your dreams."));
        shayariModel.add(new ShayariModel("I am who I am because of you. You are every reason, every hope, and every dream I’ve ever had"));
        shayariModel.add(new ShayariModel("Take my hand, take my whole life too. For I can’t help falling in love with you."));
        shayariModel.add(new ShayariModel("You are the finest, loveliest, tenderest, and most beautiful person I have ever known and even that is an understatement."));
        shayariModel.add(new ShayariModel("I will never stop trying. Because when you find the one... you never give up"));
        shayariModel.add(new ShayariModel("I love you for all that you are, all that you have been and all that you will be."));
        shayariModel.add(new ShayariModel("When you realize you want to spend the rest of your life with somebody, you want the rest of your life to start as soon as possible"));
        shayariModel.add(new ShayariModel("In all the world, there is no heart for me like yours. In all the world, there is no love for you like mine."));
        shayariModel.add(new ShayariModel("Love is when you sit beside someone doing nothing, yet you feel perfectly happy."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.romanticRecView.setHasFixedSize(true);
        binding.romanticRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.romanticRecView.setAdapter(adapter);
    }
    private void makeToolbar() {
        setSupportActionBar(binding.romanticToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Romantic Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.romanticToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}