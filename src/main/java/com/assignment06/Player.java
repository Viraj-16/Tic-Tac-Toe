package com.assignment06;

import java.util.Scanner;

public abstract class Player {
    //store the marker (symbol) of the player (X or Y)
    protected char marker;
    
    protected String name;

    //constructor to initialize the player with a marker and name
    public Player(char marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    //method to retrieve the player's marker
    public char getMarker() {
        return marker;
    }

    public String getName() {
        return name;
    }

    //abstract method to be implemented by subclasses for making a move
    public abstract void makeMove(Board board, Scanner scanner);
}
