package com.rsva.englishloveshayariapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.rsva.englishloveshayariapp.Adapter.ShayariCategoryAdapter;
import com.rsva.englishloveshayariapp.Model.ShayariCategoryModel;
import com.rsva.englishloveshayariapp.R;
import com.rsva.englishloveshayariapp.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<ShayariCategoryModel> categoryModel;
    private ShayariCategoryAdapter adapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = findViewById(R.id.main_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView.bringToFront();

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            // Handle item clicks
            int itemId = menuItem.getItemId();
            if (itemId == R.id.nav_share) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                // setting type of data shared as text
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

                // Adding the text to share using putExtra
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.rsva.englishloveshayariapp");
                startActivity(Intent.createChooser(shareIntent, "Share Via"));
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
            startActivity(new Intent(this, SadActivity.class));
        });

        binding.FriendShipShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, FriendshipActivity.class));
        });

        binding.heartbreakShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, HeartBreakActivity.class));
        });

        binding.motivationalShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, MotivationalActivity.class));
        });

        binding.goodMorningShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, GoodMorningActivity.class));
        });

        binding.romanticShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, RomanticActivity.class));
        });

        binding.coupleShayari.setOnClickListener(v -> {
            startActivity(new Intent(this, CoupleActivity.class));
        });


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