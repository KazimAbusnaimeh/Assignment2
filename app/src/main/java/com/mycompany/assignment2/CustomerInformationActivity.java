package com.mycompany.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mycompany.assignment2.databinding.ActivityCustomerInformationBinding;

public class CustomerInformationActivity extends AppCompatActivity {

    ActivityCustomerInformationBinding binding;
    final String NAME = "NAME";
    final String ADDRESS = "ADDRESS";
    final String COLOR = "COLOR";
    final String STORAGE = "STORAGE";
    final String MODEL = "MODEL";
    final String PRICE = "PRICE";
    final String BRAND = "THE BRAND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCustomerInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = new Intent(this, ConfirmationActivity.class);

        binding.btnNextToConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String the_name = String.valueOf(binding.etName.getText());
                String the_address = String.valueOf(binding.etAddress.getText());

                intent.putExtra(NAME, the_name);
                intent.putExtra(ADDRESS, the_address);
                intent.putExtra(COLOR, getIntent().getStringExtra(COLOR));
                intent.putExtra(STORAGE, getIntent().getStringExtra(STORAGE));
                intent.putExtra(MODEL, getIntent().getStringExtra(MODEL));
                intent.putExtra(PRICE, getIntent().getStringExtra(PRICE));
                intent.putExtra(BRAND, getIntent().getStringExtra(BRAND));
                startActivity(intent);
            }
        });
    }
}