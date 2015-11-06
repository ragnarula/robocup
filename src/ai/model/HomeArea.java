package ai.model;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

/**
 * Created by raghavnarula on 06/11/2015.
 */
public class HomeArea {

    private Vector2D topLeft;
    private Vector2D botRight;

    public HomeArea(Vector2D topLeft, Vector2D botRight) {
        this.topLeft = topLeft;
        this.botRight = botRight;
    }

    public HomeArea(double x1, double y1, double x2, double y2){
        this.topLeft = new Vector2D(x1,y1);
        this.botRight = new Vector2D(x2,y2);
    }

    public Vector2D getMidpoint() {

        double newX = ((botRight.getX() + topLeft.getX()) / 2);
        double newY = ((botRight.getY() + topLeft.getY()) / 2);

        return new Vector2D(newX, newY);
    }

    public boolean contains(Vector2D other) {

        return other.getX() <= botRight.getX() &&
                other.getX() >= topLeft.getX() &&
                other.getY() >= botRight.getY() &&
                other.getY() <= topLeft.getY();
    }
}
