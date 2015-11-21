package ai;

import ai.actions.ReturnHomeAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * This component ensures that the agent is within the boundries of the pitch.
 * If the agent has moved off the pitch, a return home action is executed, causing the agent
 * to face it's home area and dash towards it.
 *
 * Created by raghavnarula on 18/11/2015.
 */
public class BoundryCheckAIComponent extends AbstractSimpleAIComponent {
    private CommandPlayer player;
    private ReturnHomeAction returnHomeAction = new ReturnHomeAction();

    public BoundryCheckAIComponent(CommandPlayer player) {
        this.player = player;
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        Vector2D playerLocation = model.getAgentLocation();
        if(locationIsNearBoundry(playerLocation)){
            returnHomeAction.takeAction(player, model);
            return model;
        }
        return model;
    }

    private boolean locationIsNearBoundry(Vector2D playerLocation) {
        double x = playerLocation.getX();
        double y = playerLocation.getY();
        return x > 35 || x < -35 || y > 53.5 || y < -53.5;
    }
}
