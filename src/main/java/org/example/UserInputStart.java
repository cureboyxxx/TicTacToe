package org.example;

import java.util.Scanner;

public class UserInputStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.print("Do you want to play as X or O? ");

        String playerSymbol = scanner.nextLine().trim().toUpperCase();

        while (!playerSymbol.equals("X") && !playerSymbol.equals("O")) {
            System.out.print("Invalid choice. Please enter X or O: ");
            playerSymbol = scanner.nextLine().trim().toUpperCase();
        }

        System.out.println("You chose to play as: " + playerSymbol);
        System.out.println("Game setup will follow in future versions...");

        scanner.close();
    }
}
