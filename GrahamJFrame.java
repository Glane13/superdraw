package superdraw;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class GrahamJFrame extends JFrame {
    GrahamJFrame () {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        Color colour = new Color(555666777);
        Shape line       = new Line(30,30,80,80,colour);
        //empty oval - only 4 parameters
        Shape emptyOval       = new Oval(30,30,80,80);
        //filled oval - has 5th parameter colour
        Shape filledOval       = new Oval(30,30,80,80, colour);
        // empty rectangle - only 4 parameters
        Shape emptyRectangle  = new Rectangle(30,30,80,80);
        // filled rectangle - has 5th parameter colour
        Shape filledRectangle  = new Rectangle(30,30,80,80, colour);
        frame.add(line);
        frame.add(emptyOval);
        frame.add(filledOval);
        frame.add(emptyRectangle);
        frame.add(filledRectangle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);    
    }
}
