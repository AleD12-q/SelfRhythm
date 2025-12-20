package com.example.cyod;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cyod.R;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cyod.utilities.ViewUtility;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private TextView nameFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameFragment = findViewById(R.id.nameFragment);
        ImageButton dots = findViewById(R.id.dotsBtn);
        dots.setOnClickListener(v -> showDropdown());
        setupNavigation();
        setupLabelObserver();
    }

    private void showDropdown() {
        String[] items = {
                getString(R.string.new_task),
                getString(R.string.tasks),
                getString(R.string.import_item),
                getString(R.string.export_item)
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppDialogTheme);
        builder.setItems(items, ((dialog, which) -> {
            String selected = items[which];
            if(selected.equals(getString(R.string.new_task))){
                ViewUtility.moveTo(this, NewTaskActivity.class);
            }
            Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
        }));
        builder.show();
    }

    private void setupLabelObserver() {
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            String label = "None";
            if (destination.getLabel() != null) label = destination.getLabel().toString();
            setNameFragment(label);
        });
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

    public TextView getNameFragment() {
        return nameFragment;
    }

    public void setNameFragment(String label) {
            nameFragment.setText(label);
    }
}
