package com.example.cyod;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Pair;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cyod.fragment_control.DataUsageFragment;
import com.example.cyod.fragment_control.DesignFragment;
import com.example.cyod.fragment_control.ExperimentalFunctionFragment;
import com.example.cyod.fragment_control.GeneralSettingsFragment;
import com.example.cyod.fragment_control.NotificationsAndSoundFragment;
import com.example.cyod.utilities.SettingsFragmentType;
import com.example.cyod.utilities.ViewUtility;

public class SettingsActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.settings_activity, getString(R.string.settings_item_description));




        setStartFragment(getEnum());
    }

    private SettingsFragmentType getEnum(){
        String fragmentName = getIntent().getStringExtra("Start_Fragment");
        if (fragmentName != null) {
            try {
                return SettingsFragmentType.valueOf(fragmentName);
            } catch (IllegalArgumentException e) {
                return SettingsFragmentType.GENERAL;
            }
        }
        return SettingsFragmentType.START_FRAGMENT;
    }

    private Fragment getFragmentType(SettingsFragmentType type){

        Fragment fragment;
        switch (type){
            case DESIGN: {
                fragment = new DesignFragment();
                break;
            }
            case EXPERIMENTAL_FUNCTION: {
                fragment = new ExperimentalFunctionFragment();
                break;
            }
            case DATA_USAGE: {
                fragment = new DataUsageFragment();
                break;
            }
            case NOTIFICATIONS_AND_SOUND: {
                fragment = new NotificationsAndSoundFragment();
                break;
            }
            case START_FRAGMENT:
                case GENERAL:
                    default:{
                fragment = new GeneralSettingsFragment();
                break;
            }
        }
        return fragment;
    }

    private void setStartFragment(SettingsFragmentType type){
        Fragment fragment = getFragmentType(type);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settingsFrameLayout, fragment)
                .commit();
    }
}
