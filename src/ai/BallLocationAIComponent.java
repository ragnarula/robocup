package ai;

import ai.model.EnvironmentModel;
import info.SeeBallInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.List;

/**
 * Component to locate the ball on the pitch as a vector.
 *
 * Created by James on 10/11/2015.
 */
public class BallLocationAIComponent extends AbstractSimpleAIComponent {

    private static volatile Vector2D prevBallLocation;

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        List<SeeBallInfo> balls = model.getLastPercept().getSeenBalls();

        // if no new ball info, use previous location
        if(balls.isEmpty()){
            Vector2D ball = prevBallLocation;
            if(ball == null){
                //if no previous info, give up.
                return model;
            }

            model.setBallLocation(ball);

            double angle = Vector2D.angle(ball, model.getAgentLocation());
            // set ball angle, compensating for unsigned angle given by taking angle between two vectors.
            if(model.getAgentLocation().getX() > ball.getX()){
                angle = (FastMath.PI*2) - angle;
            }
            model.setBallAngle(angle);
            return model;
        }

        SeeBallInfo ball = balls.get(balls.size() - 1);

        double absAngle = model.getAgentAbsAngleRadians() + FastMath.toRadians(ball.getDirection());
        // get a vector from direction and distance.
        Vector2D ballLocation = EnvironmentModel.getLocationFromRelativeInfo(model.getAgentLocation(),
                absAngle,
                ball.getDistance());

        model.setBallLocation(ballLocation);
        model.setBallAngle(absAngle);
        prevBallLocation = ballLocation;

        return model;
    }

}
