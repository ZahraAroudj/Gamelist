package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NouveauteActivity extends AppCompatActivity {

    private Button openMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        openMenuButton = findViewById(R.id.menuButton);
        openMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuUtils menuUtils = new MenuUtils();
                menuUtils.showMenuDialog(NouveauteActivity.this);
            }
        });
    }

}