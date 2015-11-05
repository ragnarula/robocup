package ai;

import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class HomeAreaAIComponent extends AbstractSimpleAIComponent {

    private Map<Integer, Pair<Vector2D, Vector2D>> HOME_AREAS = new HashMap<>();

    public HomeAreaAIComponent() {
        buildPair(0, -20.0, 40.0, 0.0, 20.0);
        buildPair(1, 0.0, 40.0, 20.0, 20.0);
        buildPair(2, -20.0, 20.0, 0.0, 0.0);
        buildPair(3, 0.0, 20.0, 20.0, 0.0);
        buildPair(4, -20.0, 0.0, 0.0, -20.0);
        buildPair(5, 0.0, 0.0, 20.0, -20.0);
        buildPair(6,-34.0, -20.0, -20.0, -40.0 );
        buildPair(7, -20.0, -20.0, 0.0, -40.0);
        buildPair(8, 0.0, -20.0, 20.0, -40.0);
        buildPair(9, 20.0, -20.0, 34.0, -40.0);
    }

    private void buildPair(int id, double x1, double y1, double x2, double y2) {
        HOME_AREAS.put(id, new Pair<Vector2D, Vector2D>(new Vector2D(x1, y1), new Vector2D(x2, y2)));
    }

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        int id = model.getPercepts().get(0).getPlayerId();

        model.setHomeArea(HOME_AREAS.get(id));

        return model;
    }
}
