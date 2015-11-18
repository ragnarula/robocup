package ai;

import ai.model.EnvironmentModel;
import info.SeeBallInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.List;

/**
 * Created by James on 10/11/2015.
 */
public class BallLocationAIComponent extends AbstractSimpleAIComponent {

    private static volatile Vector2D sharedBallInfo;

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        List<SeeBallInfo> balls = model.getLastPercept().getSeenBalls();
        if(balls.isEmpty()){
            Vector2D ball = sharedBallInfo;
            model.setBallLocation(ball);
            double angle = Vector2D.angle(ball, model.getAgentLocation());
            if(model.getAgentLocation().getX() > ball.getX()){
                angle = (FastMath.PI*2) - angle;
            }
            model.setBallAngle(angle);
            return model;
        }
        SeeBallInfo ball = balls.get(balls.size() - 1);

        double absAngle = model.getAgentAbsAngleRadians() + FastMath.toRadians(ball.getDirection());

        Vector2D ballLocation = EnvironmentModel.getLocationFromRelativeInfo(model.getAgentLocation(),
                absAngle,
                ball.getDistance());

        model.setBallLocation(ballLocation);
        model.setBallAngle(absAngle);
        sharedBallInfo = ballLocation;

        return model;
    }

}
