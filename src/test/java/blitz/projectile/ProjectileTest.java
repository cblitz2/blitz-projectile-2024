package blitz.projectile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest {

    @Test
    public void getX() {

        // given
        Projectile projectile = new Projectile(31, 20);
        projectile.setTime(2.7);

        // when
        double actual = projectile.getX();

        // then
        assertEquals(46.28, actual, 0.01);
    }

    @Test
    public void getY() {

        // given
        Projectile projectile = new Projectile(31, 20);
        projectile.setTime(2.7);

        // when
        double actual = projectile.getY();

        // then
        assertEquals(-7.90, actual, 0.01);
    }


    //test getApexTime
    @Test
    public void getApexTime() {

        // given
        Projectile projectile = new Projectile(31, 20);
        projectile.setTime(2.7);

        // when
        double actual = projectile.getApexTime();

        // then
        assertEquals(1.05, actual, 0.01);
    }

    @Test
    public void getPeakY() {

        // given
        Projectile projectile = new Projectile(31, 65);

        // when
        double actual = projectile.getPeakY();

        // then
        assertEquals(57.18, actual, 0.01);
    }


    @Test
    public void getInterceptX() {

        // given
        Projectile projectile = new Projectile(31, 65);

        // when
        double actual = projectile.getInterceptX();

        // then
        assertEquals(380.65, actual, 0.01);

    }

}