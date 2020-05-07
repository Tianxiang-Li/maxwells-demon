import java.awt.*;
import javax.swing.*;

public class MaxwellsDemon extends JFrame {
    Display d;
    JPanel buttons;

    public static void main( String[] args ) {
        new MaxwellsDemon();
    }

    public MaxwellsDemon() {
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setTitle( "Maxwell's Demon" );
        setLayout( new GridLayout (2, 1) );

        d = new Display();
        add(d);

        buttons = new JPanel();
        buttons.setBackground( Color.WHITE );
        buttons.setLayout( new FlowLayout() );
        add(buttons);
    }

}