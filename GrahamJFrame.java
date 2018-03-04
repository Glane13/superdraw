package superdraw;
import java.awt.Color;
//import static java.awt.Color.red;
import java.awt.GridLayout;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class GrahamJFrame extends JFrame {

    GrahamJFrame () {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2,3));
        
        Color lineColour = new Color(555666777);
        Shape line = new Line(lineColour);
        line.setBackground(Color.blue);
        
        Shape emptyOval = new Oval();
        emptyOval.setBackground(Color.red); 

        Color ovalColour = new Color(111222333);
        Shape filledOval = new Oval(ovalColour);
        filledOval.setBackground(Color.white);
        
        Shape emptyRectangle  = new Rectangle();        
        emptyRectangle.setBackground(Color.yellow);
        
        Color rectColour = new Color(555444333);
        Shape filledRectangle  = new Rectangle(rectColour);
        filledRectangle.setBackground(Color.pink);

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
