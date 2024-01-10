package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.DB.Accountable;
import com.example.myapplication.data.UserBean;

public class CompteActivity extends AppCompatActivity {

    private Button openMenuButton;
    private Accountable accountDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte);

        accountDB = new Accountable(this);

        openMenuButton = findViewById(R.id.menuButton);
        openMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuUtils menuUtils = new MenuUtils();
                menuUtils.showMenuDialog(CompteActivity.this);
            }
        });

        // Récupère l'utilisateur à partir de l'adresse e-mail
        UserBean user = accountDB.getUserByEmail("toto@gmail.com");

    // Permet de Récupère la référence de la TextView dans le layout
        TextView usernameTextView = findViewById(R.id.usernameTextView);

    // Permer de Définir le nom de l'utilisateur dans la TextView
        usernameTextView.setText(user.getName());



        //Faudrait que je vois pour que ça marche

        //String userEmail = getIntent().getStringExtra("email");
        //
        //if (userEmail != null && !userEmail.isEmpty()) {
        //    UserBean user = accountDB.getUserByEmail(userEmail);
        //    TextView usernameTextView = findViewById(R.id.usernameTextView);
        //    usernameTextView.setText(user.getName());
        //} else {
        //    Toast.makeText(this, "L'e-mail est manquant ou invalide", Toast.LENGTH_SHORT).show();
        //    // Autres actions à prendre en cas d'e-mail manquant ou invalide
        //}
    }
}

