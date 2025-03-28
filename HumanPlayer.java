import java.util.Scanner;

public class HumanPlayer implements Player {
    private char symbol;
    private Scanner scanner;

    public HumanPlayer(char symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public char getSymbol() {//get symbol
        return symbol;
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Enter row and column (0-2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        board.makeMove(row, col, symbol);
    }
}
