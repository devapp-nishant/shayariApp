package com.rsva.englishlovesharariapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rsva.englishlovesharariapp.R;
import com.rsva.englishlovesharariapp.databinding.ActivitySadBinding;

public class SadActivity extends AppCompatActivity {
    private ActivitySadBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}