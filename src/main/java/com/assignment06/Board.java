package com.assignment06;

public class Board {
    protected char[][] boardState;

    //constructor to initialize the board
    public Board() {
        boardState = new char[3][3];
        initializeBoard();
    }

    //initialize the board with empty cells
    protected void initializeBoard() {
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                boardState[i][j] = '-';
            }
        }
    }

    //check if a move is valid
    public boolean isValidMove(int row, int col) {
        return row >= 1 && row <= boardState.length &&
               col >= 1 && col <= boardState[0].length &&
               boardState[row - 1][col - 1] == '-';
    }

    //place the player's marker on the board
    public void setMove(int row, int col, char marker) {
        boardState[row - 1][col - 1] = marker;
    }

    //check if the player with the given symbol has won
    public boolean checkWin(char symbol) {
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
    }

    //check all rows for a winning condition
    private boolean checkRows(char symbol) {
        for (char[] row : boardState) {
            int count = 0; //counter for checking consecutive symbols
            for (char cell : row) {
                if (cell == symbol) {
                    count++; //increment counter if cell matches symbol
                } else {
                    count = 0; //reset counter if cell doesn't match
                }
                if (count == boardState.length) {
                    return true; //win condition met
                }
            }
        }
        return false;
    }

    // check all columns for a winning condition
    private boolean checkColumns(char symbol) {
        for (int col = 0; col < boardState[0].length; col++) {
            int count = 0; // counter for consecutive symbols in column
            for (int row = 0; row < boardState.length; row++) {
                if (boardState[row][col] == symbol) {
                    count++; // increment counter if cell matches symbol
                } else {
                    count = 0; // reset counter if cell doesn't match
                }
                if (count == boardState.length) {
                    return true; // win condition met
                }
            }
        }
        return false;
    }

    //check both main and anti diagonals for a winning condition
    private boolean checkDiagonals(char symbol) {
        int size = boardState.length;
        int countMain = 0; // counter for main diagonal
        int countAnti = 0; // counter for anti-diagonal

        for (int i = 0; i < size; i++) {
            //check main diagonal of board
            if (boardState[i][i] == symbol) {
                countMain++;
            } else {
                countMain = 0;
            }

            //check anti diagonal of board
            if (boardState[i][size - i - 1] == symbol) {
                countAnti++;
            } else {
                countAnti = 0;
            }
        }

        //return true if either diagonal has all symbols
        return countMain == size || countAnti == size;
    }

    //display the current board state in the console
    public void displayBoard() {
        for (char[] row : boardState) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
