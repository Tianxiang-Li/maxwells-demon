import java.awt.*;
import javax.swing.*;

public class particles {
    double x, y;
    double vx, vy;
    double oldx, oldy;
    String color;

    public particles() {

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