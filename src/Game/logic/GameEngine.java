package Game.logic;

import java.util.Random;

public class GameEngine {

    private char[][] board;

    private char currentPlayer;

    private char winner;

    private GameMode gameMode;

    private Difficulty difficulty;

    private Random random;

    public GameEngine(GameMode gameMode, Difficulty difficulty) {

        this.gameMode = gameMode;
        this.difficulty = difficulty;

        board = new char[3][3];

        random = new Random();

        resetGame();

    }

    public void resetGame() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                board[row][col] = ' ';

            }

        }

        currentPlayer = 'X';

        winner = ' ';

    }

    public boolean makeMove(int row, int col) {

        if (board[row][col] != ' ') {

            return false;

        }

        board[row][col] = currentPlayer;

        winner = checkWinner();

        if (winner == ' ') {

            switchPlayer();

        }

        return true;

    }

    private void switchPlayer() {

        if (currentPlayer == 'X') {

            currentPlayer = 'O';

        }

        else {

            currentPlayer = 'X';

        }

    }

    public int[] computerMove() {

        switch (difficulty) {

            case EASY:
                return randomMove();

            case MEDIUM:
                return mediumMove();

            case HARD:
                return minimaxMove();

            default:
                return randomMove();

        }

    }

    private int[] randomMove() {

        while (true) {

            int row = random.nextInt(3);

            int col = random.nextInt(3);

            if (board[row][col] == ' ') {

                board[row][col] = 'O';

                winner = checkWinner();

                currentPlayer = 'X';

                return new int[]{row, col};

            }

        }

    }
    private int[] mediumMove() {

        // Try to win
        int[] move = findWinningMove('O');

        if (move != null) {

            board[move[0]][move[1]] = 'O';
            winner = checkWinner();
            currentPlayer = 'X';

            return move;

        }

        // Try to block player
        move = findWinningMove('X');

        if (move != null) {

            board[move[0]][move[1]] = 'O';
            winner = checkWinner();
            currentPlayer = 'X';

            return move;

        }

        // Otherwise play randomly
        return randomMove();

    }
    private int[] findWinningMove(char player) {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == ' ') {

                    board[row][col] = player;

                    char result = checkWinner();

                    board[row][col] = ' ';

                    if (result == player) {

                        return new int[]{row, col};

                    }

                }

            }

        }

        return null;

    }
    private int[] minimaxMove() {

        int bestScore = Integer.MIN_VALUE;

        int bestRow = -1;
        int bestCol = -1;

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == ' ') {

                    board[row][col] = 'O';

                    int score = minimax(0, false);

                    board[row][col] = ' ';

                    if (score > bestScore) {

                        bestScore = score;
                        bestRow = row;
                        bestCol = col;

                    }

                }

            }

        }

        board[bestRow][bestCol] = 'O';

        winner = checkWinner();

        currentPlayer = 'X';

        return new int[]{bestRow, bestCol};

    }
    private int minimax(int depth, boolean isMaximizing) {

        char result = checkWinner();

        if (result == 'O')
            return 10 - depth;

        if (result == 'X')
            return depth - 10;

        if (isBoardFull())
            return 0;

        if (isMaximizing) {

            int bestScore = Integer.MIN_VALUE;

            for (int row = 0; row < 3; row++) {

                for (int col = 0; col < 3; col++) {

                    if (board[row][col] == ' ') {

                        board[row][col] = 'O';

                        int score = minimax(depth + 1, false);

                        board[row][col] = ' ';

                        bestScore = Math.max(bestScore, score);

                    }

                }

            }

            return bestScore;

        } else {

            int bestScore = Integer.MAX_VALUE;

            for (int row = 0; row < 3; row++) {

                for (int col = 0; col < 3; col++) {

                    if (board[row][col] == ' ') {

                        board[row][col] = 'X';

                        int score = minimax(depth + 1, true);

                        board[row][col] = ' ';

                        bestScore = Math.min(bestScore, score);

                    }

                }

            }

            return bestScore;

        }

    }

    public char checkWinner() {

        // Rows

        for (int i = 0; i < 3; i++) {

            if (board[i][0] != ' ' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {

                return board[i][0];

            }

        }

        // Columns

        for (int i = 0; i < 3; i++) {

            if (board[0][i] != ' ' &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {

                return board[0][i];

            }

        }

        // Main Diagonal

        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {

            return board[0][0];

        }

        // Other Diagonal

        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {

            return board[0][2];

        }

        return ' ';

    }

    public boolean isBoardFull() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == ' ') {

                    return false;

                }

            }

        }

        return true;

    }

    public char getCurrentPlayer() {

        return currentPlayer;

    }

    public char getWinner() {

        return winner;

    }

    public char getCell(int row, int col) {

        return board[row][col];

    }

    public GameMode getGameMode() {

        return gameMode;

    }

    public Difficulty getDifficulty() {

        return difficulty;

    }

}