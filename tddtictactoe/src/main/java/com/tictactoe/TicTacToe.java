package com.tictactoe;

/**
 * Created by avshaloms on 13/02/2018.
 */
public class TicTacToe {
    private static final char EMPTY  = '\0';
    public static final int SIZE = 3;
    private char lastPlayer  = '\0';
    private Character[][] board = {
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY}
    };

    public String play(int x, int y) {
        checkAxis(x, "X outside board");
        checkAxis(y, "Y outside board");
        lastPlayer = nextPlayer();
        setBox(board[x - 1], y);
        if (isWin()) return lastPlayer + " is the winner";

        return "No winner";
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * SIZE;
        for(int i = 0; i < SIZE; i++){
            if(board[0][i] + board[1][i] + board[2][i] == playerTotal)
                return true;
            if(board[i][0] + board[i][1] + board[i][2] == playerTotal)
                return true;
        }

        if(board[0][0] + board[1][1] + board[2][2] == playerTotal)
            return true;

        if(board[0][2] + board[1][1] + board[2][0] == playerTotal)
            return true;


        return false;
    }

    private void setBox(Character[] characters, int y) {
        if(characters[y-1] != EMPTY)
            throw new RuntimeException("Box is occupied");

        characters[y-1] = lastPlayer;
    }

    private void checkAxis(int axis, String message) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException(message);
    }

    public char nextPlayer() {
        if(lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }
}
