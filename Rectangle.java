package superdraw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Rectangle extends BoundedShape {
    JLabel rectLabel = new JLabel();
    
    Rectangle() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        filledShape=false;
        rectLabel.setText("Empty Rectangle");
        this.add(rectLabel);
    }
    
    Rectangle(Color colour) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.colour = colour;  
        filledShape=true;
        rectLabel.setText("Filled Rectangle");
        this.add(rectLabel);
    }  

    @Override
    public void mousePressed(MouseEvent evt) {
        Point pos = evt.getPoint();
        x1 = pos.x;
        y1 = pos.y;
        // no repaint here because otherwise it will draw a shadow box in the wrong location
        // using the previous coordinates
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
         // filledShape determines whether it is an empty or a filled shape
        if(filledShape){
            g.setColor(colour);
            //logic to allow dragging/drawing in all directions
            if((x2<x1)&&(y2<y1)) {
                g.fillRect(x2, y2, Math.abs((x1-x2)), Math.abs((y1-y2)));
            }
            if((x2<x1)&&(y2>y1)){               
                g.fillRect(x2, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2<y1)){
                g.fillRect(x1, y2, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2>y1)){
                g.fillRect(x1, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
        }
        else {
            g.setColor(colour);
            if((x2<x1)&&(y2<y1)) {
                g.drawRect(x2, y2, Math.abs((x1-x2)), Math.abs((y1-y2)));
            }
            if((x2<x1)&&(y2>y1)){               
                g.drawRect(x2, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2<y1)){
                g.drawRect(x1, y2, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2>y1)){
                g.drawRect(x1, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
        }
    }
    
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}