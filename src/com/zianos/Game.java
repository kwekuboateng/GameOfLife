package com.zianos;

import java.util.Random;

/**
 * Created by andrew on 1/13/17.
 */
public class Game {



    private boolean[][] board;

    /*
     * Invalid Constructor; should never be called
     */
    private Game(){
    }

    /*
     * Constructs the game and populate the board with random values.
     */
    public Game(int height){
        this.board = new boolean[height][height];
        int[][] test;

        Random r = new Random();
        for(int i = 0; i < height; i++) {
            boolean[] row = this.board[i];

            for (int j = 0; j < row.length; j++) {
                this.board[i][j] = r.nextBoolean();
            }
        }
    }

    /*
     * Constructs the Game and sets the game's board to the parameter board
     * @param board A two dimensional boolean array that represents a board
     */
    public Game(boolean[][] board){
        this.board = board;
    }

    /*
     *Runs through one iteration of the game and modifies the state of the board
     */
    public void step(){
        // Assuming the board is square
        boolean[][] tempBoard = new boolean[this.board.length][this.board[0].length];
        for(int i = 0; i < this.board.length; i++){
            boolean[] row = this.board[i];

            for(int j = 0; j < row.length; j++){
                tempBoard[i][j] = isAlive(this.board[i][j], getLivingNeighbors(i, j));
            }
        }
        this.board = tempBoard;

    }

    /*
     * Prints text representing the board to stdout
     */
    public void print(){
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board.length; j++){
                System.out.print(this.board[i][j] ? "x " : "  ");
            }
            System.out.println("");
        }

    }

    /*
     * Grabs the number of neighbors that touch a cell
     * @param row The cell row number
     * @param column The cell column number
     * @return The number of surrounding cells that are alive
     */
    private int getLivingNeighbors(int row, int column){
        int livingNeighbors = 0;

        for(int i = row  - 1; i <= (row + 1); i++){
            for(int j = column - 1; j <= (column + 1); j++){
                if((row == i) && (column == j)){
                    continue;
                }
                if(isValidCell(i, j)){
                    boolean cell = this.board[i][j];

                    livingNeighbors += this.board[i][j] ? 1 : 0;
                }
            }
        }

        return livingNeighbors;
    }

    /*
     * Makes sure the inputted row/column are valid
     * <p>
     * Checks that the row/column are within the array's bounds.
     * </p>
     *
     * @param row The cell row number
     * @param column The cell column number
     * @return Whether or not a cell is valid
     */
    private boolean isValidCell(int row, int column){
        return (row >= 0) && (row < this.board.length) &&
                (column >= 0) && (column < this.board[0].length);
    }

    /*
     * Determines whether a cell is living based upon GoL rules
     *
     * @param currentlyLiving the current state of the cell
     * @param neighbors The number of neighbors the cell has
     */
    private boolean isAlive(boolean currentlyLiving, int livingNeighbors){
        boolean alive = false;

        if(currentlyLiving){
            if((livingNeighbors == 2) || (livingNeighbors == 3)){
                alive = true;
            }
        } else {
            if(livingNeighbors == 3){
                alive = true;
            }
        }

        return alive;
    }

    public boolean[][] getBoard() {
        return board;
    }
}
