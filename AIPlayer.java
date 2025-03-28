public class AIPlayer implements Player {
    private char symbol;

    public AIPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
    @Override
    public void makeMove(Board board) {
        if (board.checkWinner() != ' ' || board.checkFull()) {
            return; // Stop AI from playing if game is over (Dont over work...)
        }

        int[] bestMove = findBestMove(board);  //Check the best move
        board.makeMove(bestMove[0], bestMove[1], symbol); //Make the best move found (Place the 'o' on the board)
    }

    private int[] findBestMove(Board board) {
        // Check if AI can win
        int[] move = checkWinningMove(board, symbol);
        if (move[0] != -1) { //If move is not a winning move, return it...
            return move;
        }

        // Check if AI needs to block the opponent
        char opponent;
        if (symbol == 'X') { //Checks to see what symbol the player and AI are,n so it can clearly check the best move for player and AI...
            opponent = 'O';
        } else {
            opponent = 'X';
        }

        move = checkWinningMove(board, opponent); //this checks if the opponent has a winnign move availabvle, and if it does it will return and block that move.
        if (move[0] != -1) {// This is used to check what the best move for the opponent is, so the AI can block it
            return move;
        }

        // Play center if available
        if (board.getGrid()[1][1] == ' ') {
            return new int[]{1, 1};
        }

        // Play a corner if available
        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        for (int i = 0; i < corners.length; i++) {
            int row = corners[i][0];
            int col = corners[i][1];
            if (board.getGrid()[row][col] == ' ') {
                return new int[]{row, col};
            }
        }

        // Play an edge if available
        int[][] edges = {{0, 1}, {1, 0}, {1, 2}, {2, 1}};
        for (int i = 0; i < edges.length; i++) {
            int row = edges[i][0];
            int col = edges[i][1];
            if (board.getGrid()[row][col] == ' ') {
                return new int[]{row, col};
            }
        }

        // If no other move is available, return a random move
        return getRandomMove(board);
    }
//Next method is pretty common sense, checks wif there is a winning move.
//Method is used to check best move for AI and also the player to the AI can block the player.
    private int[] checkWinningMove(Board board, char player) {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board.getGrid()[i][0] == player && board.getGrid()[i][1] == player && board.getGrid()[i][2] == ' ') {
                return new int[]{i, 2};
            }
            if (board.getGrid()[i][1] == player && board.getGrid()[i][2] == player && board.getGrid()[i][0] == ' ') {
                return new int[]{i, 0};
            }
            if (board.getGrid()[i][0] == player && board.getGrid()[i][2] == player && board.getGrid()[i][1] == ' ') {
                return new int[]{i, 1};
            }

            // Check columns
            if (board.getGrid()[0][i] == player && board.getGrid()[1][i] == player && board.getGrid()[2][i] == ' ') {
                return new int[]{2, i};
            }
            if (board.getGrid()[1][i] == player && board.getGrid()[2][i] == player && board.getGrid()[0][i] == ' ') {
                return new int[]{0, i};
            }
            if (board.getGrid()[0][i] == player && board.getGrid()[2][i] == player && board.getGrid()[1][i] == ' ') {
                return new int[]{1, i};
            }
        }

        // Check diagonals
        if (board.getGrid()[0][0] == player && board.getGrid()[1][1] == player && board.getGrid()[2][2] == ' ') {
            return new int[]{2, 2};
        }
        if (board.getGrid()[1][1] == player && board.getGrid()[2][2] == player && board.getGrid()[0][0] == ' ') {
            return new int[]{0, 0};
        }
        if (board.getGrid()[0][0] == player && board.getGrid()[2][2] == player && board.getGrid()[1][1] == ' ') {
            return new int[]{1, 1};
        }

        if (board.getGrid()[0][2] == player && board.getGrid()[1][1] == player && board.getGrid()[2][0] == ' ') {
            return new int[]{2, 0};
        }
        if (board.getGrid()[1][1] == player && board.getGrid()[2][0] == player && board.getGrid()[0][2] == ' ') {
            return new int[]{0, 2};
        }
        if (board.getGrid()[0][2] == player && board.getGrid()[2][0] == player && board.getGrid()[1][1] == ' ') {
            return new int[]{1, 1};
        }

        return new int[]{-1, -1}; // No winning move found
    }

    private int[] getRandomMove(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getGrid()[i][j] == ' ') {
                    return new int[]{i, j}; // Return first available space
                }
            }
        }
        return new int[]{-1, -1}; // No available move (shouldn't happen)
    }
}