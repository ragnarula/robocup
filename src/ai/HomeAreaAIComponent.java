package ai;

import ai.model.EnvironmentModel;
import ai.model.HomeArea;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class HomeAreaAIComponent extends AbstractSimpleAIComponent {

    private Map<Integer, HomeArea> HOME_AREAS = new HashMap<>();

    public HomeAreaAIComponent() {

        HOME_AREAS.put(0, new HomeArea(-20.0, 40.0, 0.0, 20.0));
        HOME_AREAS.put(0, new HomeArea(0.0, 40.0, 20.0, 20.0));
        HOME_AREAS.put(2, new HomeArea(-20.0, 20.0, 0.0, 0.0));
        HOME_AREAS.put(3, new HomeArea(0.0, 20.0, 20.0, 0.0));
        HOME_AREAS.put(4, new HomeArea(-20.0, 0.0, 0.0, -20.0));
        HOME_AREAS.put(5, new HomeArea(0.0, 0.0, 20.0, -20.0));
        HOME_AREAS.put(6, new HomeArea(-34.0, -20.0, -20.0, -40.0));
        HOME_AREAS.put(7, new HomeArea(-20.0, -20.0, 0.0, -40.0));
        HOME_AREAS.put(8, new HomeArea(0.0, -20.0, 20.0, -40.0));
        HOME_AREAS.put(9, new HomeArea(20.0, -20.0, 34.0, -40.0));
    }

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        int id = model.getPercepts().get(0).getPlayerId();

        model.setHomeArea(HOME_AREAS.get(id));

        return model;
    }
}
