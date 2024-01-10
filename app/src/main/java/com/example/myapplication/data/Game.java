package com.example.myapplication.data;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Cette classe représente les propriétés comme le titre, la date et le studio.
public class Game {
    private String title;
    private String date;
    private String studio;

    // Constructeur pour la classe Game.
    public Game(String title, String date, String studio) {
        this.title = title;
        this.date = date;
        this.studio = studio;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getStudio() {
        return studio;
    }
}


