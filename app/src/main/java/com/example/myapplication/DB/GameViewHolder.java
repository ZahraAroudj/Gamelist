package com.example.myapplication.DB;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class GameViewHolder extends RecyclerView.ViewHolder {
    public TextView gameTitle;
    public TextView gameDate;
    public TextView gameStudio;

    public GameViewHolder(View itemView) {
        super(itemView);
        gameTitle = itemView.findViewById(R.id.game_title);
        gameDate = itemView.findViewById(R.id.game_date);
        gameStudio = itemView.findViewById(R.id.game_studio);
    }
}
