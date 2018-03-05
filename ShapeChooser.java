package superdraw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShapeChooser extends JPanel {

    String[] shapeList = {"Rectangle", "Oval", "triangle"};
    JComboBox shapeButton = new JComboBox(shapeList);

    public ShapeChooser () {
        /*
        ActionListener myListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selection = (String) shapeButton.getSelectedItem();

                switch (selection) {

                    case "Rectangle":
                        System.out.println("Selected Rectangle...");
                        break;

                    case "Oval" :
                        System.out.println("Selected Oval...");
                        break;

                    default:
                        System.out.println("No match found.");
                        break;
                }
            }
        };
        */

        //shapeButton.addActionListener(myListener);
        add(shapeButton);
    }
}
