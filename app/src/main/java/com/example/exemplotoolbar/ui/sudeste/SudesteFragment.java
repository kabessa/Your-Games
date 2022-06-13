package com.example.exemplotoolbar.ui.sudeste;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.exemplotoolbar.databinding.FragmentNordesteBinding;
import com.example.exemplotoolbar.databinding.FragmentSudesteBinding;

public class SudesteFragment extends Fragment {

private FragmentSudesteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {


    binding = FragmentSudesteBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}