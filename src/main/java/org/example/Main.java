package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            TicTacToe game = new TicTacToe();
            game.start();

            System.out.print("Play again? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            playAgain = input.equals("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
