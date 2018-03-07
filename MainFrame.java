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
                        Shape rectangle  = new Rectangle(Color.ORANGE);
                        cards.add(rectangle, "rectangle");
                        cl.show(cards, "rectangle");                           
                        break;
                    case "Oval" :
                        selection = "Oval";
                        Shape oval = new Oval(Color.ORANGE);
                        cards.add(oval, "oval");                       
                        cl.show(cards, "oval");
                        break;                   
                    case "Line" :
                        selection = "Line";
                        Shape line = new Line(Color.ORANGE);
                        cards.add(line, "line");
                        cl.show(cards, "line");
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
}
