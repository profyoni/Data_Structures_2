import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        T3_Model model = T3_Model.getInstance();
        new MyWindowApp(model); // c-tor dependency injection
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
    private I_T3_Model model;
    private JLabel statusBar = new JLabel("Status:");
    public MyWindowApp(I_T3_Model model) {
        this.model = model;
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
