package com.example.cyod;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cyod.utilities.ViewUtility;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        var back_btn = findViewById(R.id.backButton);
        ViewUtility.setBackOnClick(back_btn, this);

    }

    protected void setContentLayout(int layoutId){
        getLayoutInflater().inflate(layoutId, findViewById(R.id.content));
    }
}
