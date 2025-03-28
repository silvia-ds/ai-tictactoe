public class GameTester {
    public static void main(String[] args) {
        Player human = new HumanPlayer('X'); // Initilizes player human object
        Player ai = new AIPlayer('O');  // Initializes AI object
        Game game = new Game(human, ai); // Makes game w both players
        game.start();
    }
}
    

