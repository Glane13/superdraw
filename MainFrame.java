package superdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    String selection;
    protected JPanel cards = new JPanel(new CardLayout());
    protected CardLayout cl = (CardLayout)(cards.getLayout());
    

    public MainFrame () {
        JFrame myFrame = new JFrame("Super Draw Application");

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myPanel = new JPanel();

        JButton myButton = new JButton("Choose Colour");
        myButton.setPreferredSize(new Dimension(100, 75));

        ColourChooser myChooser = new ColourChooser();

        myPanel.add(myChooser);

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
        Shape rectangle  = new Rectangle();
        rectangle.setBackground(Color.yellow);
        
        Shape oval = new Oval();
        oval.setBackground(Color.blue);
        
        Shape line = new Line();
        line.setBackground(Color.cyan);
        
        JPanel nothing = new JPanel();
        JLabel nothingLabel = new JLabel("Nothing to see here");
        nothing.add(nothingLabel);

        //cards for use in CardLayout
        cards.add(oval, "oval");
        cards.add(rectangle, "rectangle");
        cards.add(line, "line");
        cards.add(nothing, "nothing");
        
        
        //BorderLayout in order to have buttons in a narrow strip on the top      
        myFrame.add(myPanel, BorderLayout.NORTH);
        myFrame.add(cards, BorderLayout.CENTER);
        myFrame.setSize(800, 800);
        myFrame.setVisible(true);

    }

}
