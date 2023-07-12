import java.util.Scanner;

public class tic {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        boolean gameOver = false;
        int totalMoves = 0;

        while (!gameOver) {
            displayBoard();
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                totalMoves++;

                if (checkWin(row, col)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (totalMoves == 9) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void displayBoard() {
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

    private static int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
        move[0] = scanner.nextInt();
        System.out.print("Player " + currentPlayer + ", enter column (0-2): ");
        move[1] = scanner.nextInt();

        return move;
    }

    private static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    private static boolean checkWin(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
                || (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
                || (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer
                        && board[2][2] == currentPlayer)
                || (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer
                        && board[2][0] == currentPlayer);
    }
}
