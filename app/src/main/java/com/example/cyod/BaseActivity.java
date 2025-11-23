package com.example.cyod;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cyod.menupkg.MenuActivity;
import com.example.cyod.menupkg.utilities.ViewUtility;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ImageButton menuButton = findViewById(R.id.menu_button);
        ViewUtility.setMoveOnClick(menuButton, MenuActivity.class);
    }

    protected void setContentLayout(int layoutResId){
        getLayoutInflater().inflate(layoutResId, findViewById(R.id.baseLayout));
    }
}