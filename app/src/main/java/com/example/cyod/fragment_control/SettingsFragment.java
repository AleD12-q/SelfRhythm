package com.example.cyod.fragment_control;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cyod.R;
import com.example.cyod.SettingsActivity;
import com.example.cyod.utilities.SettingsFragmentType;
import com.example.cyod.utilities.ViewUtility;

public class SettingsFragment extends BaseFragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        var general_button = view.findViewById(R.id.settings_general_btn);
        var design_button = view.findViewById(R.id.settings_design_btn);
        var exp_func_button = view.findViewById(R.id.settings_exp_func_btn);
        var data_usage_button = view.findViewById(R.id.settings_data_usage_btn);
        var notif_button = view.findViewById(R.id.settings_notif_and_sound_btn);

        ViewUtility.setMoveOnClick(general_button, SettingsActivity.class, SettingsFragmentType.GENERAL);
        ViewUtility.setMoveOnClick(design_button, SettingsActivity.class, SettingsFragmentType.DESIGN);
        ViewUtility.setMoveOnClick(exp_func_button, SettingsActivity.class, SettingsFragmentType.EXPERIMENTAL_FUNCTION);
        ViewUtility.setMoveOnClick(data_usage_button, SettingsActivity.class, SettingsFragmentType.DATA_USAGE);
        ViewUtility.setMoveOnClick(notif_button, SettingsActivity.class, SettingsFragmentType.NOTIFICATIONS_AND_SOUND);


    }

    @Override
    protected int getFragmentId() {
        return R.layout.settings_fragment;
    }
}
