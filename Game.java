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

    //Main game loop, in a while loop incase user wans to play again
    //calls the make move methods from either human or AI class to make move
    public void start() {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // Reset the board at the beginning of each game
            board = new Board();
            int currentPlayerIndex = 0; // Use index to switch players
            
            // Game loop for a single game
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

                // Switch players using index
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }

            // Display the result of the game
            char winner = board.checkWinner();
            if (winner != ' ') {
                System.out.println("Winner: " + winner);
            } else {
                System.out.println("It's a tie!");
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