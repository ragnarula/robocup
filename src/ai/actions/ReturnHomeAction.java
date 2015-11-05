package ai.actions;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class ReturnHomeAction implements Action {
    @Override
    public void takeAction(ActionsPlayer player, EnvironmentModel model) {
        Pair<Vector2D, Vector2D> homeArea = model.getHomeArea();
        Vector2D agentLocation = model.getAgentLocation();

        Vector2D homeCenter = getCenterOfArea(homeArea);

        double angle = Math.toDegrees(Vector2D.angle(homeCenter, agentLocation) - model.getAgentAbsAngel());
        if (angle > 180){
            angle = 360 - angle;
        }

        if(angle < 3 && angle > -3)
            player.dash(10);
        else
            if (angle > 90){
                player.turn(90);
            }
        else if (angle < -90){
                player.turn(-90);
            }
        else {
                player.turn(angle);
            }

    }

    private Vector2D getCenterOfArea(Pair<Vector2D, Vector2D> homeArea) {

        double newX = ((homeArea.getSecond().getX() + homeArea.getFirst().getX()) / 2);
        double newY = ((homeArea.getSecond().getY() + homeArea.getFirst().getY()) / 2);

        return new Vector2D(newX, newY);
    }
}
