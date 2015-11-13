package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by James on 12/11/2015.
 */
public class DefendAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        Vector2D ballLocation = model.getBallLocation();
        Vector2D agentLocation = model.getAgentLocation();
        Vector2D agentToBall = ballLocation.subtract(agentLocation);

        double unsignedAngleToBallRadians = Vector2D.angle(agentToBall, new Vector2D(0,1));
        double angleToBallRadians = unsignedAngleToBallRadians;
        if(ballLocation.getX() < agentLocation.getX()){
            angleToBallRadians = ((2 * FastMath.PI) - unsignedAngleToBallRadians);
        }
        double agentAngleRadians = model.getAgentAbsAngleRadians();

        if(!almostFacing(agentAngleRadians, angleToBallRadians)){
            turn(player, angleToBallRadians - agentAngleRadians);
        }
        else {
            player.dash(50);
        }

    }

    private boolean almostFacing(double angle1, double angle2) {
        return FastMath.abs(angle1 - angle2) <= 0.5;
    }

    private void turn(CommandPlayer player, double angleToHomeRadians) {
        double angleDegrees = FastMath.toDegrees(angleToHomeRadians);
        if(angleDegrees > 180){
            angleDegrees = angleDegrees - 360;
        }
        if(angleDegrees < 90 && angleDegrees > -90){
            player.turn(angleDegrees);
            return;
        }
        if(angleDegrees > 90){
            player.turn(90);
            return;
        }
        if(angleDegrees < -90){
            player.turn(-90);
            return;
        }
    }
}
