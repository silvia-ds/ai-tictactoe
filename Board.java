public class Board {

    private char[][] grid;  //3x3 board

    public Board(){
        grid = new char[3][3];
        for (int i = 0; i < 3; i ++) {
            for ( int j = 0;j < 3; j ++) {
                grid[i][j] = ' ';
            }
        }
    }
    // Prints 3x3 grid
    public void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]); // Print X, O, 
                if (j < 2) System.out.print("  |   "); // Column separator
            }
            System.out.println();
            if (i < 2) System.out.println("--------------"); // Row separator
        }
        System.out.println();
    }

    public boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' '){ //Assures that the placement is in bound of the board
            grid[row][col] = player; // Place X or O
            return true;
        }
        return false; // Square is filled
    }
    // Check if board is full
    public boolean checkFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') { // Checks for empty spot
                    return false;
                }
            }
        }
        return true; // Full if no empty spots
    }
    
    //Checks if any 3 possible spots in a row are the same char (not blank)
    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) return grid[i][0]; // Row
            if (grid[0][i] != ' ' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) return grid[0][i]; // Column
        }
        if (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) return grid[0][0]; // Diagonal
        if (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) return grid[0][2]; // Anti-diagonal
        return ' ';
    }

    public char[][] getGrid(){
        return grid;
    }

} 
