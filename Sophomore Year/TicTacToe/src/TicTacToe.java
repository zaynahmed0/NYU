import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    // Declare constants for player symbols and board size
    private static final char player1 = 'X';
    private static final char player2 = 'O';
    private static final char empty = ' ';
    private static final int size = 3;
    private int nonConsecutiveIncorrectEntries = 0; // Declare nonConsecutiveIncorrectEntries as a global variable


    // Declare instance variables
    private char[][] board;
    private int mode;
    private Scanner scanner;
    private Random random;

    public TicTacToe() {
        // Initialize instance variables
        board = new char[size][size];
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public static void main(String[] args) {
        // Create a new game instance and start the game
        TicTacToe game = new TicTacToe();
        game.start();
    }

    public void start() {
        // Request Game Mode and quit if 0 is entered
        System.out.println("Enter 1 for 2 players, 2 for playing against the CPU, or 0 to quit.");
        mode = scanner.nextInt();
        if (mode == 0) {
            System.out.println("Exiting...");
            return;
        }

        // Initialize the game board and print it
        initializeBoard();
        printBoard();

        // Start the main game loop
        play();
    }

    private void initializeBoard() {
        // Initialize the game board with empty spaces
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = empty;
            }
        }
    }

    private void printBoard() {
        // Print the game board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("  " + board[i][j]);
                if (j < size - 1) {
                    System.out.print("  |");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-----+-----+-----");
            }
        }
    }

    private void play() {
        // Main game loop which continually requests moves until the game is won, lost, forfeited, or tied
        int currentPlayer = 1;
        while (true) {
            if (currentPlayer == 1) {
                System.out.println("Player 1 turn: ");
                playerMove(player1);
            } else if (mode == 1) {
                System.out.println("Player 2 turn: ");
                playerMove(player2);
            } else {
                System.out.println("CPU turn: ");
                cpuMove();
            }

            printBoard();
            // Determines who/if there is a winner/tie, and displays relevant output
            if (checkWinner(currentPlayer == 1 ? player1 : player2)) {
                System.out.println("Game Over! Player " + (currentPlayer == 1 ? "1" : (mode == 1 ? "2" : "CPU")) + " Wins.");
                break;
            }

            if (isBoardFull()) {
                System.out.println("Game Over! It's a tie.");
                break;
            }
            //Switches currentPlayer to other.
            currentPlayer = 3 - currentPlayer;
        }
    }

    private boolean checkWinner(char player) {
        // Check for a winner vertically/horizontally
        for (int i = 0; i < size; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        //Checks diagonals for winner
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        // Check if the board is full
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == empty) {
                    return false;
                }
            }
        }
        return true;
    }

    private void playerMove(char playerSymbol) {
        int tile;
        int consecutiveIncorrectEntries = 0;
        while (true) {
            tile = scanner.nextInt();
            //Error Validation
            if (tile >= 1 && tile <= 9) {
                int row = (tile - 1) / size;
                int col = (tile - 1) % size;
                if (board[row][col] == empty) {
                    board[row][col] = playerSymbol;
                    consecutiveIncorrectEntries = 0; // Reset consecutive counter on correct input
                    break;
                } else {
                    //Monitoring incorrect entries
                    System.out.println("Incorrect entry, please try again");
                    consecutiveIncorrectEntries++;
                    nonConsecutiveIncorrectEntries++;
                }
            } else if (tile == 0) {
                //Forfeiting Method
                System.out.println("Player forfeits the game");
                System.exit(0);
            } else {
                System.out.println("Incorrect entry, please try again");
                consecutiveIncorrectEntries++;
                nonConsecutiveIncorrectEntries++;
            }

            if (consecutiveIncorrectEntries >= 3 || nonConsecutiveIncorrectEntries >= 5) {
                //Forfeiting for incorrectentries
                System.out.println("Player forfeits the game due to reaching maximum incorrect entries.");
                System.exit(0);
            }
        }
    }


    private void cpuMove() {
        int bestRow = -1;
        int bestCol = -1;

        // Check for a winning move
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == empty) {
                    board[row][col] = player2; // Temporarily place the CPU's symbol
                    if (checkWinner(player2)) { // Check if this move is a winning move
                        bestRow = row;
                        bestCol = col;
                    }
                    board[row][col] = empty; // Remove the temporary symbol
                }
            }
        }

        // If a winning move is found, make the move
        if (bestRow != -1 && bestCol != -1) {
            board[bestRow][bestCol] = player2;
            return;
        }

        // If no winning move is found, make a random move
        while (true) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (board[row][col] == empty) {
                board[row][col] = player2;
                break;
            }
        }
    }

}

