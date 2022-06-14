package com.example.yourgames;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yourgames.model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class UserActivity extends AppCompatActivity {

    // Criando objetos.
    TabLayout choice_table;
    ViewPager2 preview_page;
    PagerAdapter pagerAdapter;
    private TextView save_user;
    private TextView save_email;
    private Button button_logout;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String user_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Iniciando método StartComponents.
        StartComponents();
        save_user = findViewById(R.id.save_user);

        //
        FragmentManager fragmentManager = getSupportFragmentManager();
        pagerAdapter = new PagerAdapter(fragmentManager, getLifecycle());
        preview_page.setAdapter(pagerAdapter);

        //
        choice_table.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                preview_page.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //
        preview_page.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                choice_table.selectTab(choice_table.getTabAt(position));
            }
        });

        // Criando um evento de clique para o botão deslogar.
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Método para sair da sessão e mandando o usuário pra tela de login.
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Parte onde recebe o usuário atual e seu id.
        user_ID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //
        DocumentReference documentReference = db.collection("Usuários").document(user_ID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null) {
                    Log.d("add", documentSnapshot.getData().toString());

                    User usuario = documentSnapshot.toObject(User.class);
                    button_logout.setText(usuario.getNome());
                }
            }
        });
    }

    //
    @Override
    protected void onStart() {
        super.onStart();


    }

    // Conectando objetos a uma referência.
    private void StartComponents() {
        choice_table = findViewById(R.id.choice_table);
        preview_page = findViewById(R.id.preview_page);
        save_email = findViewById(R.id.save_email);
        button_logout = findViewById(R.id.button_logout);
    }
}