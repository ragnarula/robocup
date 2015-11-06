package random;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by raghavnarula on 06/11/2015.
 */
public class VectorPlay {
    public static void main(String[] args) {
        Vector2D rightCenter = new Vector2D(37,0);
        Vector2D rightOther10 = new Vector2D(30,10);

        double distance1 = 37;
        double angle1 = 0;

        double distance2 = FastMath.sqrt((37*37) + 100);
        double angle2 = FastMath.toDegrees(FastMath.asin(10.0/37.0));

        System.out.println(distance2);
        System.out.println(angle2);

        Vector2D toFirst = fromAngleDist(distance1,angle1);
        Vector2D toSecond = fromAngleDist(distance2,angle2);

        Vector2D line = toFirst.subtract(toSecond);
        System.out.println(toFirst);
        System.out.println(toSecond);
        System.out.println(line);

        double absAngle = Vector2D.angle(line, new Vector2D(0,1));

        System.out.println(FastMath.toDegrees(absAngle));

    }

    private static Vector2D fromAngleDist(double distance1, double angle1) {
        double x = distance1 * FastMath.sin(FastMath.toRadians(angle1));
        double y = distance1 * FastMath.cos(FastMath.toRadians(angle1));

        return new Vector2D(x,y);

    }

}