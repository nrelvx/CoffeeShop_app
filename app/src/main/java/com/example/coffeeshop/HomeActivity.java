package com.example.coffeeshop;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_favorites){
                return true;
            } else return id == R.id.nav_settings;
        });


        int[] favIds = {R.id.floatingActionButton_1, R.id.floatingActionButton_2, R.id.floatingActionButton_3,
                R.id.floatingActionButton_4, R.id.floatingActionButton_5};

        View.OnClickListener favClickListener = v -> {

            FloatingActionButton fav = (FloatingActionButton) v;
            fav.setImageTintList(ColorStateList.valueOf(Color.RED));

            String message = "Added to favorites";
            Toast.makeText(HomeActivity.this, message, Toast.LENGTH_SHORT).show();
        };

        for (int id : favIds) {
            FloatingActionButton fav = findViewById(id);
            fav.setOnClickListener(favClickListener);
        }
    }
}