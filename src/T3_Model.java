

public class T3_Model implements I_T3_Model {
    private static T3_Model the_Instance;
    public static T3_Model getInstance() {
        if (the_Instance == null) {
            the_Instance = new T3_Model();
        }
        return the_Instance;
    }

    private Player[][] board = new Player[3][3];
    private T3_Model(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Player.None;
            }
        }
    }

    private Player player = Player.X;
    @Override
    public Player getCurrentPlayer(){
        return player;
    }
    /**
     *
     * @param row
     * @param col
     * @return the current player
     * @throws IllegalArgumentException
     */
    @Override
    public void makeMove(int row, int col)
    {
        if (! legalMove(row, col))
            throw new IllegalArgumentException(String.format("Illegal move [%d, %d]", row, col)); // TODO indicate if occupied or out of bounds
        board[row][col] = player;
        player = player == Player.X ? Player.O : Player.X;
    }
    @Override
    public boolean legalMove(int row, int col){
        if (row<0 || row>=3 || col<0 || col>=3)
            return false;
        return board[row][col] == Player.None;
    }
}