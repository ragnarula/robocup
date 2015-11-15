package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public interface Action {
    void takeAction(CommandPlayer player, EnvironmentModel model);

    static void turn(CommandPlayer player, double angleToHomeRadians) {
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

    static boolean almostFacing(double angle1, double angle2) {
        return FastMath.abs(angle1 - angle2) <= 0.5;
    }

    static boolean onTarget(double anglebetween, double distance, double maxMargin){

        return (FastMath.sin(anglebetween) * distance) < maxMargin;
    }
}
