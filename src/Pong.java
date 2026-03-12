import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class Pong extends JFrame {
    private JLabel statusBar = new JLabel();
    private JPanel gamePanel = new JPanel();
    Point ball = new Point(300, 100);
    Point rect = new Point(20, 200);
    Point delta = new Point(7, 11);

    public Pong() {
        super("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);


        gamePanel.setBackground(Color.BLACK);
        add(gamePanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ball.translate(delta.x, delta.y);
                if (ball.y >= 500)
                    delta.y = -delta.y;
                if (ball.x >= 500)
                    delta.x = -delta.x;
                repaint();
            }
        });
        timer.start();

        addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                rect.translate(0, 10 * e.getWheelRotation());            }
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillOval(ball.x, ball.y, 20, 20);
        // paddle
        g.fillRect(rect.x, rect.y, 20, 80);
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
