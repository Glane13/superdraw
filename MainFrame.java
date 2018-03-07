package superdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    String selection;
    //protected Color selectedColour;
    protected JPanel cards = new JPanel(new CardLayout());
    protected CardLayout cl = (CardLayout)(cards.getLayout());
   
    
    private class ColourActionListener implements ActionListener {
        private Color selectedColour;
        JColorChooser jcc = new JColorChooser();      
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedColour = jcc.showDialog(null, "JColorChooser Sample", Color.PINK);
            //this.selectedColour = selectedColour;
            System.out.println("1. selectedColour in actionPerformed: " + selectedColour.toString());
            //if (this.selectedColour.toString()=="null"){
            //    System.out.println("2. this.selectedColour is Null");
            //} else {
            //System.out.println("3. this.selectedColour in action performed: " + this.selectedColour.toString());
            //}
            for (Component shape : cards.getComponents()) {
                ((Shape)shape).setColour(selectedColour);
             }
            
        }
        public Color getSelectedColour() {
            return selectedColour;
        }
    }

    public MainFrame () {
        JFrame myFrame = new JFrame("Super Draw Application");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel myPanel = new JPanel();
        JButton colourButton = new JButton("Choose colour");
        colourButton.setPreferredSize(new Dimension(100, 75));
        ColourActionListener colourActionListener = new ColourActionListener();
        colourButton.addActionListener(colourActionListener);   
        colourButton.setLayout(null);
        colourButton.setBounds(10, 10, 50, 50);
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
                        //System.out.println("Selected Rectangle...");
                        //System.out.println("selection variable is displaying: " + selection);
                        Color selectedColour = colourActionListener.getSelectedColour();
                        if (selectedColour == null){
                            System.out.println("4. selectedColour returned by colourActionListener.getSelectedColour() is null");
                        } else {
                            System.out.println("5. selectedColour returned by colourActionListener.getSelectedColour(): " + selectedColour.toString());
                        }
                        Shape rectangle  = new Rectangle(selectedColour);
                        cards.add(rectangle, "rectangle");
                        cl.show(cards, "rectangle");

                            
                        break;
                    case "Oval" :
                        selection = "Oval";
                        //System.out.println("Selected Oval...");
                        //System.out.println("selection variable is displaying: " + selection);
                        cl.show(cards, "oval");
                        break;                   
                    case "Line" :
                        selection = "Line";
                        //System.out.println("Selected Line...");
                        //System.out.println("selection variable is displaying: " + selection);
                        cl.show(cards, "line");
                        break;                        
                    default:
                        selection = "Unknown";
                        //System.out.println("No match found.");
                        //System.out.println("selection variable is displaying: " + selection);
                        cl.show(cards, "nothing");
                        break;
                }
            }
        };
        
        myShapeComboButton.shapeButton.addActionListener(myListener);
        
        LineThicknessChooser myThicknessChooser = new LineThicknessChooser();
        myPanel.add(myThicknessChooser);

        
        //JPanels for drawing different shapes depending on selection
        //System.out.println("selectedColour before new Rectangle()" + selectedColour.toString());
        /*
        selectedColour = colourActionListener.getSelectedColour();
            if (selectedColour == null){
                System.out.println("4. selectedColour returned by colourActionListener.getSelectedColour() is null");
            } else {
                System.out.println("5. selectedColour returned by colourActionListener.getSelectedColour(): " + selectedColour.toString());
        }
        if (this.selectedColour == null){
                System.out.println("6. this selectedColour is null");
            } else {
                System.out.println("7. this.selectedColour: " + selectedColour.toString());
        }
*/
        
        Shape rectangle  = new Rectangle(Color.ORANGE);
        //rectangle.setBackground(selectedColour);
        
        Shape oval = new Oval(Color.ORANGE);
        //oval.setBackground(Color.blue);
        
        Shape line = new Line(Color.ORANGE);
        //line.setBackground(Color.cyan);
        
        JPanel nothing = new JPanel();
        JLabel nothingLabel = new JLabel("Nothing to see here");
        nothing.add(nothingLabel);

        //cards for use in CardLayout
        cards.add(oval, "oval");
        cards.add(rectangle, "rectangle");
        cards.add(line, "line");
        //cards.add(nothing, "nothing");
                
        //BorderLayout in order to have buttons in a narrow strip on the top      
        myFrame.add(myPanel, BorderLayout.NORTH);
        myFrame.add(cards, BorderLayout.CENTER);
        myFrame.setSize(800, 800);
        myFrame.setVisible(true);
    }
}
