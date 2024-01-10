package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DB.Accountable;
import com.example.myapplication.data.UserBean;

public class InscriptionActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Password;
    private EditText CONFIRM;
    private Button creerCompteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        Name = findViewById(R.id.identifiantEditText);
        Email = findViewById(R.id.emailEditText);
        Password = findViewById(R.id.motDePasseEditText);
        CONFIRM = findViewById(R.id.confirmeEditText);
        creerCompteButton = findViewById(R.id.creerCompteButton);


        creerCompteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String confirmPassword = CONFIRM.getText().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            TextView errorTextView = findViewById(R.id.errorTextView);
            errorTextView.setText("Veuillez remplir tous les champs");
            return;
        }

        // Vérifier si le mot de passe et la confirmation du mot de passe sont les mêmes
        if (!password.equals(confirmPassword)) {
            TextView errorTextView = findViewById(R.id.errorTextView);
            errorTextView.setText("Les mots de passe ne correspondent pas");
            return;
        }

        // Créer un nouvel objet UserBean
        UserBean user = new UserBean(name, email, password);

        // Ajouter l'utilisateur à la base de données
        Accountable db = new Accountable(getApplicationContext());
        boolean success = db.addUser(user);

        if (success) {
            Toast.makeText(getApplicationContext(), "Compte créé avec succès", Toast.LENGTH_SHORT).show();

            // Rediriger vers l'activité d'accueil
            Intent intent = new Intent(InscriptionActivity.this, AccueilActivity.class);
            startActivity(intent);
            finish();
        } else {
            TextView errorTextView = findViewById(R.id.errorTextView);
            errorTextView.setText("Échec de la création du compte");
        }
    }
}