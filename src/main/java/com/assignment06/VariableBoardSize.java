package com.assignment06;

public class VariableBoardSize extends Board {
    //store the grid size of the board
    private final int gridSize;

    //store the win condition length
    private final int winCondition;

    //constructor to initialize the board with a given size and win condition
    public VariableBoardSize(int size, int connect) {
        super(); 
        this.gridSize = size;
        this.winCondition = connect;
        super.boardState = new char[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                super.boardState[i][j] = '-';
            }
        }
    }

    //method to check if there is a victory for a symbol
    public boolean checkWin(char symbol) {
        char[][] board = this.boardState;

        //check each row and column for a winning condition
        for (int i = 0; i < gridSize; i++) {
            if (checkRow(board, i, symbol) || checkColumn(board, i, symbol)) {
                return true; 
            }
        }
        //check the diagonals for a winning condition
        return checkDiagonals(board, symbol);
    }

    //helper method to check if there is a winning row for a given symbol
    private boolean checkRow(char[][] board, int row, char symbol) {
        int count = 0;
        //iterate through each column in the row
        for (int col = 0; col < gridSize; col++) {
            //increment count if the symbol matches
            count = (board[row][col] == symbol) ? count + 1 : 0;
            if (count == winCondition) return true;
        }
        return false;  //no winning row found
    }

    //helper method to check if there is a winning column for a given symbol
    private boolean checkColumn(char[][] board, int col, char symbol) {
        int count = 0;
        //iterate through each row in the column
        for (int row = 0; row < gridSize; row++) {
            //increment count if the symbol matches
            count = (board[row][col] == symbol) ? count + 1 : 0;
            if (count == winCondition) return true; 
        }
        return false; 
    }

    // helper method to check if there are any winning diagonals for a given symbol
    private boolean checkDiagonals(char[][] board, char symbol) {
        //check all possible diagonal starting points
        for (int start = 0; start <= gridSize - winCondition; start++) {
            int countMain = 0, countAnti = 0;
            // check both diagonals
            for (int i = 0; i < winCondition; i++) {
                countMain += (board[start + i][start + i] == symbol) ? 1 : 0;
                countAnti += (board[start + i][gridSize - 1 - start - i] == symbol) ? 1 : 0;
            }
            //return true if either diagonal has enough consecutive markers
            if (countMain == winCondition || countAnti == winCondition) return true;
        }
        return false;
    }

    // method to display the current state of the board
    public void displayBoard() {
        for (char[] row : boardState) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println(); 
        }
    }
}
