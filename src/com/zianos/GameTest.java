package com.zianos;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by andrew on 1/23/17.
 */
public class GameTest {

    @Test
    @DisplayName("Test: Board Size")
    void testSizeConstructor(){
        final int HEIGHT = 5;

        Game game = new Game(HEIGHT);

        boolean board[][] = game.getBoard();

        assertEquals(board.length, HEIGHT, "Incorrect number of Rows");
        assertEquals(board[0].length, HEIGHT, "Incorrect number of Columns");
    }

    @Test
    @DisplayName("Test: Toad Oscillator")
    void testToad(){
        final boolean[][] STATE_ONE = {
                {false, false, false, false, false, false},
                {false, false, true, true, true, false},
                {false, true, true, true, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
        };

        final boolean[][] STATE_TWO= {
                {false, false, false, true, false, false},
                {false, true, false, false, true, false},
                {false, true, false, false, true, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false},



        };

        Game game = new Game(STATE_ONE);
        assertArrayEquals(game.getBoard(),STATE_ONE);

        game.step();
        assertArrayEquals(game.getBoard(),STATE_TWO);
    }

    @Test
    @DisplayName("Test: Block Still Life")
    void testBlock(){
        final boolean[][] STATE_BLOCK = {
                {false, false, false},
                {false, true, true},
                {false, true, true},
                {false, false, false},

        };

        Game game = new Game(STATE_BLOCK);
        assertArrayEquals(game.getBoard(), STATE_BLOCK);

        game.step();
        assertArrayEquals(game.getBoard(), STATE_BLOCK);

        game.step();
        assertArrayEquals(game.getBoard(), STATE_BLOCK);
    }

    @Test
    @DisplayName("Test: Glider")
    public void TestGlider(){
        final boolean[][] STATE_ONE = {
                {false, true, false, false, false, false, false},
                {false, false, true, false, false, false, false},
                {true, true, true, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
        };

        final boolean[][] STATE_TWO = {
                {false, false, false, false, false, false, false},
                {true, false, true, false, false, false, false},
                {false, true, true, false, false, false, false},
                {false, true, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
        };

        final boolean[][] STATE_THREE = {
                {false, false, false, false, false, false, false},
                {false, false, true, false, false, false, false},
                {true, false, true, false, false, false, false},
                {false, true, true, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
        };

        Game game = new Game(STATE_ONE);
        assertArrayEquals(game.getBoard(), STATE_ONE);

        game.step();
        assertArrayEquals(game.getBoard(), STATE_TWO);

        game.step();
        assertArrayEquals(game.getBoard(), STATE_THREE);
        game.print();
    }
}
