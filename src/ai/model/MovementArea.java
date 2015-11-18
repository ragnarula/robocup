package ai.model;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * A Movement Area is an area on the pitch, where the agent can only actively play if
 * the ball is within it.
 *
 * Created by James on 10/11/2015.
 */
public class MovementArea {
    private Vector2D topLeft;
    private Vector2D botRight;

    public MovementArea(Vector2D topLeft, Vector2D botRight) {
        this.topLeft = topLeft;
        this.botRight = botRight;
    }

    public MovementArea(double x1, double y1, double x2, double y2){
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

    public boolean extendsToGoal() {
        return topLeft.getY() == 52.5;
    }
}
