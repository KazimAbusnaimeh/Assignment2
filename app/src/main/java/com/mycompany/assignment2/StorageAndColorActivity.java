package com.mycompany.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.mycompany.assignment2.databinding.ActivityStorageAndColorBinding;

import java.util.ArrayList;
import java.util.List;

public class StorageAndColorActivity extends AppCompatActivity {

    ActivityStorageAndColorBinding binding;

    List<String> colors;

    final String COLOR = "COLOR";
    final String STORAGE = "STORAGE";
    final String MODEL = "MODEL";
    final String PRICE = "PRICE";
    final String BRAND = "THE BRAND";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStorageAndColorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initColorList();

        Intent intent = new Intent(getBaseContext(), CustomerInformationActivity.class);


        binding.spinnerColor.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colors));

        binding.spinnerColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    intent.putExtra(COLOR, "Gold");
                }
                if (i == 1) {
                    intent.putExtra(COLOR, "Silver");
                }
                if (i == 2) {
                    intent.putExtra(COLOR, "Black");
                }
                if (i == 3) {
                    intent.putExtra(COLOR, "Blue");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                intent.putExtra(COLOR, "Gold");
            }
        });

        binding.btnNextToInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButton;
                int radioId = binding.rgStorage.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String storage = (String) radioButton.getText();
                intent.putExtra(STORAGE, storage);
                intent.putExtra(MODEL, getIntent().getStringExtra(MODEL));
                intent.putExtra(PRICE, getIntent().getStringExtra(PRICE));
                intent.putExtra(BRAND, getIntent().getStringExtra(BRAND));
                startActivity(intent);
            }
        });

    }
    public void initColorList() {
        colors = new ArrayList<>();
        colors.add("Gold");
        colors.add("Silver");
        colors.add("Black");
        colors.add("Blue");
    }
}
