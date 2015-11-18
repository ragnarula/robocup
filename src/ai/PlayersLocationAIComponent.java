package ai;

import ai.model.EnvironmentModel;
import info.SeePlayerInfo;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.HashMap;
import java.util.List;

/**
 * Created by James on 12/11/2015.
 */
public class PlayersLocationAIComponent extends AbstractSimpleAIComponent {
    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        List<SeePlayerInfo> seePlayerInfoArrayList = model.getLastPercept().getSeenPlayers();

        HashMap<Integer, SeePlayerInfo> opposingPlayers = getPlayersOfTeam(seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam.OTHER);
        HashMap<Integer, Vector2D> opposingPlayersLocations = infoToVector(opposingPlayers,model.getAgentAbsAngleRadians(),model.getAgentLocation());

        model.setOpposingPlayerLocations(opposingPlayersLocations);

        HashMap<Integer, SeePlayerInfo> friendlyPlayers = getPlayersOfTeam(seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam.OWN);
        HashMap<Integer, Vector2D> friendlyPlayersLocations = infoToVector(friendlyPlayers,model.getAgentAbsAngleRadians(),model.getAgentLocation());

        model.setFriendlyPlayerLocations(friendlyPlayersLocations);

        return model;
    }


    private HashMap<Integer, Vector2D> infoToVector(HashMap<Integer, SeePlayerInfo> players, double agentAngle, Vector2D agentLocation){
        HashMap<Integer, Vector2D> locations = new HashMap<>();
        for(Integer key : players.keySet() ) {
            SeePlayerInfo thisPlayer = players.get(key);
            double absAngle = agentAngle + FastMath.toRadians(thisPlayer.getDirection());
            Vector2D loc = EnvironmentModel.getLocationFromRelativeInfo(agentLocation,absAngle,thisPlayer.getDistance());
            locations.put(key, loc);
        }
        return locations;
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
