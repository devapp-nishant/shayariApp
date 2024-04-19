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

public class GoodMorningActivity extends AppCompatActivity {
    private com.rsva.englishloveshayariapp.databinding.ActivityGoodMorningBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.rsva.englishloveshayariapp.databinding.ActivityGoodMorningBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        shayariModel = new ArrayList<>();

        makeToolbar();

        shayariModel = new ArrayList<>();

        shayariModel.add(new ShayariModel("Every morning brings new potential, but it's what we do with it that makes a difference."));
        shayariModel.add(new ShayariModel("Good morning! Today's forecast: sunshine with a 100% chance of happiness."));
        shayariModel.add(new ShayariModel("Don't underestimate the power of thoughts and words. What you tell yourself every morning will set your mind and life on that path. Talk success, victory, happiness, and blessings over your destiny."));
        shayariModel.add(new ShayariModel("Good morning! Remember: You're not just another person, you're a unique reflection of the Divine."));
        shayariModel.add(new ShayariModel("Each morning we are born again. What we do today is what matters most."));
        shayariModel.add(new ShayariModel("Opportunities are like sunrises. If you wait too long, you miss them."));
        shayariModel.add(new ShayariModel("Every morning brings new potential, but it's what we do with it that makes a difference."));
        shayariModel.add(new ShayariModel("Some days you just have to create your own sunshine."));
        shayariModel.add(new ShayariModel("Good morning! Life is like a mirror: it'll smile at you if you smile at it."));
        shayariModel.add(new ShayariModel("Today is a new beginning, a chance to turn your failures into achievements & your sorrows into goods. No room for excuses."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.goodMorningRecView.setHasFixedSize(true);
        binding.goodMorningRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.goodMorningRecView.setAdapter(adapter);
    }

    private void makeToolbar() {
        setSupportActionBar(binding.goodMorningtoolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("GoodMorning Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.goodMorningtoolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}