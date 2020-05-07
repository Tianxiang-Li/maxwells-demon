import java.awt.*;
import java.awt.Toolkit;

public class Particle {
    double x, y;
    double vx, vy;
    double oldx, oldy;
    boolean open = false;
    boolean isFast; //i.e. fast or slow
    int resolution = Toolkit.getDefaultToolkit().getScreenResolution();

    public Particle( int x1, int y1, boolean speed) {
        x = x1;
        y = y1;
        isFast = speed;
        
    }

    public void move( double deltat ) {
        oldx = x;
        oldy = y;

        x += vx * deltat;
        y += vy * deltat;
        stayInArea();
    }

    public void stayInArea() {
        if (!open) {
            if ( oldx < 300 && x >= 300 ) { vx *= -1; }
            if ( oldx > 300 && x <= 300 ) { vx *= -1; }
        }
        
        if ( x <= 0 || x >= 600 ) { vx *= -1; }
        if ( y <= 0 || y >= 600 ) { vy *= -1; }
    }

    public void drawMe( Graphics g ) {
        if ( isFast ) { g.setColor( Color.RED ); }
        else { g.setColor( Color.BLUE); }
        g.fillOval( (int)x, (int)y, 5, 5);
    }
}