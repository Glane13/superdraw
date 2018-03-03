package superdraw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
public class Line extends Shape {
     
    Line (Color colour) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.colour = colour;  
    }
    
    @Override
    public void mousePressed(MouseEvent evt) {
        x1 = evt.getXOnScreen();
        y1 = evt.getYOnScreen();
    }
    
    public void mouseDragged(MouseEvent evt) {
        x2 = evt.getX();
        y2 = evt.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        x2 = evt.getX();
        y2 = evt.getY();
        repaint();
    }
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);      
        g.setColor(colour);
        g.drawLine(x1, y1, x2, y2);
    }
    
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }  
}