package blitz.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, getHeight());
        int currX;
        int currY;

        for (int i = 0; i < projectile.getApexTime()*2; i++) {
            currX = (int) projectile.getX();
            currY = (int) projectile.getY();
            projectile.setTime(i);
            g.drawLine(currX, -currY, (int) projectile.getX(), -(int) projectile.getY());
        }

        g.setColor(Color.BLUE);
        g.fillOval((int) projectile.getX()/2, -(int) projectile.getPeakY(), 10, 10);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // tells the operating system to call paintComponent() again.
        repaint();
    }
}