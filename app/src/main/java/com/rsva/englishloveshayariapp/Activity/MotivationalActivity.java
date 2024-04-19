
package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.R;
import com.rsva.englishloveshayariapp.databinding.ActivityMotivationalBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MotivationalActivity extends AppCompatActivity {
    private ActivityMotivationalBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMotivationalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shayariModel = new ArrayList<>();

        makeToolbar();

        shayariModel = new ArrayList<>();

        shayariModel.add(new ShayariModel("Start every day with a smile and get it over with."));
        shayariModel.add(new ShayariModel("Good morning! Life is like a mirror: it'll smile at you if you smile at it"));
        shayariModel.add(new ShayariModel("The way you start your day can affect your whole day. Begin it with a smile, calmness of mind, and a heart filled with gratitude."));
        shayariModel.add(new ShayariModel("When you give joy to other people, you get more joy in return. You should give a good thought to the happiness that you can give out."));
        shayariModel.add(new ShayariModel("Nature has given us all the pieces required to achieve exceptional wellness and health, but has left it to us to put these pieces together"));
        shayariModel.add(new ShayariModel("Develop success from failures. Discouragement and failure are two of the surest stepping stones to success."));
        shayariModel.add(new ShayariModel("There are three ways to ultimate success: The first way is to be kind. The second way is to be kind. The third way is to be kind"));
        shayariModel.add(new ShayariModel("Success is getting what you want; happiness is wanting what you get."));
        shayariModel.add(new ShayariModel("Develop success from failures. Discouragement and failure are two of the surest stepping stones to success"));
        shayariModel.add(new ShayariModel("It is better to fail in originality than to succeed in imitation."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.motivationalRecView.setHasFixedSize(true);
        binding.motivationalRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.motivationalRecView.setAdapter(adapter);
    }
    private void makeToolbar() {
        setSupportActionBar(binding.motivationaltoolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Motivational Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.motivationaltoolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}