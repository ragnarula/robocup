package ai;

import ai.model.EnvironmentModel;
import ai.model.HomeArea;

import java.util.HashMap;
import java.util.Map;

/**
 * This component assigns a home area to each agent based on their
 * player number.
 *
 * Areas are represented as a pair of vectors denoting the top left and
 * bottom right of a bounding box.
 *
 * Created by raghavnarula on 05/11/2015.
 */
public class HomeAreaAIComponent extends AbstractSimpleAIComponent {

    private Map<Integer, HomeArea> HOME_AREAS = new HashMap<>();

    public HomeAreaAIComponent() {

        HOME_AREAS.put(0, new HomeArea(-10.0, -30.0, 10.0, -50));
        HOME_AREAS.put(1, new HomeArea(-20.0, 40.0, 0.0, 20.0));
        HOME_AREAS.put(2, new HomeArea(-20.0, 20.0, 0.0, 0.0));
        HOME_AREAS.put(3, new HomeArea(0.0, 20.0, 20.0, 0.0));
        HOME_AREAS.put(4, new HomeArea(-20.0, 0.0, 0.0, -20.0));
        HOME_AREAS.put(5, new HomeArea(0.0, 0.0, 20.0, -20.0));
        HOME_AREAS.put(6, new HomeArea(-34.0, -20.0, -20.0, -40.0));
        HOME_AREAS.put(7, new HomeArea(-20.0, -20.0, 0.0, -40.0));
        HOME_AREAS.put(8, new HomeArea(0.0, -20.0, 20.0, -40.0));
        HOME_AREAS.put(9, new HomeArea(20.0, -20.0, 34.0, -40.0));
//        tmp: doubling up
        HOME_AREAS.put(10,new HomeArea(0.0, 40.0, 20.0, 20.0));
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        int id = model.getPercepts().get(0).getPlayerId();

        model.setHomeArea(HOME_AREAS.get(id));

        return model;
    }
}
