/** Model the game board of 3x3 cells.*/
public class Board {

    /** Constants for the board*/
    public static final int numOfROWS = 3;
    public static final int numOfCOLUMNS = 3;

    /** Create 2-dimensional char array for the board */
    Cell[][] board;

    /** Define the constructor to initialize the game board */
    public Board() {
        initializeBoard();
    }

    /** Initialize the board */
    public void initializeBoard() {
        board = new Cell[numOfROWS][numOfCOLUMNS];
        for (int row = 0; row < numOfROWS; ++row) {
            for (int col = 0; col < numOfCOLUMNS; ++col) {
                board[row][col] = new Cell(row, col);
            }
        }
    }

    /** Reset game board */
    public void newGame() {
        for (int row = 0; row < numOfROWS; ++row) {
            for (int col = 0; col < numOfCOLUMNS; ++col) {
                board[row][col].newGame();
            }
        }
    }

    public GameState NextPlayer(Place player, int movePosition) {

        switch (movePosition) {
            case 1:
                board[0][0].cell = player;
                break;
            case 2:
                board[0][1].cell  = player;
                break;
            case 3:
                board[0][2].cell  = player;
                break;
            case 4:
                board[1][0].cell  = player;
                break;
            case 5:
                board[1][1].cell = player;
                break;
            case 6:
                board[1][2].cell  = player;
                break;
            case 7:
                board[2][0].cell  = player;
                break;
            case 8:
                board[2][1].cell  = player;
                break;
            case 9:
                board[2][2].cell  = player;
                break;
            default:
                break;
        }

        /** Compute and return the new game state*/
        if ((board[0][0].cell == player && board[0][1].cell == player && board[0][2].cell == player)
                || (board[1][0].cell == player && board[1][1].cell == player && board[1][2].cell == player)
                || (board[2][0].cell == player && board[2][1].cell == player && board[2][2].cell == player)
                || (board[0][0].cell == player && board[1][0].cell == player && board[2][0].cell == player)
                || (board[0][1].cell == player && board[1][1].cell == player && board[2][1].cell == player)
                || (board[0][2].cell == player && board[1][2].cell == player && board[2][2].cell == player)
                || (board[0][0].cell == player && board[1][1].cell == player && board[2][2].cell == player)
                || (board[2][0].cell == player && board[1][1].cell == player && board[0][2].cell == player)) {
            return (player == Place.CROSS) ? GameState.FIRSTPLAYER_WON : GameState.SECONDPLAYER_WON;
        } else {
            for (int row = 0; row < numOfROWS; ++row) {
                for (int col = 0; col < numOfCOLUMNS; ++col) {
                    if (board[row][col].cell == Place.EMPTY) {
                        return GameState.ISPLAYING;
                    }
                }
            }
            return GameState.DRAW;
        }
    }

    /** Fills the board */
    public void fillBoard() {
        for (int row = 0; row < numOfROWS; ++row) {
            for (int col = 0; col < numOfCOLUMNS; ++col) {
                System.out.print(" ");
                board[row][col].fillCell();
                System.out.print(" ");
                if (col < numOfCOLUMNS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < numOfROWS - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }
}
