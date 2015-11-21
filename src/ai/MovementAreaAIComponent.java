package ai;

import ai.model.EnvironmentModel;
import ai.model.MovementArea;

import java.util.HashMap;
import java.util.Map;

/**
 * This component assigns the agent a movement area, which is the area that the agent
 * is permitted to move to when not in PassiveState.
 *
 * Areas are stored as pairs of vectors, representing the top left and bottom right corners
 * of a bounding box.
 *
 * Created by James on 10/11/2015.
 */
public class MovementAreaAIComponent extends AbstractSimpleAIComponent {
    private Map<Integer, MovementArea> MOVEMENT_AREAS = new HashMap<>();

    public MovementAreaAIComponent() {

        MOVEMENT_AREAS.put(0, new MovementArea(-20.0, -20.0, 20.0, -53.5));
        MOVEMENT_AREAS.put(1, new MovementArea(-35.0, 53.5, 20.0, 0.0));
        MOVEMENT_AREAS.put(2, new MovementArea(-35.0, 53.5, 20.0, 0));
        MOVEMENT_AREAS.put(3, new MovementArea(-20.0, 53.5, 35.0, -5));
        MOVEMENT_AREAS.put(4, new MovementArea(-35, 5, 20.0, -53.5));
        MOVEMENT_AREAS.put(5, new MovementArea(-20, 0, 20.0, -53.5));
        MOVEMENT_AREAS.put(6, new MovementArea(-35, 0, 20, -53.5));
        MOVEMENT_AREAS.put(7, new MovementArea(-35, 0, 20.0, -53.5));
        MOVEMENT_AREAS.put(8, new MovementArea(-20, 0, 20.0, -53.5));
        MOVEMENT_AREAS.put(9, new MovementArea(-20.0, 0, 34.0, -53.5));
//        tmp: doubling up
        MOVEMENT_AREAS.put(10, new MovementArea(-20.0, 53.5, 35.0, 0.0));
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        int id = model.getPercepts().get(0).getPlayerId();

        model.setMovementArea(MOVEMENT_AREAS.get(id));

        return model;
    }
}
