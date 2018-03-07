package superdraw;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ShowColours2 extends JFrame {

    private JButton changeColor;
    private Color color = Color.lightGray;
    private Container c;

    public ShowColours2()
    {
        super( "Using JColorChooser" );

        c = getContentPane();
        c.setLayout( new FlowLayout() );

        changeColor = new JButton( "Change Color" );
        changeColor.addActionListener(
                new ActionListener() {
                    public void actionPerformed( ActionEvent e )
                    {
                        color =
                                JColorChooser.showDialog( ShowColours2.this,
                                        "Choose a color", color );

                        if ( color == null )
                            color = Color.lightGray;

                        c.setBackground( color );
                        c.repaint();
                    }
                }
        );
        c.add( changeColor );

        setSize( 400, 130 );
        show();
    }

    public static void main( String args[] )
    {
        ShowColours2 app = new ShowColours2();

        app.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing( WindowEvent e )
                    {
                        System.exit( 0 );
                    }
                }
        );
    }
}