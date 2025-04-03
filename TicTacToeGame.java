import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    public char currentPlayerMark;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayerMark = 'x';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayerMark;
                switchPlayer();  // Switch player after placing mark
                return true;
            }
        }
        return false;
    }

    public char getPlayer() {
        return currentPlayerMark;
    }

    private void switchPlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        } else {
            currentPlayerMark = 'x';
        }
    }

    public boolean checkInput(Scanner scanner) {
        System.out.print("Enter a position (1-9): ");
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            int row = (input - 1) / 3;
            int col = (input - 1) % 3;

            if (input >= 1 && input <= 9) {
                if (placeMark(row, col)) {
                    return true;
                } else {
                    System.out.println("Position already taken, try again.");
                    return false;
                }
            } else {
                System.out.println("Please only use numbers between 1-9.");
                scanner.nextLine(); // Clear the invalid input
                return false;
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
            return false;
        }
    }

    // New getBoard method to retrieve the current board state
    public char[][] getBoard() {
        return board;
    }

	public boolean checkForWin() {
        return (checkRowsForWin() || checkColsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            // Bug: Incorrect comparison of elements in the row
            if (board[i][0] != '-' && board[i][0] == board[i][1]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColsForWin() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeBoard();

        Scanner scanner = new Scanner(System.in);  // Create scanner once
        while (!game.isBoardFull()) {
            game.printBoard();
            char player = game.getPlayer();
            System.out.println(game.getPlayer() + " has to make a move");
            while (!game.checkInput(scanner)) {
                // Keep asking until valid input is received
            }
			if (game.checkForWin()) {
				game.printBoard();  // Print final board
				System.out.println(player + " wins!");
				break;  // Exit the loop if there's a winner
			}
        }
		// If the board is full but no winner
		if (!game.checkForWin() && game.isBoardFull()) {
			game.printBoard();
			System.out.println("It's a tie!");
		}
        
        System.out.println("Game over!");
        scanner.close(); 
    }
}