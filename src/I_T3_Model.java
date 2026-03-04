public interface I_T3_Model {
    Player getCurrentPlayer();

    void makeMove(int row, int col);

    boolean legalMove(int row, int col);
}
