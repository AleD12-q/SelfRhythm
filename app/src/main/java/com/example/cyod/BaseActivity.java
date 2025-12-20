package com.example.cyod;

import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cyod.utilities.ViewUtility;

public class BaseActivity extends AppCompatActivity {

    private TextView nameActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        var back_btn = findViewById(R.id.backButton);
        ViewUtility.setBackOnClick(back_btn, this);

        nameActivity = findViewById(R.id.nameActivity);
    }

    protected void setContentLayout(int layoutId, String name){
        nameActivity.setText(name);
        getLayoutInflater().inflate(layoutId, findViewById(R.id.content));
    }

}
