package com.assignment06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //scanner to read user input
        Scanner scanner = new Scanner(System.in);

        //ask if player 1 is human
        System.out.println("player 1: human? (y/n): ");
        boolean isHuman1 = scanner.next().equalsIgnoreCase("y");

        //ask if player 2 is human
        System.out.println("player 2: human? (y/n): ");
        boolean isHuman2 = scanner.next().equalsIgnoreCase("y");

        //ask for the board size, which should be between 3 and 20
        System.out.println("enter board size (3-20): ");
        int boardSize = scanner.nextInt();

        //ask for what the win condition length should be
        System.out.println("enter win condition length (3-" + boardSize + "): ");
        int winCondition = scanner.nextInt();

        //create a new game with variable board size and win condition
        Game game = new VariableGameSize(isHuman1, 'X', isHuman2, 'O', boardSize, winCondition);
        
        game.playGame(scanner);
        scanner.close();
    }
}