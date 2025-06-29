package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();
        board.print();

        while (!board.isFull()) {
            System.out.println("Player " + currentPlayer.getMarker() + ", enter your move (row and column): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x < 0 || x > 2 || y < 0 || y > 2 || !board.isCellEmpty(x, y)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board.place(x, y, currentPlayer.getMarker());
            board.print();

            if (hasWinner()) {
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                return;
            }

            switchCurrentPlayer();
        }

        System.out.println("It's a draw!");
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    boolean hasWinner() {
        char[][] cells = board.getCells();
        char m = currentPlayer.getMarker();

        // Rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == m && cells[i][1] == m && cells[i][2] == m) || // Row
                    (cells[0][i] == m && cells[1][i] == m && cells[2][i] == m)) { // Column
                return true;
            }
        }
        return (cells[0][0] == m && cells[1][1] == m && cells[2][2] == m) ||
                (cells[0][2] == m && cells[1][1] == m && cells[2][0] == m);
    }
}
