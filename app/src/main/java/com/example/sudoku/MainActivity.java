package com.example.sudoku;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button gameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameButton = findViewById(R.id.game_button);

        gameButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        int itemId = item.getItemId();
        if (itemId == R.id.setting) {
            Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
            MainActivity.this.startActivity(intent);
            return true;
        } else if (itemId == R.id.about) {
            new AlertDialog.Builder(this)
                    .setTitle("Sudoku Game")
                    .setMessage("Sudoku is a logic-based, combinatorial number-placement puzzle..")
                    .setNeutralButton(android.R.string.ok, null)
                    .show();
            return true;
        }
        return false;
    }

}