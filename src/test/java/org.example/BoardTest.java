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

    // --- isCellEmpty ---

    @Test
    public void testIsCellEmpty_Positive() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmpty_Negative() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    // --- place ---

    @Test
    public void testPlace_Positive() {
        board.place(1, 1, 'X');
        assertEquals('X', board.getCells()[1][1]);
    }

    @Test
    public void testPlace_Negative_DoesNotOverwrite() {
        board.place(0, 0, 'X');
        board.place(0, 0, 'O'); // should be ignored
        assertEquals('X', board.getCells()[0][0]);
    }

    // --- isFull ---

    @Test
    public void testIsFull_Positive() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board.place(x, y, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFull_Negative() {
        board.place(0, 0, 'X');
        assertFalse(board.isFull());
    }

    // --- clear ---

    @Test
    public void testClear_Positive() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClear_Negative() {
        board.place(1, 1, 'O');
        assertFalse(board.isCellEmpty(1, 1)); // before clear
    }
}
