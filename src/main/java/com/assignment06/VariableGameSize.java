package com.assignment06;

import java.util.Scanner;

public class VariableGameSize extends Game {
    //store size of the board
    private final int boardSize;

    //store length of the winning condition
    private final int winLength;

    //constructor to initialize the game with player types, symbols, board size, and win condition
    public VariableGameSize(boolean isHuman1, char symbol1, boolean isHuman2, char symbol2, int size, int winCondition) {
        super(isHuman1, symbol1, isHuman2, symbol2);
        this.boardSize = size;
        this.winLength = winCondition;
        theBoard = new VariableBoardSize(boardSize, winLength); 
    }

    // method to prompt the user to restart the game
    public void restartGame(Scanner scanner) {
        System.out.println("Do you want to restart? (y/n): ");
        String response = scanner.next().trim().toLowerCase(); 
        if (response.equals("y")) {
            theBoard = new VariableBoardSize(boardSize, winLength);
            playGame(scanner);  // start a new game
        }
    }
}
