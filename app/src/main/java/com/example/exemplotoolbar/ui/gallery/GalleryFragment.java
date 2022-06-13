package com.example.exemplotoolbar.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplotoolbar.R;
import com.example.exemplotoolbar.RecylcerViewAdapter;
import com.example.exemplotoolbar.databinding.FragmentGalleryBinding;
import com.example.exemplotoolbar.ui.home.HomeFragment;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecylcerViewAdapter recylcerViewAdapter;


    public ArrayList<Integer> icons = new ArrayList<>();
    public ArrayList<String>names = new ArrayList<>();
    public ArrayList<String>precos = new ArrayList<>();

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home,container,false);

        icons.add(R.drawable.arkimage);
        icons.add(R.drawable.r2image);

        names.add("ark");
        names.add("resident");

        precos.add("Comprar R$ 250,00");
        precos.add("Comprar R$ 250,00");

        Class home = HomeFragment.class;
        recyclerView = root.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recylcerViewAdapter = new RecylcerViewAdapter(icons,names,precos,this,home);

        recyclerView.setAdapter(recylcerViewAdapter);
        recyclerView.setHasFixedSize(true);
        return root;
    }
}