package com.example.exemplotoolbar.ui.home;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplotoolbar.R;
import com.example.exemplotoolbar.RecylcerViewAdapter;
import com.example.exemplotoolbar.databinding.FragmentGalleryBinding;
import com.example.exemplotoolbar.databinding.FragmentHomeBinding;
import com.example.exemplotoolbar.ui.gallery.GalleryFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private AdapterView.OnItemClickListener listener;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecylcerViewAdapter recylcerViewAdapter;
    ArrayList<Integer>icons = new ArrayList<>();
    ArrayList<String>names = new ArrayList<>();
    ArrayList<String>precos = new ArrayList<>();



    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
       Class galery = GalleryFragment.class;
       View root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home,container,false);

        icons.add(R.drawable.arkimage);
        icons.add(R.drawable.miranhaimg);
        icons.add(R.drawable.r2image);

        names.add("ARK: Survival Evolved");
        names.add("Homem-Aranha");
        names.add("Resident Evil 2");

        precos.add("Comprar R$ 250,00");
        precos.add("Comprar R$ 250,00");
        precos.add("Comprar R$ 250,00");

        recyclerView = root.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recylcerViewAdapter = new RecylcerViewAdapter(icons,names,precos,this,galery);
        recyclerView.setAdapter(recylcerViewAdapter);
        recyclerView.setHasFixedSize(true);

        return root;
    }

@Override
    public void onDestroyView() {
    super.onDestroyView();
    binding = null;
}


}