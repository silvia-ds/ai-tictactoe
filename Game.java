import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Board board;
    private ArrayList<Player> players; // Store players in an ArrayList

    public Game(Player p1, Player p2) { // Accept any subclasses of Player
        this.players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
    }

    // Main game
    public void start() {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // Reset the board at the beginning of each game
            board = new Board();
            int currentPlayerIndex = 0; // Use index to switch players
            
            // Single game
            while (board.checkWinner() == ' ' && !board.checkFull()) {
                board.printBoard();
                Player currentPlayer = players.get(currentPlayerIndex);
                System.out.println(currentPlayer.getSymbol() + "'s turn:");
                currentPlayer.makeMove(board);

                // Check for a win or tie immediately after the move
                if (board.checkWinner() != ' ' || board.checkFull()) {
                    board.printBoard();
                    break;
                }

                // Switch players
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }

            // Display result
            char winner = board.checkWinner();
            if (winner != ' ') {
                System.out.println("Winner: " + winner);
            } else {
                System.out.println("Tie.");
            }

            // Prompt the user to play again
            System.out.print("Play again? (Y/N): ");
            String response = input.nextLine();
            if (!response.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }

        input.close();
    }
}
