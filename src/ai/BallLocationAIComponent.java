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

    private static volatile SeeBallInfo sharedBallInfo;

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        SeeBallInfo ball;
        List<SeeBallInfo> balls = model.getLastPercept().getSeenBalls();
        if(balls.isEmpty()){
            ball = sharedBallInfo;
            balls.add(sharedBallInfo);
        }
        else {
            ball = balls.get(balls.size() - 1);
            sharedBallInfo = ball;
        }

        if(ball == null){
            return model;
        }
        double absAngle = model.getAgentAbsAngleRadians() + FastMath.toRadians(ball.getDirection());

        Vector2D ballLocation = EnvironmentModel.getLocationFromRelativeInfo(model.getAgentLocation(),
                absAngle,
                ball.getDistance());

        model.setBallLocation(ballLocation);
        return model;
    }

}
