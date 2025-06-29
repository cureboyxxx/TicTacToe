package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameResultTest {


    //hasWinner Methode

    @Test
    public void testPlayerWinsWithHorizontalLine() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');

        // aktueller Spieler: X
        org.example.TicTacToe game = new org.example.TicTacToe();
        setPrivateBoard(game, board);
        setPrivateCurrentPlayer(game, new Player('X'));

        assertTrue(game.hasWinner());
    }

    @Test
    public void testNoWinnerOnEmptyBoard() {
        org.example.TicTacToe game = new org.example.TicTacToe();
        assertFalse(game.hasWinner());
    }


    //isFull Methode

    @Test
    public void testBoardIsFullMeansDraw() {
        Board board = new Board();
        char[][] draw = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.place(i, j, draw[i][j]);

        assertTrue(board.isFull());
    }

    @Test
    public void testBoardNotFull() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isFull());
    }


    private void setPrivateBoard(org.example.TicTacToe game, Board board) {
        try {
            java.lang.reflect.Field field = org.example.TicTacToe.class.getDeclaredField("board");
            field.setAccessible(true);
            field.set(game, board);
        } catch (Exception e) {
            fail("Failed to set board via reflection: " + e.getMessage());
        }
    }

    private void setPrivateCurrentPlayer(org.example.TicTacToe game, Player player) {
        try {
            java.lang.reflect.Field field = org.example.TicTacToe.class.getDeclaredField("currentPlayer");
            field.setAccessible(true);
            field.set(game, player);
        } catch (Exception e) {
            fail("Failed to set currentPlayer via reflection: " + e.getMessage());
        }
    }
}