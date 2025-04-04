// src/test/java/GameTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testRowWinCondition() {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeBoard();

        // Simulate a winning scenario for Player X in the top row
        game.placeMark(0, 0);  // X
        game.placeMark(3, 3);  // O
        game.placeMark(0, 1);  // X
        game.placeMark(1, 1);  // O

        // Assert that the game detects a win
        assertTrue(game.checkForWin(), "Player X should have won with the top row.");
    }
}
