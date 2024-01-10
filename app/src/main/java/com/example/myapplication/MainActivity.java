package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DB.Accountable;
import com.example.myapplication.data.UserBean;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button createAccountButton;

    private EditText usernameEditText;
    private EditText passwordEditText;

    private Accountable accountDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountDB = new Accountable(this);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    UserBean user = accountDB.getUserByEmail(username);

                    if (user != null && user.getPassword().equals(password)) {
                        // Rediriger vers l'activité d'accueil
                        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Afficher une boîte de dialogue indiquant que le mot de passe est incorrect ou que l'utilisateur n'existe pas
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Erreur");
                        builder.setMessage("Le mot de passe est incorrect ou l'utilisateur n'existe pas.");
                        builder.setPositiveButton("OK", null);
                        builder.show();
                    }
                }
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers l'inscription
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
    }


}

