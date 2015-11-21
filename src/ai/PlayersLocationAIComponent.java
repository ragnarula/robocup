package ai;

import ai.model.EnvironmentModel;
import info.SeePlayerInfo;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.HashMap;
import java.util.List;

/**
 * This component adds the locations of friendly and opposing players in to the
 * model from whatever playerInfo objects are available in the latest percept.
 *
 * Player locations are stored as vectors indexed by player numbers.
 *
 * Created by James on 12/11/2015.
 */
public class PlayersLocationAIComponent extends AbstractSimpleAIComponent {
    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        List<SeePlayerInfo> seePlayerInfoArrayList = model.getLastPercept().getSeenPlayers();

        //get map of other team players
        HashMap<Integer, SeePlayerInfo> opposingPlayers = getPlayersOfTeam(seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam.OTHER);
        //convert to location vectors
        HashMap<Integer, Vector2D> opposingPlayersLocations = infoToVector(opposingPlayers,model.getAgentAbsAngleRadians(),model.getAgentLocation());
        //add to model
        model.setOpposingPlayerLocations(opposingPlayersLocations);
        //get friendly players
        HashMap<Integer, SeePlayerInfo> friendlyPlayers = getPlayersOfTeam(seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam.OWN);
        //convert to vector
        HashMap<Integer, Vector2D> friendlyPlayersLocations = infoToVector(friendlyPlayers,model.getAgentAbsAngleRadians(),model.getAgentLocation());
        //add to model
        model.setFriendlyPlayerLocations(friendlyPlayersLocations);

        return model;
    }


    /**
     * Convert map of playerInfo to map of location vector.
     * @param players The map of player info
     * @param agentAngle The agent's absolute angle relative to pitch.
     * @param agentLocation The agent's location from which to infer other player's locations.
     * @return Map of location vectors.
     */
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

    /**
     * Filter players for a team, return in a map.
     * @param seePlayerInfoArrayList The list of players
     * @param playerTeam The team to filter for.
     * @return Map of players matching filter.
     */
    private HashMap<Integer, SeePlayerInfo> getPlayersOfTeam(List<SeePlayerInfo> seePlayerInfoArrayList, SeePlayerInfo.PlayerTeam playerTeam) {

        HashMap<Integer, SeePlayerInfo> opposingPlayers = new HashMap<>();

        for(SeePlayerInfo p : seePlayerInfoArrayList)   {
            if(p.getTeam() == playerTeam )
                opposingPlayers.put(p.getNumber(), p);
        }

        return opposingPlayers;
    }


}
