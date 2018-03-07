package superdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ColourChooser extends JPanel{

    //private Color myColour = Color.BLACK;
    //JButton colourButton = new JButton("Choose colour");

    public ColourChooser() {
        /*        
        ActionListener colourListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            Color initialBackground = colourButton.getBackground();
            Color background = JColorChooser.showDialog(null,
            "JColorChooser Sample", initialBackground);
            System.out.println("Background colour: " + background.toString());
            if (background != null) {
                colourButton.setBackground(background);
            }
        }
    };
    colourButton.addActionListener(colourListener);
    */  
        
        
        
        
        
        /*
        colourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myColour = JColorChooser.showDialog(ColourChooser.this, "Choose a colour", myColour);

                if (myColour == null) {
                    myColour = Color.BLACK;
                }
            }
        });
        */
        //colourButton.setLayout(null);
        //colourButton.setBounds(10, 10, 50, 50);
        //add(colourButton);
    }
}
/*
final JButton button = new JButton("Pick to Change Background");

    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        Color initialBackground = button.getBackground();
        Color background = JColorChooser.showDialog(null,
            "JColorChooser Sample", initialBackground);
        if (background != null) {
          button.setBackground(background);
        }
      }
    };
    button.addActionListener(actionListener);
*/