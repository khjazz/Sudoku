package com.example.sudoku;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    PuzzleAdapter adapter;
    ArrayList<Integer> numList;
    RecyclerView recyclerView;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(this, R.raw.game_bgm);
        setContentView(R.layout.activity_game);

        numList = new ArrayList<>();
        for(int i = 0; i < 9*9; i++) {
            numList.add(i);
        }
        adapter = new PuzzleAdapter(this, numList);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager (GameActivity.this, 9));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

}