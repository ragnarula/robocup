package ai;

import ai.model.EnvironmentModel;
import info.SeeFlagInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by raghavnarula on 06/11/2015.
 */
public class AgentAngleAIComponent extends AbstractSimpleAIComponent {
    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        List<SeeFlagInfo> seenFlags = model.getLastPercept().getSeenFlags();

        //get only boundry flags
        List<SeeFlagInfo> boundryFlags = seenFlags.stream()
                .filter(SeeFlagInfo::isBoundryFlag)
                .collect(Collectors.toList());

        //group by the side the flags are on
        Map<SeeFlagInfo.FlagSide, List<SeeFlagInfo>> flagSides = boundryFlags.stream()
                .collect(
                        Collectors.groupingBy(SeeFlagInfo::getSide)
                );

        //filter to sides with have 2 or more flags
        Map<SeeFlagInfo.FlagSide, List<SeeFlagInfo>> flagSidesAboveTwo = flagSides.entrySet()
                .stream()
                .filter(e -> e.getValue().size() >= 2)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        //if there are no such sides, return without finding angle
        if(flagSidesAboveTwo.isEmpty()){
            return model;
        }

        //find the list with the nearest flag
        List<SeeFlagInfo> nearestFlags = findNearest(flagSidesAboveTwo.values());

        double agentAngleRadians = getAgentAngleFromFlags(nearestFlags);
        model.setAgentAbsAngleRadians(agentAngleRadians);

        return model;
    }

    private double getAgentAngleFromFlags(List<SeeFlagInfo> nearestFlags) {
        List<SeeFlagInfo> flagsSorted = nearestFlags.stream()
                .sorted((l,r) -> Double.compare(l.getDistance(), r.getDistance()))
                .collect(Collectors.toList());

        Vector2D unitVector = getUnitVectorFor(flagsSorted.get(0).getSide());
        SeeFlagInfo first = flagsSorted.get(0);
        SeeFlagInfo second = flagsSorted.get(1);

        Vector2D toFirst = fromAngleDist(first.getDistance(), first.getDirection());
        Vector2D toSecond = fromAngleDist(second.getDistance(), second.getDirection());

        Vector2D axis = toFirst.subtract(toSecond);

        double angle = Vector2D.angle(axis, unitVector);
        return angle;
    }

    private Vector2D getUnitVectorFor(SeeFlagInfo.FlagSide side) {
        if(side == SeeFlagInfo.FlagSide.LEFT || side == SeeFlagInfo.FlagSide.RIGHT){
            return new Vector2D(0,1);
        }
        //assuming only boundry flags, so either left right own or other
        return new Vector2D(1,0);
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
