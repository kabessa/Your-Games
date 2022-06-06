package com.example.finalprojectapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    // Criando objetos.
    private EditText register_name;
    private EditText register_email;
    private EditText register_password;
    private Button button_register;
    private TextView login_link;

    // Criando um Array de String pra mensagens.
    String[] message = {"Preencha todos os campos", "Cadastro realizado com sucesso"};

    String user_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Parte responsável por esconder a ActionBar e exibir a tela em FullScreen.
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Iniciando método StartComponents.
        StartComponents();

        // Definindo um OnClick para o botão cadastrar.
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Captura o que o usuário está digitando.
                String name = register_name.getText().toString();
                String email = register_email.getText().toString();
                String password = register_password.getText().toString();

                // Parte responsável por fazer as verificações.
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, message[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }

                else {
                    RegisterUser(view);
                }
            }
        });

        // Definindo um OnClick e redirecionando para o LoginActivity.
        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método de cadastrar usuário.
    private void RegisterUser(View view) {

        // Captura o que o usuário está digitando.
        String email = register_email.getText().toString();
        String password = register_password.getText().toString();

        // Iniciar FirebaseAuth para cadastrar o usuário.
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                // Realizando as verificações e mensagens de erro.
                if (task.isSuccessful()) {

                    // Inicializando o método para salvar os dados do usuário.
                    SaveUserData();

                    Snackbar snackbar = Snackbar.make(view, message[1], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
                else {
                    String failure;
                    try {
                        throw task.getException();
                    }
                    catch (FirebaseAuthWeakPasswordException exception) {
                        failure = "Senha muito pequena";
                    }
                    catch (FirebaseAuthUserCollisionException exception) {
                        failure = "Conta já existente";
                    }
                    catch (FirebaseAuthInvalidCredentialsException exception) {
                        failure = "E-mail Inválido";
                    }
                    catch (Exception exception) {
                        failure = "Erro ao cadastrar";
                    }

                    Snackbar snackbar = Snackbar.make(view, failure, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }

    // Criando um método pra salvar os dados do usuário.
    private void SaveUserData() {

        // Captura o que o usuário está digitando.
        String name = register_name.getText().toString();

        // Inicializando o banco de dados Firestore.
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("nome", name);

        // Pega o ID de cada usuário.
        user_ID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Criando uma coleção de usuários.
        DocumentReference documentReference = db.collection("Usuários").document(user_ID);
        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db_successful", "Dados salvos com sucesso");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("db_failure", "Erro ao salvar os dados" + e.toString());
            }
        });
    }

    // Conectando objetos a uma referência.
    private void StartComponents() {
        register_name = findViewById(R.id.register_name);
        register_email = findViewById(R.id.register_email);
        register_password = findViewById(R.id.register_password);
        button_register = findViewById(R.id.button_register);
        login_link = findViewById(R.id.login_link);
    }
}