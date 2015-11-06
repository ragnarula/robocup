package ai;

import ai.model.EnvironmentModel;
import info.SeeFlagInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.List;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class AgentLocationAIComponent extends AbstractSimpleAIComponent{

    private Vector2D currentLocation;

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {

        List<SeeFlagInfo> seenFlags = model.getLastPercept().getSeenFlags();
        SeeFlagInfo flag = seenFlags.stream()
                                    .filter(SeeFlagInfo::isBoundryFlag)
                                    .min((l, r )-> {
                                        if (l.getDistance() > r.getDistance())
                                            return 1;
                                        if (l.getDistance() < r.getDistance())
                                            return -1;
                                        else return 0;
                                    })
                                    .orElseGet(null);

        if(noLocationAvailable(flag)){
            return model;
        }

        if(noFlags(flag)){
            model.setAgentLocation(currentLocation);
            return model;
        }

        currentLocation = getLocationFromFlag(flag);
        model.setHeadFacingRadians(FastMath.toRadians(flag.getHeadFacingDirection()));
        model.setBodyFacingRadians(FastMath.toRadians(flag.getBodyFacingDirection()));
        model.setAgentLocation(currentLocation);

        return model;
    }

    private boolean noFlags(SeeFlagInfo flag) {
        return flag == null;
    }

    private boolean noLocationAvailable(SeeFlagInfo flag) {
        return currentLocation == null && flag == null;
    }

    private Vector2D getLocationFromFlag(SeeFlagInfo flag) {

        double absDirection = flag.getFlagAbsAngleRadians();

        double x = (FastMath.sin(absDirection) * flag.getDistance());
        double y = (FastMath.cos(absDirection) * flag.getDistance());

        Vector2D agentToFlag = new Vector2D(x,y);
        Vector2D flagLoc = flag.getBoundryFlagLocation();

        return flagLoc.subtract(agentToFlag);
    }
}
