package superdraw;
import java.awt.Color;
//import static java.awt.Color.white;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Line extends Shape {
    JLabel lineLabel = new JLabel("Line");
    
    Line () {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.add(lineLabel);
    }
    
    Line (Color colour) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.colour = colour;
        this.add(lineLabel);      
    }
    
    @Override
    public void mousePressed(MouseEvent evt) {       
        x1 = evt.getX();
        y1 = evt.getY();
    }
    
    @Override
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