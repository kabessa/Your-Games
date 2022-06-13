package com.example.exemplotoolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplotoolbar.databinding.FragmentGalleryBinding;
import com.example.exemplotoolbar.ui.Informacoes;
import com.example.exemplotoolbar.ui.gallery.GalleryFragment;
import com.example.exemplotoolbar.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class RecylcerViewAdapter extends RecyclerView.Adapter<RecylcerViewAdapter.MyViewHolder>{
    GalleryFragment gallery = new GalleryFragment();




    public RecylcerViewAdapter(ArrayList arr, ArrayList arr2, ArrayList arr3, Fragment frag,Class info) {
        this.array1 = arr;
        this.array2 = arr2;
        this.array3 = arr3;
        this.fragment = frag;
        this.fragInfo = info;
    }
    ArrayList<Integer>array1 = new ArrayList<>();
    ArrayList<String>array2 = new ArrayList<>();
    ArrayList<String>array3 = new ArrayList<>();
    Fragment fragment;
    Class fragInfo;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
        MyViewHolder myViewHolder =  new MyViewHolder(view);

        return myViewHolder;





    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(array1.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(holder.textView.getContext(), Informacoes.class);
               intent.putExtra("image",array1.get(position));
               intent.putExtra("title",array2.get(position));



               holder.itemView.getContext().startActivity(intent);


           }
        });

        holder.textView.setText(array2.get(position));
        holder.button1.setText(array3.get(position));
        holder.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Favoritou "+holder.textView.getText(),Toast.LENGTH_SHORT).show();
            }


        });


    }



    @Override
    public int getItemCount() {
        return array1.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        Button button1;
        Button button2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
            button1 = itemView.findViewById(R.id.button);
            button2 = itemView.findViewById(R.id.button2);



           imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {


                    NavHostFragment.findNavController(fragment)
                            .navigate(R.id.nav_centroeste);


                    Toast.makeText(itemView.getContext(), "clicou ",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
