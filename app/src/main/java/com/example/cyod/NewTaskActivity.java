package com.example.cyod;

import android.os.Bundle;

import androidx.annotation.Nullable;

public class NewTaskActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.new_task_activity, getString(R.string.new_task));
    }
}
