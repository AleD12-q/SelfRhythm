package com.example.cyod.fragment_control;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cyod.R;

abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        var baseView = inflater.inflate(R.layout.base_fragment, container, false);
        var content = (ViewGroup) baseView.findViewById(R.id.frame);
        inflater.inflate(getFragmentId(), content, true);
        return baseView;
    }

    protected abstract int getFragmentId();
}
