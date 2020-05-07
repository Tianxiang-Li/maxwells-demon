import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class display extends JFrame {
    JPanel playArea;
    Particle[] particles;
    boolean open = false;
    
    public static void main( String[] args ) {
        new display();
    }

    public display() {
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setTitle( "Maxwell's Demon" );

        playArea = new JPanel();
        playArea.setBackground( Color.white );
        this.add( playArea );
        
        playArea.addMouseListener( 
            new MouseAdapter() {
                public void mousePressed( MouseEvent m ) {
                    open = true;
                }

                public void mouseClicked( MouseEvent m ) {
                    open = true;
                }
            }
        ); 
    }

    
}
