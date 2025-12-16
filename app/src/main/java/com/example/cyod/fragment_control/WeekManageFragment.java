package com.example.cyod.fragment_control;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cyod.R;
import com.example.cyod.WeekManageActivity;
import com.example.cyod.utilities.ViewUtility;

public class WeekManageFragment extends BaseFragment{

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button addNewWeek = view.findViewById(R.id.addWeekButton);
        ViewUtility.setMoveOnClick(addNewWeek, WeekManageActivity.class);
    }

    @Override
    protected int getFragmentId() {
        return R.layout.week_manage_fragment;
    }
}
