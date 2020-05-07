import java.awt.*;
import java.awt.Toolkit;


public class Particle {
    double x, y;
    double v, a, vx, vy; //velocity, angle
    double oldx, oldy;
    boolean open = false;
    boolean isFast; //i.e. fast or slow
    int resolution = Toolkit.getDefaultToolkit().getScreenResolution();

    public Particle() {
        x = Math.random() * 400 + 100;
        y = Math.random() * 200 + 100;
        v = 2 + Math.random() * 4;
        a = Math.random() * 2 * Math.PI;
        vx = v * Math.cos(a);
        vy = v * Math.sin(a);
        if (v >= 4 ) { isFast = true; }
        else { isFast = false; }
    }

    public Particle( int x1, int y1, boolean speed) {

        x = x1;
        y = y1;
        isFast = speed;
        if (isFast) { v = 4 + Math.random() * 2; }
        else {v = 2 + Math.random() * 2; }
        a = Math.random() * 2 * Math.PI;
        vx = v * Math.cos(a);
        vy = v * Math.sin(a);
        
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
            if ( oldx < 299 && x >= 299 ) { vx *= -1; }
            if ( oldx > 299 && x <= 299 ) { vx *= -1; }
        }
        
        if ( x <= 1 || x >= 599 ) { vx *= -1; }
        if ( y <= 1 || y >= 299 ) { vy *= -1; }
    }

    public void drawMe( Graphics g ) {
        if ( isFast ) { g.setColor( Color.RED ); }
        else { g.setColor( Color.BLUE); }
        g.fillOval( (int)(x - 2), (int)(y - 2), 5, 5);
    }
}