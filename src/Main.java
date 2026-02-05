import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new MyWindowApp();
    }
}

class T3_Model
{

}

class MyWindowApp extends JFrame {
    private int x;
    private String player = "X";

    public MyWindowApp() {

        // GUI - Graphical User Interface
        // Java Swing

        // windowed application

        //JFrame app = new JFrame();
        this.setTitle("Cool App");

        this.setSize(660, 690);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,3, 5,5));

        for (int i=0;i<9;i++) {
           JButton button = new JButton();
           button.setFont(new Font("Arial", Font.BOLD, 200));
           this.add(button);
           button.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   if (! button.getText().equals("")) {return;}
                   button.setText( player );

                   if (player.equals("X"))
                       player="O";
                   else
                       player="X";
               }
           });
        }


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
