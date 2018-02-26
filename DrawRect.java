import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class DrawRect extends JPanel {

    int x, y, w, h;
    public static void main(String [] args) {
        JFrame f = new JFrame("Draw Box Mouse 2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new DrawRect());
        f.setSize(300, 300); f.setVisible(true);
    }



    DrawRect() {
        x = y = w = h = 0; //
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void setStartPoint(int x, int y) {
        this.x = x; this.y = y;
    }

    public void setEndPoint(int x, int y) {
        w = Math.abs(this.x - x);
        h = Math.abs(this.y - y);
    }

    class MyMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            setStartPoint(e.getX(), e.getY());
        }
        public void mouseDragged(MouseEvent e) {
            setEndPoint(e.getX(), e.getY()); repaint();
        }
        public void mouseReleased(MouseEvent e) {
            setEndPoint(e.getX(), e.getY()); repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);

        //Please help me.
        g.drawRect(x, y, w, h);

    }



}