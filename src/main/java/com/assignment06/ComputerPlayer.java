package com.assignment06;
import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player {

    public ComputerPlayer(char marker, String name) {
        super(marker, name);
    }

    private void printMove(int row, int col) {
        // displays the computer's selected row and column
        System.out.printf("%s with %c - Computer Selection for Row: %d\n", this.name, this.marker, row);
        System.out.printf("%s with %c - Computer Selection for Column: %d\n", this.name, this.marker, col);
    }

    // checks if the computer can win by placing a piece on a valid move
    private boolean prioritizeWinning(Board board) {
        for (int row = 1; row <= board.boardState.length; row++) {
            for (int col = 1; col <= board.boardState[0].length; col++) {
                if (board.isValidMove(row, col)) {
                    board.setMove(row, col, this.marker);
                    if (board.checkWin(this.marker)) {
                        printMove(row, col);
                        return true;
                    }
                    board.setMove(row, col, '-');
                }
            }
        }
        return false;
    }

    // checks if the opponent can win and blocks their move
    private boolean blockOpponent(Board board) {
        char opponentMarker = (this.marker == 'X') ? 'O' : 'X';

        for (int row = 1; row <= board.boardState.length; row++) {
            for (int col = 1; col <= board.boardState[0].length; col++) {
                if (board.isValidMove(row, col)) {
                    board.setMove(row, col, opponentMarker);
                    if (board.checkWin(opponentMarker)) {
                        printMove(row, col);
                        board.setMove(row, col, this.marker);
                        return true;
                    }
                    board.setMove(row, col, '-');
                }
            }
        }
        return false;
    }

    // tries to place the piece in the center if available
    private boolean chooseCenter(Board board) {
        int middleRow = board.boardState.length / 2 + 1;
        int middleCol = board.boardState[0].length / 2 + 1;
        if (board.boardState[middleRow - 1][middleCol - 1] == '-') {
            printMove(middleRow, middleCol);
            board.setMove(middleRow, middleCol, this.marker);
            return true;
        }
        return false;
    }

    // tries to place the piece in a corner if available
    private boolean chooseCorner(Board board) {
        int size = board.boardState.length;
        if (board.boardState[0][0] == '-') {
            printMove(1, 1);
            board.setMove(1, 1, this.marker);
            return true;
        } else if (board.boardState[0][size - 1] == '-') {
            printMove(1, size);
            board.setMove(1, size, this.marker);
            return true;
        } else if (board.boardState[size - 1][0] == '-') {
            printMove(size, 1);
            board.setMove(size, 1, this.marker);
            return true;
        } else if (board.boardState[size - 1][size - 1] == '-') {
            printMove(size, size);
            board.setMove(size, size, this.marker);
            return true;
        }
        return false;
    }

    //if no optimal move found, play a random move
    private void playRandom(Board board) {
        int row, col;
        Random rand = new Random();
        do {
            row = rand.nextInt(board.boardState.length) + 1;
            col = rand.nextInt(board.boardState[0].length) + 1;
        } while (!board.isValidMove(row, col));

        printMove(row, col);
        board.setMove(row, col, this.marker);
    }

    public void makeMove(Board board, Scanner scanner) {
        // attempt to make the best move by prioritizing winning, blocking, center, corner, then random
        if (prioritizeWinning(board)) return;
        if (blockOpponent(board)) return;
        if (chooseCenter(board)) return;
        if (chooseCorner(board)) return;
        playRandom(board);
    }
}
