package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int totalA = 0;
    int totalB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //add three points
    public void threePointerA(View view) {
        totalA += 3;
        displayForTeamA(totalA);

    }

    public void freeThrowA(View view) {
        totalA += 1;
        displayForTeamA(totalA);

    }

    public void twoPointerA(View view) {
        totalA += 2;
        displayForTeamA(totalA);

    }

    //add three points
    public void threePointerB(View view) {
        totalB += 3;
        displayForTeamB(totalB);

    }

    public void freeThrowB(View view) {
        totalB += 1;
        displayForTeamB(totalB);

    }

    public void twoPointerB(View view) {
        totalB += 2;
        displayForTeamB(totalB);

    }

    public void resetScores(View view) {
        totalA = 0;
        totalB = 0;
        displayForTeamA(totalA);
        displayForTeamB(totalB);
    }

    private void displayForTeamA(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.team_a_score);
        quantityTextView.setText("" + number);
    }

    private void displayForTeamB(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.team_b_score);
        quantityTextView.setText("" + number);
    }


}

