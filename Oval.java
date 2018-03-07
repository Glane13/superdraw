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
        this.setBackground(Color.LIGHT_GRAY);

    }  
    Oval(Color colour) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.colour = colour;  
        filledShape=true;
        ovalLabel.setText("Filled Oval");
        this.add(ovalLabel);
        this.setBackground(Color.LIGHT_GRAY);

    }  

    @Override
    public void mousePressed(MouseEvent evt) {
        x1 = evt.getX();
        y1 = evt.getY();
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
        x2 = evt.getX();
        y2 = evt.getY();
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
                g.fillOval(x2, y2, Math.abs((x1-x2)), Math.abs((y1-y2)));
            }
            if((x2<x1)&&(y2>y1)){               
                g.fillOval(x2, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2<y1)){
                g.fillOval(x1, y2, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2>y1)){
                g.fillOval(x1, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
        }
        else {
            g.setColor(colour);
            if((x2<x1)&&(y2<y1)) {
                g.drawOval(x2, y2, Math.abs((x1-x2)), Math.abs((y1-y2)));
            }
            if((x2<x1)&&(y2>y1)){               
                g.drawOval(x2, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2<y1)){
                g.drawOval(x1, y2, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
            if ((x2>x1)&&(y2>y1)){
                g.drawOval(x1, y1, Math.abs((x2-x1)), Math.abs((y2-y1)));
            }
        }
    }
    
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}