import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new MyWindowApp();
    }
}

class MyWindowApp extends JFrame {
    private int x;


    public MyWindowApp() {

        // GUI - Graphical User Interface
        // Java Swing

        // windowed application

        //JFrame app = new JFrame();
        this.setTitle("Cool App");

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me and I will change the color");
        this.getContentPane().add(button, BorderLayout.SOUTH);
        JTextField textfield = new JTextField(10);
        this.getContentPane().add(textfield, BorderLayout.CENTER);

        button.addActionListener(new MyActionListener());
        button.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                x++;
                JButton b = (JButton) e.getSource();
                b.setText("X=" + x);
            }
        }
        );
        button.addActionListener(new ChangeColorActionListener());

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
