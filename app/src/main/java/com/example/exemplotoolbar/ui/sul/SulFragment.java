package com.example.exemplotoolbar.ui.sul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.exemplotoolbar.databinding.FragmentGalleryBinding;
import com.example.exemplotoolbar.databinding.FragmentSulBinding;

public class SulFragment extends Fragment {

private FragmentSulBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

    binding = FragmentSulBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}