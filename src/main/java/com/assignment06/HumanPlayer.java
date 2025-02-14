package com.assignment06;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char marker, String name) {
        //call the parent class constructor to initialize the marker and name
        super(marker, name);
    }

    public void makeMove(Board board, Scanner scanner) {
        while (true) {
            try {
                //prompt the player to enter a move in 'row,col' format
                System.out.printf("%s (%c), enter your move as 'row,col' (e.g., 1,2): ", name, marker);
                String input = scanner.next();

                //split the input string into row and column parts
                String[] parts = input.split(",");

                //check if the input is correctly formatted with two parts
                if (parts.length != 2) {
                    System.out.println("invalid input format. use 'row,col'.");
                    continue;
                }

                //parse the row and column values, trimming spaces
                int row = Integer.parseInt(parts[0].trim());
                int col = Integer.parseInt(parts[1].trim());

                //check if the move is valid, and place the marker if valid
                if (board.isValidMove(row, col)) {
                    board.setMove(row, col, marker);
                    break;
                } else {
                    System.out.println("invalid move. try again.");
                }
            } catch (NumberFormatException e) {
                //handle invalid number format and prompt for correct input
                System.out.println("invalid input. please enter integers separated by a comma.");
            }
        }
    }
}
