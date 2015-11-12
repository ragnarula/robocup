package ai;

import ai.model.EnvironmentModel;
import info.SeePlayerInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.HashMap;
import java.util.List;

/**
 * Created by James on 12/11/2015.
 */
public class OppositionLocationAIComponent extends AbstractSimpleAIComponent {
    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        List<SeePlayerInfo> seePlayerInfoArrayList = model.getLastPercept().getSeenPlayers();

        HashMap<Integer, SeePlayerInfo> opposingPlayers = getOpposingPlayers(seePlayerInfoArrayList);
        HashMap<Integer, Vector2D> opposingPlayersLocations = new HashMap<>();

        for(SeePlayerInfo p : seePlayerInfoArrayList) {
            opposingPlayersLocations.put(p.getNumber(), getOpposingPlayerLocation(p, model));
        }

        model.setOpposingPlayerLocations(opposingPlayersLocations);

        return model;
    }

    private Vector2D getOpposingPlayerLocation(SeePlayerInfo p, EnvironmentModel model) {

        double agentAngle = model.getAgentAbsAngleRadians();
        double ballAngle = FastMath.toRadians(p.getDirection());

        double x = (FastMath.sin(agentAngle + ballAngle) * p.getDistance());
        double y = (FastMath.cos(agentAngle + ballAngle) * p.getDistance());

        Vector2D agentToPlayer = new Vector2D(x,y);
        Vector2D agentLocation = model.getAgentLocation();

        return agentLocation.add(agentToPlayer);
    }

    private HashMap<Integer, SeePlayerInfo> getOpposingPlayers(List<SeePlayerInfo> seePlayerInfoArrayList) {

        HashMap<Integer, SeePlayerInfo> opposingPlayers = new HashMap<>();

        for(SeePlayerInfo p : seePlayerInfoArrayList)   {
            if(p.getTeam() == SeePlayerInfo.PlayerTeam.OTHER )
                opposingPlayers.put(p.getNumber(), p);
        }

        return opposingPlayers;
    }


}
