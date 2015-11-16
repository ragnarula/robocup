package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public interface Action {
    void takeAction(CommandPlayer player, EnvironmentModel model);

    static boolean almostFacing(double angle1, double angle2) {
        return FastMath.abs(angle1 - angle2) <= 0.5;
    }

    static boolean onTarget(double anglebetween, double distance, double maxMargin){
        if(distance < 0.7){
            return FastMath.abs(anglebetween / distance) < 0.001;
        }
        return FastMath.abs(anglebetween / distance) < maxMargin;
    }
}
