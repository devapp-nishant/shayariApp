package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.databinding.ActivityAllShayariBinding;

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


        shayariModel.add(new ShayariModel("Behind every status\n" +
                "there is s secret\n" +
                "Message for someone.."));

        shayariModel.add(new ShayariModel("Nothing hurts more then a\n" +
                "heart left wondering why .."));

        shayariModel.add(new ShayariModel("I don’t want to die or kill myself,\n" +
                "I just want to disappear until,\n" +
                "I feel okey again.."));

        shayariModel.add(new ShayariModel("And in the end all I learned\n" +
                "Was how to be strong alone.."));

        shayariModel.add(new ShayariModel("Finally realized I\n" +
                "Wasn’t asking for too\n" +
                "much …\n" +
                "I was just asking the\n" +
                "wrong person.."));

        shayariModel.add(new ShayariModel("Karma says .. you will keep\n" +
                "Forgiving them until you\n" +
                "Unlove them ..\n"));

        shayariModel.add(new ShayariModel("People will provoke you\n" +
                "Until they bring out your ugly\n" +
                "Side, then play victim when\n" +
                "You go there .."));

        shayariModel.add(new ShayariModel("The only people up at 3 am are,\n" +
                "In love, lonely, drunk, or all three."));

        shayariModel.add(new ShayariModel("I am not getting better but at\n" +
                "Least I haven’t killed myself"));

        shayariModel.add(new ShayariModel("You haven’t lived til\n" +
                "You’ve found something\n" +
                "To die for"));

        shayariModel.add(new ShayariModel("Worst part of over thinking\n" +
                "Is you are probably right"));

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