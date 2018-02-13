package com.tictactoe;

/**
 * Created by avshaloms on 13/02/2018.
 */
public class TicTacToe {
    private static final char EMPTY  = '\0';
    private Character[][] board = {
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY}
    };

    public void play(int x, int y) {
        checkAxis(x, "X outside board");
        checkAxis(y, "Y outside board");
        setBox(board[x - 1], y);
    }

    private void setBox(Character[] characters, int y) {
        if(characters[y-1] != EMPTY)
            throw new RuntimeException("Box is occupied");

        characters[y-1] = 'X';
    }

    private void checkAxis(int axis, String message) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException(message);
    }
}
