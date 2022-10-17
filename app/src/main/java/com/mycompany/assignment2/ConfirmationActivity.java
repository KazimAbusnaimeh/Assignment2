package com.mycompany.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.mycompany.assignment2.databinding.ActivityConfirmationBinding;


public class ConfirmationActivity extends AppCompatActivity {
    ActivityConfirmationBinding binding;

    final String MODEL = "MODEL";
    final String BRAND="THE BRAND";
    final String COLOR="COLOR";
    final String STORAGE="STORAGE";
    final String NAME="NAME";
    final String ADDRESS="ADDRESS";
    final String PRICE = "PRICE";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityConfirmationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvCostumerName.setText("Your Name: "+getIntent().getStringExtra(NAME));
        binding.tvPhonePrice.setText("Mobile price: "+getIntent().getStringExtra(PRICE));
        binding.tvDeliveryAddress.setText("Your Address: "+getIntent().getStringExtra(ADDRESS));
        binding.tvPhoneColor.setText("Mobile Color: "+getIntent().getStringExtra(COLOR));
        binding.tvPhoneStorage.setText("Mobile Storage: "+getIntent().getStringExtra(STORAGE));
        binding.tvPhoneModel.setText("Mobile Model: "+getIntent().getStringExtra(MODEL));
        binding.tvPhoneBrand.setText("Mobile Brand: "+getIntent().getStringExtra(BRAND));
    }
}