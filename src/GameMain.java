import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class GameMain {
    // Define properties
    /** The game board */
    private Board board;
    /** The current state of the game */
    private GameState currentState;
    /** The current player */
    private Place currentPlayer;

    private static Scanner in = new Scanner(System.in);

    /** Constructor to the game */
    public GameMain() {
        boolean playNewGame = true;
        do {
            initializeGame();

            newGame();

            do {
                // The current player makes a move.

                nextMove();
                board.fillBoard();
                // Print the result according to the game state.
                if (currentState == GameState.FIRSTPLAYER_WON) {
                    System.out.println("'X' won!\nBye!");
                } else if (currentState == GameState.SECONDPLAYER_WON) {
                    System.out.println("'Y' won!\nBye!");
                } else if (currentState == GameState.DRAW) {
                    System.out.println("It's Draw!\nBye!");
                }
                // Switch to next player
                currentPlayer = (currentPlayer == Place.CROSS) ? Place.ZERO : Place.CROSS;
            } while (currentState == GameState.ISPLAYING);  // repeat the process until game is over.
            System.out.println("Do you want to play again? Enter 'Y' for yes or 'N' for no!");
            String answer = in.next().toUpperCase();
            while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")){
                System.out.println("Please enter 'Y' or 'N'");
                answer = in.next().toUpperCase();
            }
            if (answer.equals("N")) playNewGame = false;
        }while(playNewGame);

    }

    /** Initialize the game board */
    public void initializeGame() {
        board = new Board();
    }

    /** Reset game-board and current states */
    public void newGame() {
        board.newGame();
        currentPlayer = Place.CROSS;
        currentState = GameState.ISPLAYING;
    }

    /** The current player makes a move.*/
    public void nextMove() {
        boolean isValidInput = false;  // for validating input
        do {
            String icon = currentPlayer.getSymbol();
            System.out.print("Player '" + icon + "', enter your move 1 - 9): ");
            int movePosition = in.nextInt();
            if (movePosition >= 0 && movePosition < Board.numOfROWS*Board.numOfCOLUMNS+1
                    ) {
                // Update board and return the new game state
                currentState = board.NextPlayer(currentPlayer, movePosition);
                isValidInput = true;
            } else {
                System.out.println("This move at (" + (movePosition)
                        + ") is not valid. Try again...");
            }
        } while (!isValidInput);
    }

    /** Main method */
    public static void main(String[] args) {
        new GameMain();
    }
}