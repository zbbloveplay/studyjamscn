package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     *   +1 +2 +3
     * A  1  2  3
     * B  4  5  6
     * */
    int undo_flag = 0;

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    Button bt_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_reset =(Button) findViewById(R.id.bt_reset);
        bt_reset.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                //Toast.makeText(MainActivity.this,"正在识别二维码", Toast.LENGTH_SHORT).show();
                scoreTeamA = 0;
                scoreTeamB = 0;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);

                return true;
            }
        });
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA ++;
        displayForTeamA(scoreTeamA);
        undo_flag = 1;
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
        undo_flag = 2;
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
        undo_flag = 3;
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB ++;
        displayForTeamB(scoreTeamB);
        undo_flag = 4;
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
        undo_flag = 5;
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
        undo_flag = 6;
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetScore(View v) {
        switch (undo_flag){
            case 1 :
                scoreTeamA = scoreTeamA - 1;displayForTeamA(scoreTeamA);undo_flag = 0;break;
            case 2 :
                scoreTeamA = scoreTeamA - 2;displayForTeamA(scoreTeamA);undo_flag = 0;break;
            case 3 :
                scoreTeamA = scoreTeamA - 3;displayForTeamA(scoreTeamA);undo_flag = 0;break;
            case 4 :
                scoreTeamB = scoreTeamB - 1;displayForTeamB(scoreTeamB);undo_flag = 0;break;
            case 5 :
                scoreTeamB = scoreTeamB - 2;displayForTeamB(scoreTeamB);undo_flag = 0;break;
            case 6 :
                scoreTeamB = scoreTeamB - 3;displayForTeamB(scoreTeamB);undo_flag = 0;break;
            default:
                undo_flag = 0;
                Toast.makeText(MainActivity.this,"不能再回退了",Toast.LENGTH_LONG).show();
                break;
        }
    }

}