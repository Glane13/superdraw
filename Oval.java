package superdraw;
import java.awt.Color;
import java.awt.Graphics;

public class Oval extends BoundedShape {
    Oval(int x1, int y1, int x2, int y2) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        filledShape=false;
    }  
    Oval(int x1, int y1, int x2, int y2, Color colour) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.colour = colour;
        filledShape=true;
    }  
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(filledShape){
            g.setColor(colour);
            g.fillOval(x1, y1, x2, y2);
        }
        else {
           g.drawOval(x1, y1, x2, y2);
        }
    }
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}