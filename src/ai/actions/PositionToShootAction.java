package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import info.SeeBallInfo;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by raghavnarula on 16/11/2015.
 */
public class PositionToShootAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
//        SeeBallInfo ball = model.getLastPercept().getLastSeenBall();
//        double agentAbsAngle = model.getAgentAbsAngleRadians();
//        double totalBallAngle = FastMath.toRadians(ball.getDirection()) + agentAbsAngle;
//        double ballDist = ball.getDistance();
//        double totalAngle = ballAngle + agentAbsAngle;

        player.dash(30);
        player.turn(FastMath.PI);

    }
}
