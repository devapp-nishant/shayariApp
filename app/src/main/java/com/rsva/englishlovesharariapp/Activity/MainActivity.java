package com.rsva.englishlovesharariapp.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.rsva.englishlovesharariapp.Adapter.ShayariCategoryAdapter;
import com.rsva.englishlovesharariapp.Model.ShayariCategoryModel;
import com.rsva.englishlovesharariapp.R;
import com.rsva.englishlovesharariapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<ShayariCategoryModel> categoryModel;
    private ShayariCategoryAdapter adapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = findViewById(R.id.all_shayari_toolbar);

        categoryModel = new ArrayList<>();
        initList();

//        binding.shayariCategoryRecView.setHasFixedSize(true);
//        binding.shayariCategoryRecView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new ShayariCategoryAdapter(this, categoryModel);
//        binding.shayariCategoryRecView.setAdapter(adapter);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            // Handle item clicks
            int itemId = menuItem.getItemId();
            if (itemId == R.id.nav_rate) {
                Toast.makeText(MainActivity.this, "Rate App", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.nav_privacy) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://englishloveshayari1.blogspot.com/2024/04/privacy-policy-english-love-shayari.html"));
                startActivity(myIntent);
            } else if (itemId == R.id.nav_exit) {
                finishAffinity();
            }

            // Close the drawer
            drawerLayout.closeDrawers();
            return true;
        });


        binding.LoveShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, LoveActivity.class));
        });

        binding.SadShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, LoveActivity.class));
        });


    }

    private void initList() {
        categoryModel.add(new ShayariCategoryModel("Love Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Sad Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Heart Break Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Friendship Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Couple Shayari English"));
        categoryModel.add(new ShayariCategoryModel("Motivational Shayari English"));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}