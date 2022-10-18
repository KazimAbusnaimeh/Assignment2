package com.mycompany.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

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
        binding = ActivityCustomerInformationBinding.inflate(getLayoutInflater());
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

                if (TextUtils.isEmpty(binding.etName.getText())
                |TextUtils.isEmpty(binding.etAddress.getText())
                |TextUtils.isEmpty(binding.etCardType.getText())
                |TextUtils.isEmpty(binding.etCardNumber.getText())
                |TextUtils.isEmpty(binding.etCity.getText())
                |TextUtils.isEmpty(binding.etCvvCvc.getText())
                |TextUtils.isEmpty(binding.etPostalCode.getText())
                |TextUtils.isEmpty(binding.etPhoneNumber.getText())
                ) {
                    Toast.makeText(CustomerInformationActivity.this, "Kindly fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(intent);
                }
            }
        });
    }
}