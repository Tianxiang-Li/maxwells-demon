import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class display extends JFrame {
    JPanel playArea;
    Particle[] particles;
    
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
                    for (Particle p : particles) {
                        p.open = true;
                    }
                    
                }

                public void mouseReleased( MouseEvent m ) {
                    for (Particle p : particles) {
                        p.open = false;
                    }
                }

            }
        );
         
    }

    
}
