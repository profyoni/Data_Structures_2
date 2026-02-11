import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new MyWindowApp();
    }
}

enum Player {None, X, O}


class T3_Model
{
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
    Player getCurrentPlayer(){
        return player;
    }
    /**
     *
     * @param row
     * @param col
     * @return the current player
     * @throws InvalidArgumentException
     */
    void makeMove(int row, int col)
    {
        if (! legalMove(row, col))
            throw new IllegalArgumentException(String.format("Illegal move [%d, %d]", row, col)); // TODO indicate if occupied or out of bounds
        board[row][col] = player;
        player = player == Player.X ? Player.O : Player.X;
    }
    boolean legalMove(int row, int col){
        if (row<0 || row>=3 || col<0 || col>=3)
            return false;
        return board[row][col] == Player.None;
    }
}



class MyWindowApp extends JFrame {
    class ButtonPanel extends JPanel {
        public ButtonPanel() {
            setLayout(new FlowLayout());
            this.add(new JCheckBox("computer opponent"));
            this.add(new JButton("Save"));
        }
    }
    class GamePanel extends JPanel {
        public GamePanel() {
            this.setLayout(new GridLayout(3,3, 5,5));

            for (int row=0;row<3;row++)
                for (int col=0;col<3;col++){
                    JButton button = new JButton();
                    button.setFont(new Font("Arial", Font.BOLD, 200));
                    this.add(button);
                    int finalRow = row;
                    int finalCol = col;
                    button.addActionListener(e->{
                        Player p = model.getCurrentPlayer();
                        model.makeMove(finalRow, finalCol);
                        button.setText( p.toString() );
                        statusBar.setText( String.format("Turn for : %s", model.getCurrentPlayer()) );
                    });
                }
        }
    }
    private int x;
    private T3_Model model = T3_Model.getInstance();
    private JLabel statusBar = new JLabel("Status:");
    public MyWindowApp() {

        // GUI - Graphical User Interface
        // Java Swing

        // windowed application

        //JFrame app = new JFrame();
        this.setTitle("Tick Tack Tow");

        this.setSize(660, 690);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add( new ButtonPanel(), BorderLayout.NORTH);
        this.add( new GamePanel(), BorderLayout.CENTER);
        this.add( statusBar, BorderLayout.SOUTH);

        this.setVisible(true);
        }

        private static class ChangeColorActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                Random r = new Random();
                Color c = new Color( r.nextInt(255),r.nextInt(255),r.nextInt(255));
                b.setBackground(c);
            }
        }


    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            x++;
            JButton b = (JButton) e.getSource();
            b.setText("X=" + x);
        }
    }


}
