package superdraw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShapeChooser extends JPanel {

    String[] shapeList = {"Rectangle", "Oval", "Line"};
    JComboBox shapeButton = new JComboBox(shapeList);

    public ShapeChooser () {

        add(shapeButton);
    }
}
