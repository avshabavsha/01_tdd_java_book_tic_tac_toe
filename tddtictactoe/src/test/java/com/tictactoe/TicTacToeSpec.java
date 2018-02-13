package com.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by avshaloms on 13/02/2018.
 */
public class TicTacToeSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void setup(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(5,2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenOccupiedThenRuntimeException(){
        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXNextPlayerThenO(){
        ticTacToe.play(2,1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

//      Test Already passes so it's useless
//    @Test
//    public void givenLastTurnWasONextPlayerThenX(){
//        ticTacToe.play(2,1);
//        ticTacToe.play(2,2);
//        assertEquals('X', ticTacToe.nextPlayer());
//    }

    @Test
    public void whenPlayedNoWinners(){
        String actual = ticTacToe.play(1,1);
        assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayedHorizontalLineThenWinner(){
        ticTacToe.play(1,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,1); // X
        ticTacToe.play(2,2); // O
        String actual = ticTacToe.play(3, 1);// X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayedVerticalLineThenWinner(){
        ticTacToe.play(2,1); // X
        ticTacToe.play(1,1); // O
        ticTacToe.play(3,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,2); // X
        String actual = ticTacToe.play(1, 3);// O
        assertEquals("O is the winner", actual);
    }

    @Test
    public void whenPlayedAndTopBottomDiagonalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 3); // O
        String actual = ticTacToe.play(3, 3);// X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayedAndBottomTopDiagonalLineThenWinner(){
        ticTacToe.play(1,3); // X
        ticTacToe.play(1,1); // O
        ticTacToe.play(2,2); // X
        ticTacToe.play(1,2); // O
        String actual = ticTacToe.play(3, 1);// X
        assertEquals("X is the winner", actual);
    }
}
