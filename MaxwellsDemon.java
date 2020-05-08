import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaxwellsDemon extends JFrame 
    implements ActionListener {
    JPanel playArea;
    JPanel buttons;
    JButton reset;
    JButton addP;
    Timer clicky;
    Particle[] particles;
    int particleCount;
    double deltat = 0.1;
    double leftTemp = 0, rightTemp = 0;
    int leftCount = 0, rightCount = 0;
    int resolution = Toolkit.getDefaultToolkit().getScreenResolution();

    public static void main( String[] args ) {
        new MaxwellsDemon();
    }

    public MaxwellsDemon() {
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setTitle( "Maxwell's Demon" );
        setLayout( new GridLayout (2, 1) );

        clicky = new Timer( (int)( 1000 * deltat ), this );
        clicky.start();

        initialPlayArea();
        add(playArea);

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

    public void initialPlayArea() {
        playArea = new JPanel();
        playArea.setSize(600, 300);
        particleCount = 10;
        particles = new Particle[100];
        for ( int i = 0; i < particleCount; i++ ) { particles[i] = new Particle(); } 
        playArea.addMouseListener( 
            new MouseAdapter() {
                public void mousePressed( MouseEvent m ) {
                    for (int i = 0; i < particleCount; i++) {
                        particles[i].open = true;
                    }
                    
                }

                public void mouseReleased( MouseEvent m ) {
                    for (int i = 0; i < particleCount; i++) {
                        particles[i].open = false;
                    }
                }
            }
        );
        
    }

    @Override
    public void paint( Graphics g ) {
        g.setColor( Color.YELLOW );
        g.fillRect( 0, 0, 600, 300 );
        g.setColor( Color.BLACK );
        g.drawLine( 300, 0, 300, 300 );

        for (int i = 0; i < particleCount; i++) {
            particles[i].drawMe(g); 
            double toAdd = particles[i].v * particles[i].v;
            if (particles[i].x <= 300) { 
                leftTemp += toAdd; 
                leftCount++;
            }
            else if (particles[i].x >= 300) {
                rightTemp += toAdd; 
                rightCount++;
            }
        }
        leftTemp = leftTemp / leftCount / 10000;
        rightTemp = rightTemp / rightCount / 10000; 
        g.setColor(Color.BLACK);
        g.drawString("left chamber average temperature: " + String.format("%.2f", leftTemp), 20, 280);
        g.drawString("right chamber average temperature: " + String.format("%.2f", rightTemp), 320, 280);
        leftTemp = rightTemp = 0;
        leftCount = rightCount = 0;
    }

    public void moveAll() {
        for ( int i = 0; i < particleCount; i++ ) { particles[i].move(deltat); }
    }

    @Override
    public void actionPerformed( ActionEvent e) {
        if (e.getSource() == clicky ) { moveAll(); }
        else if ( e.getSource() == reset ) {
            initialPlayArea();
        }
        else if ( e.getSource() == addP ) {
            double x, y;
            boolean fast;
            for (int i = 0; i < 4; i++) {

                y = Math.random() * 200 + 50;

                if ( i < 2 ) {
                    x = Math.random() * 225 + 50;
                    fast = (i == 0);
                }
                else {
                    x = Math.random() * 225 + 325;
                    fast = (i == 2);
                }
                particles[particleCount++] = new Particle( (int)x, (int)y, fast );
            }

        }
        repaint();
    }

}