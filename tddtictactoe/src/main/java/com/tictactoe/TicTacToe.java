package com.tictactoe;

/**
 * Created by avshaloms on 13/02/2018.
 */
public class TicTacToe {
    public void play(int x, int y) {
        if(x < 1 || x > 3)
            throw new RuntimeException("X outside board");

        if(y < 1 || y > 3)
            throw new RuntimeException("Y outside board");
    }
}
