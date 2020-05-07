import java.awt.*;
import javax.swing.*;

public class Particle {
    double x, y;
    double vx, vy;
    double oldx, oldy;
    boolean isFast; //i.e. fast or slow

    public Particle() {

    }

    public void move( double deltat ) {
        oldx = x;
        oldy = y;

        x += vx * deltat;
        y += vy * deltat;
        stayInArea();
    }

    public void stayInArea() {

    }

    public void drawMe( Graphics g ) {
        
    }
}