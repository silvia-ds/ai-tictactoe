public interface Player {
    char getSymbol(); //Pretty straight forward but an interface for a player...Wether its human or AI
    void makeMove(Board board);  // used to make a move using AI logic or thr row and colum from player input
}