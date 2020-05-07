import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaxwellsDemon extends JFrame 
    implements ActionListener {
    Display d;
    JPanel buttons;
    JButton reset;
    JButton addP;

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
        reset = new JButton( "reset" );
        add(reset);
        reset.addActionListener(this);

        addP = new JButton( "add particles" );
        add(addP);
        addP.addActionListener(this);


        setSize( new Dimension( 600, 600 ) );
        setVisible(true);
    }

    @Override
    public void actionPerformed( ActionEvent e) {
        if ( e.getSource() == reset ) {
            d = new Display();
        }
        else if ( e.getSource() == addP ) {
            double x, y;
            boolean fast;
            for (int i = 0; i < 4; i++) {

                y = Math.random() * 200 + 100;

                if ( i < 2 ) {
                    x = Math.random() * 200 + 100;
                    fast = (x < 1);
                }
                else {
                    x = Math.random() * 200 + 400;
                    fast = (x > 2);
                }
                d.particles[d.particleCount++] = new Particle( (int)x, (int)y, fast );
            }

        }
        repaint();
    }

}