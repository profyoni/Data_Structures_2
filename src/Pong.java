import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Pong extends JFrame {
    private JLabel statusBar = new JLabel();
    public Pong() {
        super("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);


        JButton button = new JButton("Pong");
        button.addActionListener( e -> handler());
        add(button, BorderLayout.NORTH);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    void slowOp(){

        double d = 2.3;
        for (long i = 0;i<1_000_000_000l;i++) {
            d += i;
        }
        System.out.println("COMPLETE\t" + d);
    }
    private void handler() {

        Thread thread = new Thread(){
            public void run(){
                SwingUtilities.invokeLater( () -> { statusBar.setText("Starting...");});
                slowOp();
                SwingUtilities.invokeLater( () -> { statusBar.setText("Finished");});
            }
        };
        thread.start();





        //System.out.println(d);

    }

    public static void main(String[] args) {
        new Pong();
    }
}
