package com.mycompany.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mycompany.assignment2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    final String APPLE_KEY = "1";
    final String GOOGLE_KEY = "2";
    final String OPPO_KEY = "3";
    final String SAMSUNG_KEY = "4";
    final String BRAND = "THE BRAND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_brands, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(getBaseContext(), ModelAndPriceActivity.class);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        switch (item.getItemId()) {

            case R.id.item_apple: {
                intent.putExtra("brand", APPLE_KEY);
                intent.putExtra(BRAND, "APPLE");
                startActivity(intent);
                return true;
            }
            case R.id.Oppo: {
                intent.putExtra("brand", OPPO_KEY);
                intent.putExtra(BRAND, "OPPO");
                startActivity(intent);
                return true;
            }
            case R.id.Google: {
                intent.putExtra("brand", GOOGLE_KEY);
                intent.putExtra(BRAND, "GOOGLE");
                startActivity(intent);
                return true;
            }
            case R.id.Samsung: {
                intent.putExtra("brand", SAMSUNG_KEY);
                intent.putExtra(BRAND, "SAMSUNG");
                startActivity(intent);
                return true;
            }
        }
        return false;
    }
}