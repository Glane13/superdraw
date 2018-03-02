package superdraw;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class Shape extends JPanel {
     int x1, y1, x2, y2;
     Color colour;

    public void setX1 (int x1){
        this.x1 = x1;
    }
    public int getX1 (){
        return x1;
    }
    public void setY1 (int y1){
        this.y1 = y1;
    }
    public int getY1 (){
        return y1;
    }
    public void setX2 (int x2){
        this.x2 = x2;
    }
    public int getX2 (){
        return x2;
    }
    public void setY2 (int y2){
        this.y2 = y2;
    }
    public int getY2 (){
        return y2;
    }    
    public void setColour(Color colour){
        this.colour = colour;
    }
    public Color getColour(){
        return colour;
    }
    public abstract void draw (Graphics g);  
}
