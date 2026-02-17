import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GraphicsProgramming {
    public static void main(String[] args) {
        new WindowGraphicsApp();
    }
}

class WindowGraphicsApp extends JFrame {
    public WindowGraphicsApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        MyCanvas canvas = new MyCanvas();
        add(canvas);
        setVisible(true);
    }
}


class MyCanvas extends JPanel{
    private ArrayList<Point> pointList = new ArrayList<>();
    public MyCanvas() {
        this.setBackground(Color.WHITE);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
              //  System.out.println(e.getX() + "," + e.getY());
                pointList.add(new Point(e.getX(),e.getY()));
                repaint();
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked" + e.getX() + "," + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed" + e.getX() + "," + e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased" + e.getX() + "," + e.getY());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered" + e.getX() + "," + e.getY());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited" + e.getX() + "," + e.getY());
            }
        });

        addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getWheelRotation());
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        Random r = new Random();
//        Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
//        g.setColor(c);
//        g.fillOval(0, 0, 100, 100);

        boolean first = true;
        Point lastPoint = null;
        for (Point p : pointList) {
            if (first) {
                first = false;
                lastPoint = p;
            }
            else {
                g.drawLine(lastPoint.x, lastPoint.y, p.x, p.y);
                lastPoint = p;
            }
        }
    }
}