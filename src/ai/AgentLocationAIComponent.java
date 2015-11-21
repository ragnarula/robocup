package ai;

import ai.model.Command;
import ai.model.EnvironmentModel;
import info.SeeFlagInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.List;

/**
 * This component calculates the Agents location as accurately as possible.
 * Either the location is form flags and the calculated angle in the AngleComponent, or it is
 * estimated from commands.
 *
 * Created by raghavnarula on 03/11/2015.
 */
public class AgentLocationAIComponent extends AbstractSimpleAIComponent{

    private EnvironmentModel prevModel;

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {

        //if agent has been moved, update location to move command
        if(agentHasBeenMoved(model)){
            Vector2D currentLocation = getLocationFromMove(model);
            model.setAgentLocation(currentLocation);
            prevModel = model;
            return model;
        }

        //try to get location from flags
        if(modelContainsBoundryFlags(model)){
            List<SeeFlagInfo> seenFlags = model.getLastPercept().getSeenFlags();
            //sort by distance
            SeeFlagInfo flag = seenFlags.stream()
                    .filter(SeeFlagInfo::isBoundryFlag)
                    .min((l, r) -> {
                        if (l.getDistance() > r.getDistance())
                            return 1;
                        if (l.getDistance() < r.getDistance())
                            return -1;
                        else return 0;
                    })
                    .get();
            Vector2D currentLocation = getLocationFromFlag(flag, model);
            model.setAgentLocation(currentLocation);
            prevModel = model;
            return model;
        }

        //final resort, estimate position from previous model and movement commands
        Vector2D prevLocation = prevModel.getAgentLocation();
        Vector2D prevVelocity = prevModel.getAgentVelocityVector();
        //get total dash poser
        int dashPower = model.getCommands().stream()
                .filter(Command::isDashCommand)
                .map(Command::getIntValue)
                .reduce(0, (a,b)-> a+b);

        double angle = model.getAgentAbsAngleRadians();
        double powerRate = 0.006;
        double x = FastMath.cos(angle) * dashPower * powerRate;
        double y = FastMath.sin(angle) * dashPower * powerRate;
        Vector2D accel = new Vector2D(x,y);
        Vector2D newVelocity = prevVelocity.add(accel);

        Vector2D estimatedLocation = prevLocation.add(newVelocity);

        model.setAgentLocation(estimatedLocation);
        prevModel = model;

        return model;
    }

    private boolean modelContainsBoundryFlags(EnvironmentModel model) {
        return model.getLastPercept().getSeenFlags()
                .stream()
                .filter(SeeFlagInfo::isBoundryFlag)
                .count() > 0;
    }

    private Vector2D getLocationFromMove(EnvironmentModel model) {
        return model.getCommands()
                .stream()
                .filter(Command::isMoveCommand)
                .reduce((prev, curr) -> curr)
                .get()
                .getVector2DValue();
    }

    private boolean agentHasBeenMoved(EnvironmentModel model) {
        return model.getCommands().stream().filter(Command::isMoveCommand).count() != 0;
    }

    private Vector2D getLocationFromFlag(SeeFlagInfo flag, EnvironmentModel model) {

        double agentAngle = model.getAgentAbsAngleRadians();
        double flagAngle = FastMath.toRadians(flag.getDirection());

        double x = (FastMath.sin(agentAngle + flagAngle) * flag.getDistance());
        double y = (FastMath.cos(agentAngle + flagAngle) * flag.getDistance());

        Vector2D agentToFlag = new Vector2D(x,y);
        Vector2D flagLoc = flag.getBoundryFlagLocation();

        return flagLoc.subtract(agentToFlag);
    }
}
