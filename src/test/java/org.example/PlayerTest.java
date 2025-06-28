package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testGetMarkerReturnsCorrectValue() {
        Player playerX = new Player('X');
        assertEquals('X', playerX.getMarker());

        Player playerO = new Player('O');
        assertEquals('O', playerO.getMarker());
    }

    @Test
    public void testDifferentMarkerCharacters() {
        Player player = new Player('#');
        assertEquals('#', player.getMarker());
    }
}
