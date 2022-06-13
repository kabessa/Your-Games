package com.example.exemplotoolbar.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplotoolbar.R;
import com.example.exemplotoolbar.databinding.ActivityMainBinding;

public class Informacoes extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);


        ImageView img = findViewById(R.id.imageGame);

        TextView text = findViewById(R.id.textTitle);


        String title = getIntent().getStringExtra("title");
        int imgVal = getIntent().getIntExtra("image",R.drawable.arkimage);

        img.setImageResource(imgVal);
        text.setText(title);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_help){
            Toast.makeText(this, "Clicou na Ajuda!",Toast.LENGTH_SHORT).show();
            return true;}
        else if(id == R.id.versao) {
            Toast.makeText(this, "Clicou na Versão!",Toast.LENGTH_SHORT).show();
            return true;}
        else if(id == R.id.action_settings) {
            Toast.makeText(this, "Settings!",Toast.LENGTH_SHORT).show();
            return true;}
        else if(id == R.id.pesquisa) {
            Toast.makeText(this, "Clicou no Search!",Toast.LENGTH_SHORT).show();}
        return super.onOptionsItemSelected(item);}
}