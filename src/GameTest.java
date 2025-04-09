// src/test/java/GameTest.java

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testRowWinCondition() {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeBoard();

        // Simulate a winning scenario for Player X in the top row
        game.placeMark(0, 0);  // X
        game.placeMark(1, 0);  // O
        game.placeMark(0, 1);  // X
        game.placeMark(2, 2);  // O

        // Assert: The game should not detect a win yet (not all marks placed)
        assertTrue(!game.checkForWin(), "The game should not detect a win yet (not all marks placed).");

        // Place the final mark to complete the row

        // Assert: The game should now detect a win.
        assertTrue(game.checkForWin(), "Player X should win with the top row.");
    }
}
