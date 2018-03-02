package superdraw;
import java.awt.Color;
import java.awt.Graphics;
public class Line extends Shape {
    
    Line (int x1, int y1, int x2, int y2, Color colour) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.colour = colour;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);      
        g.setColor(colour);
        g.drawLine(x1, y1, x2, y2);
    }
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}