package superdraw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Rectangle extends BoundedShape {
    Rectangle() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        filledShape=false;
    }
    
    Rectangle(Color colour) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.colour = colour;  
        filledShape=true;
    }  

    @Override
    public void mousePressed(MouseEvent evt) {
        Point pos = evt.getPoint();
        x1 = pos.x;
        y1 = pos.y;
        repaint();
    }
    
    @Override
    public void mouseDragged(MouseEvent evt) {
        x2 = evt.getX();
        y2 = evt.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        Point pos2 = evt.getPoint();
        x2 = pos2.x;
        y2 = pos2.y;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(filledShape){
            g.setColor(colour);
            g.fillRect(x1, y1, (x2-x1), (y2-y1));
        }
        else {
           g.drawRect(x1, y1, (x2-x1), (y2-y1));
        }
    }
    
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}