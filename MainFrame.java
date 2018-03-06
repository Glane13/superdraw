package superdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import static java.awt.Color.ORANGE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Graham added swing.event.*
import javax.swing.event.*;

public class MainFrame extends JFrame implements ChangeListener {
    String selection;
    protected JPanel cards = new JPanel(new CardLayout());
    protected CardLayout cl = (CardLayout)(cards.getLayout());
    private JColorChooser ColourChooser = new JColorChooser();
    //public Color myColour = Color.BLUE;
    public static  Color newColour;
    //line added by Graham
    protected JColorChooser tcc;

    ChangeListener changeListener;
    
    
    public MainFrame () {

        JFrame myFrame = new JFrame("Super Draw Application");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel myPanel = new JPanel(new GridLayout());               
        tcc = new JColorChooser(Color.PINK);
        tcc.getSelectionModel().addChangeListener(this);
        myPanel.add(tcc);

        
        ShapeChooser myShapeComboButton = new ShapeChooser();
        myPanel.add(myShapeComboButton);
        //ActionListener listening to ShapeButton in myShapeComboButton
        ActionListener myListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = (String) myShapeComboButton.shapeButton.getSelectedItem();
                switch (selection) {

                    case "Rectangle":
                        selection = "Rectangle";
                        System.out.println("Selected Rectangle...");
                        System.out.println("selection variable is displaying: " + selection);
                        cl.show(cards, "rectangle");
                        break;

                    case "Oval" :
                        selection = "Oval";
                        System.out.println("Selected Oval...");
                        System.out.println("selection variable is displaying: " + selection);
                        cl.show(cards, "oval");
                        break;
                    
                    case "Line" :
                        selection = "Line";
                        System.out.println("Selected Line...");
                        System.out.println("selection variable is displaying: " + selection);
                        cl.show(cards, "line");
                        break;
                        
                    default:
                        selection = "Unknown";
                        System.out.println("No match found.");
                        System.out.println("selection variable is displaying: " + selection);
                        cl.show(cards, "nothing");
                        break;
                }
            }
        };
        
        myShapeComboButton.shapeButton.addActionListener(myListener);

        
        LineThicknessChooser myThicknessChooser = new LineThicknessChooser();
        myPanel.add(myThicknessChooser);
        
        //JPanels for drawing different shapes depending on selection
        System.out.println("new Colour where Rectangle is instantiated");
        
        
        //Shape rectangle  = new Rectangle(newColour);
        //rectangle.setBackground(Color.yellow);
        // TODO colour should come from color chooser object.
        //rectangle.setColour(myColour);
        
        //oval.setBackground(Color.blue);
        //oval.setColour(newColour);
        
        //line.setBackground(Color.cyan);
        //line.setColour(newColour);
        
        //JPanel nothing = new JPanel();
        //JLabel nothingLabel = new JLabel("Nothing to see here");
        //nothing.add(nothingLabel);

        
        
        
        //BorderLayout in order to have buttons in a narrow strip on the top      
        myFrame.add(myPanel, BorderLayout.NORTH);
        myFrame.add(cards, BorderLayout.CENTER);
        myFrame.setSize(800, 800);
        myFrame.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Color newColour = tcc.getColor();
        Rectangle rectangle = new Rectangle(newColour);
        Shape oval = new Oval(newColour);
        Shape line = new Line();

        //cards for use in CardLayout
        cards.add(oval, "oval");
        cards.add(rectangle, "rectangle");
        cards.add(line, "line");
        //cards.add(nothing, "nothing");    
        cards.add(rectangle, "rectangle");

       repaint();
        
    }

}
