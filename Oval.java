package superdraw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Oval extends BoundedShape {
    JLabel ovalLabel = new JLabel();
    
    Oval() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        filledShape=false;
        ovalLabel.setText("Empty Oval");
        this.add(ovalLabel);
    }  
    Oval(Color colour) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.colour = colour;  
        filledShape=true;
        ovalLabel.setText("Filled Oval");
        this.add(ovalLabel);
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
        if(filledShape){
            g.setColor(colour);
            g.fillOval(x1, y1, (x2-x1), (y2-y1));
        }
        else {
           g.drawOval(x1, y1, (x2-x1), (y2-y1));
        }
    }
    
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}