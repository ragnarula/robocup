package ai;

import ai.model.EnvironmentModel;
import info.SeeFlagInfo;
import org.apache.commons.math3.analysis.function.Cos;
import org.apache.commons.math3.analysis.function.Sin;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class AgentLocationAIComponent extends AbstractSimpleAIComponent{

    private static Sin sine = new Sin();
    private static Cos cosine = new Cos();

    private Vector2D currentLocation;

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {

        List<SeeFlagInfo> seenFlags = model.getPercepts().get(0).getSeenFlags();
        SeeFlagInfo flag = seenFlags.stream()
                                    .filter(f -> f.getLine() == SeeFlagInfo.FlagLine.BOUNDRY)
                                    .findFirst()
                                    .orElseGet(null);

        if(noLocationAvailable(flag)){
            return model;
        }

        if(noFlags(flag)){
            model.setAgentLocation(currentLocation);
            return model;
        }

        Vector2D agentLocation = getLocationFromFlag(flag);
        model.setAgentAbsAngel(Math.toRadians(flag.getBodyFacingDirection() + flag.getHeadFacingDirection()));
        model.setAgentLocation(agentLocation);

        return model;
    }

    private boolean noFlags(SeeFlagInfo flag) {
        return flag == null;
    }

    private boolean noLocationAvailable(SeeFlagInfo flag) {
        return currentLocation == null && flag == null;
    }

    public Vector2D getLocationFromFlag(SeeFlagInfo flag) {
        double absDirection = Math.toRadians((flag.getBodyFacingDirection() + flag.getHeadFacingDirection() + flag.getDirection()));
        double x = (sine.value(absDirection) * flag.getDistance());
        double y = (cosine.value(absDirection) * flag.getDistance());

        x = getX(flag, x);
        y = getY(flag, y);

        return new Vector2D(x, y);
    }

    private double getX(SeeFlagInfo flag, double x) {
        if(flag.isFlagLeftField()) {
            return x - flag.getX();
        }

        if(flag.isFlagRightField()) {
            return flag.getX() - x;
        }

        return flag.getX();
    }

    private double getY(SeeFlagInfo flag, double y) {
        if(flag.isFlagUpField()){
            return flag.getY() - y;
        }

        if(flag.isFlagDownField()) {
            return y - flag.getY();
        }

        return flag.getY();
    }
}
