package superdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ColourChooser extends JPanel{

    private Color myColour = Color.BLACK;
    JButton colourButton = new JButton("Choose colour");

    public ColourChooser() {
        colourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myColour = JColorChooser.showDialog(ColourChooser.this, "Choose a colour", myColour);

                if (myColour == null) {
                    myColour = Color.BLACK;
                }
            }
        });
        colourButton.setLayout(null);
        colourButton.setBounds(10, 10, 50, 50);
        add(colourButton);
    }
}
