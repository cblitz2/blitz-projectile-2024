package blitz.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(0, 0);



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, getHeight() - 30);
        int currX;
        int currY;

        g.setColor(Color.WHITE);

        g.fillRect(0, -getHeight(), getWidth(), getHeight());

        g.setColor(Color.LIGHT_GRAY);

        for (int i = 0; i <= getWidth(); i += 30) {
            g.drawLine(i, 0, i, -getHeight());
        }

        for (int i = 0; i <= getHeight(); i += 30) {
            g.drawLine(0, -i, getWidth(), -i);
        }

        g.setColor(Color.BLACK);

        g.drawLine(30, -getHeight() + 30, 30, 0); // y axis
        g.drawLine(0, -30, getWidth(), -30); // x axis

        for (int i = 0; i < projectile.getApexTime() * 2 + 1; i++) {
            currX = (int) projectile.getX();
            currY = (int) projectile.getY();
            projectile.setTime(i);
            g.drawLine(currX, -currY, (int) projectile.getX(), -(int) projectile.getY());
        }

        g.setColor(Color.BLUE);
        g.fillOval((int) projectile.getInterceptX() / 2 - 5, (int) -projectile.getPeakY() - 5, 10, 10);
        g.drawString(String.format("(%.2f, %.2f)", projectile.getX(), projectile.getPeakY()),
                ((int) projectile.getInterceptX() / 2) - 15, ((int) -projectile.getPeakY()) - 10);


        g.setColor(Color.RED);

        g.fillOval(projectile.xAtTime(), getY(), 10, 10);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // tells the operating system to call paintComponent() again.
        repaint();
    }
}