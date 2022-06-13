package com.example.exemplotoolbar.ui.nordeste;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.exemplotoolbar.databinding.FragmentNordesteBinding;
import com.example.exemplotoolbar.databinding.FragmentSlideshowBinding;

public class NordesteFragment extends Fragment {

private FragmentNordesteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {


    binding = FragmentNordesteBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}