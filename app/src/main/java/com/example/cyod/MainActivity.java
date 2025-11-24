package com.example.cyod;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
    }

    private void setupNavigation() {
        BottomNavigationView mainBottom = findViewById(R.id.main_bottom);
        NavHostFragment navHostFragment =  (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainFrameLayout);
        navController = navHostFragment != null ? navHostFragment.getNavController() : null;
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home_nav,
                R.id.calendar_nav,
                R.id.week_manage_nav,
                R.id.settings_nav
                ).build();
        NavigationUI.setupWithNavController(mainBottom, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
