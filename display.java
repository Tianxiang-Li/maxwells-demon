import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display extends JPanel 
    implements ActionListener{
    Timer clicky;
    Particle[] particles;
    int particleCount;
    double deltat = 0.1;

    public Display() {
        setBackground( Color.WHITE );
        
        particleCount = 10;
        particles = new Particle[100];
        for ( int i = 0; i < particleCount; i++ ) { particles[i] = new Particle(); }

        clicky = new Timer( (int)( 1000 * deltat ), this );
        clicky.start();

        addMouseListener( 
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
        setSize( 600, 300 );
        setVisible(true);

    }

    public void actionPerformed( ActionEvent e ) {
        if (e.getSource() == clicky ) { moveAll(); }
        repaint();
    }

    @Override
    public void paint( Graphics g ) {
        g.setColor( Color.YELLOW );
        g.fillRect(0, 0, 600, 300);

        for ( Particle p : particles ) { p.drawMe(g); }
    }

    public void moveAll() {
        for ( Particle p : particles ) { p.move(deltat); }
    }


    
}
