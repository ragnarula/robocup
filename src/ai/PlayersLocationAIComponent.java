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
public class PlayersLocationAIComponent extends AbstractSimpleAIComponent {
    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        List<SeePlayerInfo> seePlayerInfoArrayList = model.getLastPercept().getSeenPlayers();

        HashMap<Integer, SeePlayerInfo> opposingPlayers = getPlayersOfTeam(seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam.OTHER);
        HashMap<Integer, Vector2D> opposingPlayersLocations = new HashMap<>();

        for(Integer key : opposingPlayers.keySet() ) {
            SeePlayerInfo thisPlayer = opposingPlayers.get(key);
            opposingPlayersLocations.put(thisPlayer.getNumber(), getPlayerLocation(thisPlayer, model));
        }

        model.setOpposingPlayerLocations(opposingPlayersLocations);

        HashMap<Integer, SeePlayerInfo> friendlyPlayers = getPlayersOfTeam(seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam.OWN);
        HashMap<Integer, Vector2D> friendlyPlayersLocations = new HashMap<>();

        for(Integer key : friendlyPlayers.keySet() ) {
            SeePlayerInfo thisPlayer = friendlyPlayers.get(key);
            friendlyPlayersLocations.put(thisPlayer.getNumber(), getPlayerLocation(thisPlayer, model));
        }

        model.setFriendlyPlayerLocations(friendlyPlayersLocations);

        return model;
    }

    private Vector2D getPlayerLocation(SeePlayerInfo p, EnvironmentModel model) {

        double agentAngle = model.getAgentAbsAngleRadians();
        double ballAngle = FastMath.toRadians(p.getDirection());

        double x = (FastMath.sin(agentAngle + ballAngle) * p.getDistance());
        double y = (FastMath.cos(agentAngle + ballAngle) * p.getDistance());

        Vector2D agentToPlayer = new Vector2D(x,y);
        Vector2D agentLocation = model.getAgentLocation();

        return agentLocation.add(agentToPlayer);
    }

    private HashMap<Integer, SeePlayerInfo> getPlayersOfTeam(List<SeePlayerInfo> seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam playerTeam) {

        HashMap<Integer, SeePlayerInfo> opposingPlayers = new HashMap<>();

        for(SeePlayerInfo p : seePlayerInfoArrayList)   {
            if(p.getTeam() == playerTeam )
                opposingPlayers.put(p.getNumber(), p);
        }

        return opposingPlayers;
    }


}
