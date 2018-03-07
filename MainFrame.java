package superdraw;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    String selection;
    protected JPanel cards = new JPanel(new CardLayout());
    protected CardLayout cl = (CardLayout)(cards.getLayout());
    private Color myColour = Color.BLACK;
    private Color c = Color.BLUE;


    public MainFrame () {
        JFrame myFrame = new JFrame("Super Draw Application");

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myPanel = new JPanel();

        JButton colourButton = new JButton("Choose Colour");
        colourButton.setPreferredSize(new Dimension(100, 75));

        colourButton.addActionListener(new ButtonListener());
        myPanel.add(colourButton);

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

        //BorderLayout in order to have buttons in a narrow strip on the top
        myFrame.add(myPanel, BorderLayout.NORTH);
        myFrame.add(cards, BorderLayout.CENTER);
        myFrame.setSize(800, 800);
        myFrame.setVisible(true);

    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color c = JColorChooser.showDialog(null, "Choose a Color", myColour);

            Shape rectangle  = new Rectangle(c);
            //rectangle.setBackground(c);
            cards.add(rectangle, "rectangle");

            Shape oval = new Oval(c);
            //oval.setBackground(c);
            cards.add(oval, "oval");

            Shape line = new Line(c);
            //line.setBackground(c);
            cards.add(line, "line");

        }
    }

}