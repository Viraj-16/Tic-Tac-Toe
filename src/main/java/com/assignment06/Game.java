package com.assignment06;

import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    protected Board theBoard;

    public Game(boolean isPlayer1Human, char marker1, boolean isPlayer2Human, char marker2) {
        //initialize player1 as either HumanPlayer or ComputerPlayer based on the input
        if (isPlayer1Human) {
            player1 = new HumanPlayer(marker1, "Player 1");
        } else {
            player1 = new ComputerPlayer(marker1, "Player 1");
        }

        //initialize player2 as either HumanPlayer or ComputerPlayer based on the input
        if (isPlayer2Human) {
            player2 = new HumanPlayer(marker2, "Player 2");
        } else {
            player2 = new ComputerPlayer(marker2, "Player 2");
        }

        //create a new Board object
        theBoard = new Board();
    }

    public void playGame(Scanner scanner) {
        Player currentPlayer = player1;
        int totalMoves = theBoard.boardState.length * theBoard.boardState[0].length;

        //loop for the total number of moves
        for (int moveCount = 0; moveCount < totalMoves; moveCount++) {
            //display the current state of the board
            theBoard.displayBoard();

            System.out.printf("turn: %s (%c)\n", currentPlayer.getName(), currentPlayer.getMarker());

            currentPlayer.makeMove(theBoard, scanner);

            // check if the current player has won the game
            if (theBoard.checkWin(currentPlayer.getMarker())) {
                theBoard.displayBoard();
                System.out.printf("%s (%c) wins!\n", currentPlayer.getName(), currentPlayer.getMarker());
                return;
            }

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }

        // if the loop ends without a winner, it's a draw
        theBoard.displayBoard();
        System.out.println("it's a draw!");
    }
}
