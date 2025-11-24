package com.example.cyod.utilities;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cyod.MainActivity;

public class ViewUtility {

    public static void setMoveOnClick(View view, final Class<?> toActivity) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, toActivity);
                context.startActivity(intent);
            }
        });
    }

    public static void setMoveOnClick(View view, final Class<?> toActivity, final Bundle bundle) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, toActivity);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                context.startActivity(intent);
            }
        });
    }
}
