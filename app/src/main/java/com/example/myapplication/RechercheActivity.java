package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.DB.GameAdapter;
import com.example.myapplication.data.Game;

import java.util.ArrayList;
import java.util.List;

public class RechercheActivity extends AppCompatActivity {
    private Button openMenuButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        openMenuButton = findViewById(R.id.menuButton);
        openMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuUtils menuUtils = new MenuUtils();
                menuUtils.showMenuDialog(RechercheActivity.this);
            }
        });
        List<Game> games = new ArrayList<>();
        games.add(new Game("The Legend of Zelda: Breath of the Wild", "2017-03-03", "Nintendo"));
        games.add(new Game("The Witcher 3: Wild Hunt", "2015-05-19", "CD Projekt"));
        games.add(new Game("Red Dead Redemption 2", "2018-10-26", "Rockstar Games"));
        games.add(new Game("God of War", "2018-04-20", "Santa Monica Studio"));
        games.add(new Game("Minecraft", "2011-12-13", "Mojang"));
        games.add(new Game("The Last of Us Part II", "2020-06-19", "Naughty Dog"));
        games.add(new Game("Horizon Zero Dawn", "2017-03-03", "Guerrilla Games"));
        games.add(new Game("Super Mario Odyssey", "2017-11-03", "Nintendo"));
        games.add(new Game("The Elder Scrolls V: Skyrim", "2011-11-11", "Bethesda Game Studios"));
        games.add(new Game("Fortnite", "2017-09-26", "Epic Games"));

        RecyclerView recyclerView = findViewById(R.id.gameRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GameAdapter(games));
    }
    }
