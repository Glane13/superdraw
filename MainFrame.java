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
   
    
    private class ColourActionListener implements ActionListener {
        private Color selectedColour;
        JColorChooser jcc = new JColorChooser();      
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedColour = jcc.showDialog(null, "JColorChooser Sample", Color.PINK);
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
        colourButton.setPreferredSize(new Dimension(150, 40));
               
        ColourActionListener colourActionListener = new ColourActionListener();
        colourButton.addActionListener(colourActionListener);   
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
                        //Color selectedColour = colourActionListener.getSelectedColour();                       
                        cl.show(cards, "rectangle");                           
                        break;
                    case "Oval" :
                        selection = "Oval";
                        cl.show(cards, "oval");
                        break;                   
                    case "Line" :
                        selection = "Line";
                        cl.show(cards, "line");
                        break;                        
                    default:
                        selection = "Unknown";
                        cl.show(cards, "nothing");
                        break;
                }
            }
        };
        
        myShapeComboButton.shapeButton.addActionListener(myListener);
        
        LineThicknessChooser myThicknessChooser = new LineThicknessChooser();
        myPanel.add(myThicknessChooser);
 
        Shape rectangle  = new Rectangle(Color.white);       
        Shape oval = new Oval(Color.white);        
        Shape line = new Line(Color.white);

        //cards for use in CardLayout
        cards.add(rectangle, "rectangle");
        cards.add(oval, "oval");
        cards.add(line, "line");
                
        //BorderLayout in order to have buttons in a narrow strip on the top      
        myFrame.add(myPanel, BorderLayout.NORTH);
        myFrame.add(cards, BorderLayout.CENTER);
        myFrame.setSize(800, 800);
        myFrame.setVisible(true);
    }
}
