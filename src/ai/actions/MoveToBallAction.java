package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import info.SeeBallInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by James on 12/11/2015.
 */
public class MoveToBallAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        Vector2D ballLocation = model.getBallLocation();
        Vector2D goalLocation = model.getGoalLocation();
        Vector2D ownGoalLocation = model.getOwnGoalLocation();
        double angleToTurn = model.getBallAngle() - model.getAgentAbsAngleRadians();

        if (!model.getLastPercept().getSeenBalls().isEmpty()) {
            SeeBallInfo seeBallInfo = model.getLastPercept().getLastSeenBall();
            double dirChange = seeBallInfo.getDirChange();
            double distanceToBall = seeBallInfo.getDistance();

            if (distanceToBall > 5) {

                angleToTurn += dirChange;
                
                if (Math.abs(angleToTurn) > (Math.PI / 3)) {
                    if (angleToTurn > 0)
                        angleToTurn = (Math.PI / 3);
                    else
                        angleToTurn = -(Math.PI / 3);
                }
            }
        }

        if (Math.abs(angleToTurn) <= (Math.PI / 3)) {
            if (ballLocation.distance(ownGoalLocation) < 23.5 || ballLocation.distance(goalLocation) < 23.5) {
                player.dash(120);
            } else {
                player.dash(80);
            }
        }

        player.turn(angleToTurn);
    }
}
