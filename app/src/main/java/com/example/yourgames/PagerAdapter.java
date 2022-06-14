package com.example.yourgames;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.yourgames.fragments.SellerFragment;
import com.example.yourgames.fragments.UserFragment;

public class PagerAdapter extends FragmentStateAdapter {

    // Criando construtor.
    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    // Criando métodos.
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SellerFragment();
            default:
                return new UserFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}