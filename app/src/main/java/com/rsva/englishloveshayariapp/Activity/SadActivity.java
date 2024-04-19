package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.R;
import com.rsva.englishloveshayariapp.databinding.ActivitySadBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SadActivity extends AppCompatActivity {
    private ActivitySadBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        makeToolbar();

        shayariModel = new ArrayList<>();
        shayariModel.add(new ShayariModel("There are moments when I wish I could roll back the clock and take all the sadness away, but I have the feeling that if I did, the joy would be gone as well."));
        shayariModel.add(new ShayariModel("Learning is a gift. Even when pain is your teacher."));
        shayariModel.add(new ShayariModel("Don't go around saying the world owes you a living. The world owes you nothing. It was here first."));
        shayariModel.add(new ShayariModel("Things change. And friends leave. And life doesn't stop for anybody."));
        shayariModel.add(new ShayariModel("One must not let oneself be overwhelmed by sadness."));
        shayariModel.add(new ShayariModel("Life is a moderately good play with a badly written third act."));
        shayariModel.add(new ShayariModel("I have learned now that while those who speak about one's miseries usually hurt, those who keep silence hurt more"));
        shayariModel.add(new ShayariModel("I’m not crying because of you; you’re not worth it. I’m crying because my delusion of who you were was shattered by the truth of who you are"));
        shayariModel.add(new ShayariModel("To live in a hallucination of being loved is more painful than rejection"));
        shayariModel.add(new ShayariModel("To live in a hallucination of being loved is more painful than rejection."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.sadRecView.setHasFixedSize(true);
        binding.sadRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.sadRecView.setAdapter(adapter);

    }
    private void makeToolbar() {
        setSupportActionBar(binding.sadToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sad Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.sadToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}