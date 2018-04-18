package com.example.wachuka.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Declare TextViews
    private TextView playerX, playerO, draw, playerTurn;

    //Declare Buttons
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, reset, newGame;

    //Declare variable to track points
    private int playerXPoints = 0;
    private int playerOPoints = 0;
    private int drawPoints = 0;

    //Declare variable to track number of times game is played.
    private int count = 0;

    //Initialize player X turn
    private boolean playerXTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find player X points textView and set it to 0
        playerX = findViewById(R.id.x_points);
        playerX.setText(String.valueOf(playerXPoints));

        //Find player O points textView and set it to 0
        playerO = findViewById(R.id.O_points);
        playerO.setText(String.valueOf(playerOPoints));

        //Find player draw textView and set it to 0
        draw = findViewById(R.id.draw_points);
        draw.setText(String.valueOf(drawPoints));


        //Find player turn textView
        playerTurn = findViewById(R.id.player_turn);
        playerTurn.setText("Player X turn");

        //Find reset button
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        //Find newGame button
        newGame = findViewById(R.id.new_game);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });

        //Find buttons
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        //set OnClicklisteners
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button0:
                if (playerXTurn) {
                    button0.setText("X");
                } else {
                    button0.setText("O");
                }
                button0.setEnabled(false);
                break;
            case R.id.button1:
                if (playerXTurn) {
                    button1.setText("X");
                } else {
                    button1.setText("O");
                }
                button1.setEnabled(false);
                break;
            case R.id.button2:
                if (playerXTurn) {
                    button2.setText("X");
                } else {
                    button2.setText("O");
                }
                button2.setEnabled(false);
                break;

            case R.id.button3:
                if (playerXTurn) {
                    button3.setText("X");
                } else {
                    button3.setText("O");
                }
                button3.setEnabled(false);
                break;

            case R.id.button4:
                if (playerXTurn) {
                    button4.setText("X");
                } else {
                    button4.setText("O");
                }
                button4.setEnabled(false);
                break;

            case R.id.button5:
                if (playerXTurn) {
                    button5.setText("X");
                } else {
                    button5.setText("O");
                }
                button5.setEnabled(false);
                break;
            case R.id.button6:
                if (playerXTurn) {
                    button6.setText("X");
                } else {
                    button6.setText("O");
                }
                button6.setEnabled(false);
                break;

            case R.id.button7:
                if (playerXTurn) {
                    button7.setText("X");
                } else {
                    button7.setText("O");
                }
                button7.setEnabled(false);
                break;

            case R.id.button8:
                if (playerXTurn) {
                    button8.setText("X");
                } else {
                    button8.setText("O");
                }
                button8.setEnabled(false);
                break;
        }

        count++;

        playerXTurn = !playerXTurn;


        if (playerXTurn) {
            playerTurn.setText("Player X Turn");

        } else {
            playerTurn.setText("Player O Turn");
        }


        if (hasWon()) {
            if (!playerXTurn) {
                playerXWin();

            } else {
                playerOWin();
            }

        } else {
            if (count == 9) {
                draw();
            }
        }

    }


    private boolean hasWon() {

        //Get the text in each of the text boxes
        String button01 = button0.getText().toString();
        String button02 = button1.getText().toString();
        String button03 = button2.getText().toString();
        String button04 = button3.getText().toString();
        String button05 = button4.getText().toString();
        String button06 = button5.getText().toString();
        String button07 = button6.getText().toString();
        String button08 = button7.getText().toString();
        String button09 = button8.getText().toString();

        //Compare rows
        if (button01.equals(button02) && button01.equals(button03) && !button01.equals("")) {
            return true;
        }

        if (button04.equals(button05) && button04.equals(button06) && !button04.equals("")) {
            return true;
        }

        if (button07.equals(button08) && button07.equals(button09) && !button07.equals("")) {
            return true;
        }

        //Compare columns
        if (button01.equals(button04) && button01.equals(button07) && !button01.equals("")) {
            return true;
        }
        if (button02.equals(button05) && button02.equals(button08) && !button02.equals("")) {
            return true;
        }
        if (button03.equals(button06) && button03.equals(button09) && !button03.equals("")) {
            return true;
        }

        //Compare diagonals
        if (button01.equals(button05) && button01.equals(button09) && !button01.equals("")) {
            return true;
        }

        if (button03.equals(button05) && button03.equals(button07) && !button03.equals("")) {
            return true;
        }

        return false;

    }

    private void draw() {
        drawPoints = drawPoints + 1;
        Toast.makeText(this, "Game is a draw", Toast.LENGTH_SHORT).show();
        draw.setText(String.valueOf(drawPoints));
        resetGame();
    }

    private void playerXWin() {
        Toast.makeText(this, "Player X Wins!", Toast.LENGTH_SHORT).show();
        playerXPoints = playerXPoints + 1;
        playerX.setText(String.valueOf(playerXPoints));
        resetGame();
    }

    private void playerOWin() {

        Toast.makeText(this, "Player O Wins", Toast.LENGTH_SHORT).show();
        playerOPoints = playerOPoints + 1;
        playerO.setText(String.valueOf(playerOPoints));
        resetGame();
    }

    private void resetGame() {

        button0.setText("");
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");

        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);

        count = 0;
    }

    public void newGame() {
        playerXPoints = 0;
        playerX.setText(String.valueOf(playerXPoints));
        playerOPoints = 0;
        playerO.setText(String.valueOf(playerOPoints));
        drawPoints = 0;
        draw.setText(String.valueOf(drawPoints));
        resetGame();
    }
}