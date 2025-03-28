public class GameTester {
    //The goal of this Tic-Tac-Toe game is to create an AI-powered opponent
    // capable of playing against a human player with optimal move selection. 
    //The problem being addressed is the implementation of a fair and competitive 
    //Tic-Tac-Toe game where both human and AI players can take turns making moves on a 3x3 grid.
    // The AI should be able to analyze the board state and make intelligent moves, 
    //while the human player should be able to input their desired move coordinates. 
    //The game logic should enforce valid moves, check for win conditions, and ensure smooth turn-based gameplay. 
    //The primary challenge lies in designing an AI that can make effective decisions without relying on brute-force 
    //computations, ensuring efficient performance.
    //To implement the AI player, I used the minimax algortithm which I have found extremely fascinating.
    //This has made me extremely hungry to learn more about AI and machine learning0
    
    public static void main(String[] args) {
        Player human = new HumanPlayer('X'); // Initilizes player human object
        Player ai = new AIPlayer('O');  //makes ai object
        Game game = new Game(human, ai); // makes game object with ai and human oplayer
        game.start();
    }
}
    

