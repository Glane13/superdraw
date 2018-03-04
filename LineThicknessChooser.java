package superdraw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineThicknessChooser extends JPanel {


    String[] thickness = {"1", "2", "3", "4", "5"};
    JComboBox thicknessButton = new JComboBox(thickness);

    public LineThicknessChooser () {

        ActionListener myListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selection = (String) thicknessButton.getSelectedItem();

                switch (selection) {

                    case "1":
                        System.out.println("Selected 1...");

                    case "2" :
                        System.out.println("Selected 2...");

                    default:
                        System.out.println("No match found.");
                }
            }
        };

        thicknessButton.addActionListener(myListener);
        add(thicknessButton);

    }


}