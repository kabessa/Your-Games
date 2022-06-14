package com.example.yourgames.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.yourgames.R;

public class UserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Parte onde infla o layout para este fragmento.
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
}