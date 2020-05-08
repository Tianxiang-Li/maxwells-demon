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
        x = Math.random() * 500 + 50;
        y = Math.random() * 200 + 50;
        oldx = x;
        oldy = y;
        v = (2 + Math.random() * 4) * resolution;
        a = Math.random() * 2 * Math.PI;
        vx = v * Math.cos(a);
        vy = v * Math.sin(a);
        if (v >=  400 ) { isFast = true; }
        else { isFast = false; }
    }

    public Particle( int x1, int y1, boolean speed) {

        x = x1;
        y = y1;
        isFast = speed;
        if (isFast) { v = (4 + Math.random() * 2) * resolution; }
        else {v = (2 + Math.random() * 2) * resolution; }
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
            if ( oldx < 300 && x >= 300 ) { vx *= -1; }
            if ( oldx > 300 && x <= 300 ) { vx *= -1; }
        }
        
        if ( x <= 50 || x >= 550 ) { vx *= -1; }
        if ( y <= 50 || y >= 250 ) { vy *= -1; }
    }

    public void drawMe( Graphics g ) {
        if ( isFast ) { g.setColor( Color.RED ); }
        else { g.setColor( Color.BLUE); }
        g.fillOval( (int)(x - 2), (int)(y - 2), 5, 5);
    }
}