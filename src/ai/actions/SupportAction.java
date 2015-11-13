package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashMap;

/**
 * Created by James on 06/11/2015.
 */
public class SupportAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
        HashMap<Integer, Vector2D> opposingPlayerLocations =  model.getOpposingPlayerLocations();
    }
}
