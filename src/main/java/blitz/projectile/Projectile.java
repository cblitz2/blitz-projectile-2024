package blitz.projectile;

public class Projectile {
    private final double angle;
    private final double radians;
    private final double velocity;
    private double time;
    private static final double GRAVITY = 9.8;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public Projectile(Projectile projectile) {
        this(projectile.angle, projectile.velocity);
        this.time = projectile.time;

    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getX() {
        return Math.cos(radians) * velocity * time;
    }

    public double getY() {
        return Math.sin(radians) * velocity * time
                - (.5 * GRAVITY * time * time);
    }

    /**
     * @return the time where the projectile is at its highest point
     */

    public double getApexTime() {
        return (velocity * Math.sin(radians)) / GRAVITY;
    }

    public double getPeakY() {
        return (velocity * velocity * Math.sin(radians) * Math.sin(radians) / (2 * GRAVITY));
        //https://physics.bu.edu
    }

    public double getInterceptX() {
        return (2 * velocity * velocity * Math.sin(radians) * Math.cos(radians)) / GRAVITY;
    }

}
