package blitz.projectile;

public class Projectile {
    private final double angle;
    private final double radians;
    private final double velocity;
    private double time;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getX() {
        return Math.cos(radians) * velocity * time;
    }

    public double getY() {
        return Math.sin(radians) * velocity * time
                - (.5 * 9.8 * time * time);
    }

    /**
     * @return the time where the projectile is at its highest point
     */

    public double getApexTime() {
        return (velocity * Math.sin(radians)) / 9.8;
    }

    public double getPeakY() {
        return (velocity * velocity * Math.sin(radians) * Math.sin(radians) / (2 * 9.8));
        //https://physics.bu.edu
    }

}
