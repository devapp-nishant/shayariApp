package com.rsva.englishloveshayariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.rsva.englishloveshayariapp.Adapter.ShayariAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariModel;
import com.rsva.englishloveshayariapp.R;
import com.rsva.englishloveshayariapp.databinding.ActivityFriendshipBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FriendshipActivity extends AppCompatActivity {
    private ActivityFriendshipBinding binding;
    private List<ShayariModel> shayariModel;
    private ShayariAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFriendshipBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shayariModel = new ArrayList<>();

        makeToolbar();

        shayariModel = new ArrayList<>();

        shayariModel.add(new ShayariModel("Friendship is the only cement that will ever hold the world together"));
        shayariModel.add(new ShayariModel("A true friend is someone who is always there when you need them."));
        shayariModel.add(new ShayariModel("A friend is someone who knows the song in your heart and can sing it back to you when you have forgotten the words"));
        shayariModel.add(new ShayariModel("Friendship is not about being inseparable but about being able to separate, knowing that nothing will change"));
        shayariModel.add(new ShayariModel("A friend is someone who knows all about you and still loves you"));
        shayariModel.add(new ShayariModel("A true friend is one who lends a hand without expecting anything in return"));
        shayariModel.add(new ShayariModel("A friend is someone who knows all about you and still loves you"));
        shayariModel.add(new ShayariModel("Friendship is not about who you’ve known the longest; it’s about who walked into your life and stayed."));
        shayariModel.add(new ShayariModel("A true friend is like a star; you may not always see them, but you know they’re always there"));
        shayariModel.add(new ShayariModel("A friend is someone who knows the song in your heart and can sing it back to you when you have forgotten the words."));

        adapter = new ShayariAdapter(this, shayariModel);
        binding.friendRecView.setHasFixedSize(true);
        binding.friendRecView.setLayoutManager(new LinearLayoutManager(this));
        binding.friendRecView.setAdapter(adapter);

    }

    private void makeToolbar() {
        setSupportActionBar(binding.friendToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Friendship Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.friendToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}