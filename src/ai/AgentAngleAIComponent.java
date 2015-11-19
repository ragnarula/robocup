package ai;

import ai.model.Command;
import ai.model.EnvironmentModel;
import info.Percept;
import info.SeeFlagInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AgentAngleAIComponent extends AbstractSimpleAIComponent {

    private EnvironmentModel prevModel = AgentAngleAIComponent.getInitialModel();

    public static EnvironmentModel getInitialModel() {
        EnvironmentModel model = new EnvironmentModel(new ArrayList<>(), new ArrayList<>());
        model.setAgentAbsAngleRadians(0);
        return model;
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        List<SeeFlagInfo> seenFlags = model.getLastPercept().getSeenFlags();

        //get only boundary flags
        List<SeeFlagInfo> boundryFlags = seenFlags.stream()
                .filter(SeeFlagInfo::isBoundryFlag)
                .collect(Collectors.toList());

        //group by the side the flags are on
        Map<SeeFlagInfo.FlagSide, List<SeeFlagInfo>> flagSides = boundryFlags.stream()
                .collect(Collectors.groupingBy(SeeFlagInfo::getSide));

        //filter to sides with have 2 or more flags
        Map<SeeFlagInfo.FlagSide, List<SeeFlagInfo>> flagSidesAboveTwo = flagSides.entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        //if we don't have enough flags, use another method.
        if (flagSidesAboveTwo.isEmpty()) {
            model.setAgentAbsAngleRadians(getEstimatedAngle(model));
            prevModel = model;
            return model;
        }

        //find the list with the nearest flag
        List<SeeFlagInfo> nearestFlags = findNearest(flagSidesAboveTwo.values());

        double agentAngleRadians = getAgentAngleFromFlags(nearestFlags);

        model.setAgentAbsAngleRadians(agentAngleRadians);
        model.setHasAgentAbsAngle();
        prevModel = model;
        return model;
    }

    private double getEstimatedAngle(EnvironmentModel model) {
        List<Command> commands = model.getCommands();
        if(commands.isEmpty()){
            return prevModel.getAgentAbsAngleRadians();
        }

        double totalTurnDegrees = 0;
        totalTurnDegrees += commands.stream()
                .filter(c -> c.getType() == Command.Type.TURN)
                .map(Command::getDoubleValue)
                .reduce(0.0, (a, b) -> a + b);

        return prevModel.getAgentAbsAngleRadians() + FastMath.toRadians(totalTurnDegrees);
    }

    private double getAgentAngleFromFlags(List<SeeFlagInfo> nearestFlags) {
        //sort to use nearest flags
        List<SeeFlagInfo> flagsSorted = sortFlagsByDistance(nearestFlags);

        SeeFlagInfo first = flagsSorted.get(0);
        SeeFlagInfo second = flagsSorted.get(1);

        Vector2D unitVector = new Vector2D(0,1);

        //get vectors to flags from agent location
        Vector2D toFirst = fromAngleDist(first.getDistance(), first.getDirection());
        Vector2D toSecond = fromAngleDist(second.getDistance(), second.getDirection());

        //get pitch Y axis relative to agent
        Vector2D axis = getAxisVector(first, second, toFirst, toSecond);

        //get angle to Y axis
        double unsignedAngle = Vector2D.angle(axis, unitVector);

        //account for angle being unsigned
        if(axis.getX() > 0){
            return ((2 * FastMath.PI) - unsignedAngle);
        }

        return unsignedAngle;
    }

    private Vector2D getAxisVector(SeeFlagInfo firstFlagInfo, SeeFlagInfo secondFlagInfo,
                                   Vector2D toFirstFlag, Vector2D toSecondFlag) {

        Vector2D firstFlagLocation = firstFlagInfo.getBoundryFlagLocation();
        Vector2D secondFlagLocation = secondFlagInfo.getBoundryFlagLocation();

        //only check first flag is on y axis (all flags should be on same axis here anyway)
        if(isLocatedOnYAxis(firstFlagInfo)){
            //subtract higher flag vector from lower to get y axis relative to agent
            if(isGreaterOnYAxis(firstFlagLocation, secondFlagLocation)){
                return toFirstFlag.subtract(toSecondFlag);
            }
            return toSecondFlag.subtract(toFirstFlag);
        }

        Vector2D xaxis = null;
        //if flags are not on y axis get x axis by subtracting greater x value vector.
        if(isGreaterOnXAxis(firstFlagLocation, secondFlagLocation)){
            xaxis = toFirstFlag.subtract(toSecondFlag);
        }
        else {
            xaxis = toSecondFlag.subtract(toFirstFlag);
        }
        //rotate x-axis by 90 degrees anti clockwise to get y axis.
        return new Vector2D(- xaxis.getY(), xaxis.getX());
    }

    private boolean isGreaterOnXAxis(Vector2D firstLoc, Vector2D secondLoc) {
        return firstLoc.getX() > secondLoc.getX();
    }

    private boolean isGreaterOnYAxis(Vector2D firstLoc, Vector2D secondLoc) {
        return firstLoc.getY() > secondLoc.getY();
    }

    private boolean isLocatedOnYAxis(SeeFlagInfo first) {
        return first.getSide() == SeeFlagInfo.FlagSide.LEFT || first.getSide() == SeeFlagInfo.FlagSide.RIGHT;
    }

    private List<SeeFlagInfo> sortFlagsByDistance(List<SeeFlagInfo> flags) {

        return flags.stream()
                .sorted((l,r) -> Double.compare(l.getDistance(), r.getDistance()))
                .collect(Collectors.toList());
    }

    private Vector2D fromAngleDist(double distance1, double angle1) {

        double x = distance1 * FastMath.sin(FastMath.toRadians(angle1));
        double y = distance1 * FastMath.cos(FastMath.toRadians(angle1));

        return new Vector2D(x,y);

    }

    private List<SeeFlagInfo> findNearest(Collection<List<SeeFlagInfo>> flagLists){
        List<SeeFlagInfo> nearest = null;

        double minDist = Double.MAX_VALUE;

        for(List<SeeFlagInfo> l : flagLists){
            for(SeeFlagInfo i : l){
                if(i.getDistance() < minDist){
                    nearest = l;
                }
            }
        }

        return nearest;
    }
}