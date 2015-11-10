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

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {

//        TODO: Handle case when player can't see the ball

        List<SeeBallInfo> ball = model.getLastPercept().getSeenBalls();

        if(ball.size() > 0) {
            model.setBallLocation(getLocation(model, ball.get(ball.size() - 1)));
        }

        return model;
    }

    private Vector2D getLocation(EnvironmentModel model, SeeBallInfo ball) {
        double agentAngle = model.getAgentAbsAngleRadians();
        double ballAngle = FastMath.toRadians(ball.getDirection());

        double x = (FastMath.sin(agentAngle + ballAngle) * ball.getDistance());
        double y = (FastMath.cos(agentAngle + ballAngle) * ball.getDistance());

        Vector2D agentToBall = new Vector2D(x,y);
        Vector2D agentLocation = model.getAgentLocation();

        return agentLocation.add(agentToBall);
    }


}
