package com.example.cyod.menupkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cyod.MainActivity;
import com.example.cyod.R;
import com.example.cyod.menupkg.activities.SettingActivity;
import com.example.cyod.menupkg.utilities.ViewUtility;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageButton settingsButton = findViewById(R.id.settings_button);
        ViewUtility.setMoveOnClick(homeButton, MainActivity.class);
        ViewUtility.setMoveOnClick(settingsButton, SettingActivity.class);
    }


}
