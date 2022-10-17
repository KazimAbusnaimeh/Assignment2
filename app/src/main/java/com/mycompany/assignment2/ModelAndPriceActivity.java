package com.mycompany.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.mycompany.assignment2.databinding.ActivityMainBinding;
import com.mycompany.assignment2.databinding.ActivityPhoneModelBinding;

import java.util.ArrayList;

public class ModelAndPriceActivity extends AppCompatActivity {

    ActivityPhoneModelBinding binding;

    final int APPLE_KEY = 1;
    final int GOOGLE_KEY = 2;
    final int OPPO_KEY = 3;
    final int SAMSUNG_KEY = 4;
    final String MODEL = "MODEL";
    final String PRICE = "PRICE";
    final String BRAND = "THE BRAND";

    String[] samsung;
    String[] apple;
    String[] oppo;
    String[] pixel;
    String[] price;

    String[] modelList;
    String[] priceList;

    ArrayList<ModelAndPrice> modelAndPriceArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPhoneModelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initList();

        modelList = new String[0];
        priceList = price;


        modelAndPriceArrayList = new ArrayList<>();

        int x = Integer.parseInt(getIntent().getStringExtra("brand"));
        switch (x) {
            case APPLE_KEY: {
                binding.ivBrandLogo.setImageResource(R.drawable.apple_logo);
                modelList = apple;
                break;
            }
            case GOOGLE_KEY: {
                binding.ivBrandLogo.setImageResource(R.drawable.google_pixel);
                modelList = pixel;
                break;
            }
            case SAMSUNG_KEY: {
                binding.ivBrandLogo.setImageResource(R.drawable.samsung_logo);
                modelList = samsung;
                break;
            }
            case OPPO_KEY: {
                binding.ivBrandLogo.setImageResource(R.drawable.oppo_logo);
                modelList = oppo;
                break;
            }

        }
        setModelAndPrices(modelList, priceList);

        ModelListAdapter modelListAdapter = new ModelListAdapter(getBaseContext(), modelAndPriceArrayList);
        binding.lvModelAndPrice.setAdapter(modelListAdapter);
        binding.lvModelAndPrice.setClickable(true);
        binding.lvModelAndPrice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), StorageAndColorActivity.class);

                intent.putExtra(MODEL, modelList[i]);
                intent.putExtra(PRICE, priceList[i]);
                intent.putExtra(BRAND, getIntent().getStringExtra(BRAND));
                startActivity(intent);
            }
        });

    }

    private void initList() {
        samsung = new String[]{"Galaxy S22", "Galaxy S22 Ultra", " Galaxy Z"};
        apple = new String[]{"iPhone 14", "iPhone 14 Pro", "iPhone 14 Max"};
        oppo = new String[]{"Oppo Find X3", "Oppo Find X5", "Oppo Find X5 Pro"};
        pixel = new String[]{"Google Pixel 6a", "Google Pixel 6", "Google Pixel 6 Pro"};
        price = new String[]{"800$", "950$", "1100$"};

    }

    public void setModelAndPrices(String[] modelList, String[] priceList) {
        for (int i = 0; i < samsung.length; i++) {
            modelAndPriceArrayList.add(new ModelAndPrice(modelList[i], priceList[i]));
        }
    }
}

//don't use shared pref anymore
//write ur code as story method not in one method
//try to reduce ur code
//ifx naming conviation
// use view binding in all adapter and activities
// listview with object
