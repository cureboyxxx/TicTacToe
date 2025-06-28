package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoardStartsEmpty() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                assertTrue(board.isCellEmpty(x, y), "Cell (" + x + "," + y + ") should be empty");
            }
        }
    }

    @Test
    public void testPlaceMarker() {
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
        assertEquals('X', board.getCells()[1][1]);
    }

    @Test
    public void testPlaceOnOccupiedCellDoesNotChangeMarker() {
        board.place(0, 0, 'X');
        board.place(0, 0, 'O'); // should have no effect
        assertEquals('X', board.getCells()[0][0]);
    }

    @Test
    public void testClearBoard() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.clear();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                assertTrue(board.isCellEmpty(x, y));
            }
        }
    }

    @Test
    public void testIsFullFalseOnEmptyBoard() {
        assertFalse(board.isFull());
    }

    @Test
    public void testIsFullTrueWhenAllCellsFilled() {
        char marker = 'X';
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board.place(x, y, marker);
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testGetCellsReturnsCorrectGrid() {
        board.place(2, 2, 'O');
        char[][] cells = board.getCells();
        assertEquals('O', cells[2][2]);
    }
}

