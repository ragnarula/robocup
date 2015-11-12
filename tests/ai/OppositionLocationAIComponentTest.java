package ai;

import ai.model.EnvironmentModel;
import info.Percept;
import info.SeePlayerInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Created by James on 12/11/2015.
 */
public class OppositionLocationAIComponentTest {

    private EnvironmentModel getModel(SeePlayerInfo seePlayerInfo, Vector2D agentLocation){
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenPlayerInfo(seePlayerInfo);
        percepts.add(p);
        EnvironmentModel model = new EnvironmentModel(percepts, new ArrayList<>());
        model.setAgentLocation(agentLocation);
        return model;
    }

    @Test
    public void testPlayerCenterOpposing10Ahead() throws Exception {
        OppositionLocationAIComponent oppositionLocationAIComponent = new OppositionLocationAIComponent();

        SeePlayerInfo seePlayerInfo = new SeePlayerInfo(SeePlayerInfo.PlayerTeam.OTHER,
                0,
                false,
                10,
                0,
                0,
                0,
                0,
                0
        );

        EnvironmentModel model = oppositionLocationAIComponent.processModel(getModel(seePlayerInfo, new Vector2D(0, 0)));
        Vector2D opposingPlayerLocation = model.getOpposingPlayerLocations().get(0);

        assertThat("Model contains correct X location", opposingPlayerLocation.getX(), is(closeTo(0,0.1)));
        assertThat("Model contains correct Y location", opposingPlayerLocation.getY(), is(closeTo(10,0.1)));
    }

    @Test
    public void testPlayerCenterOpposing10Ahead10Right() throws Exception {
        OppositionLocationAIComponent oppositionLocationAIComponent = new OppositionLocationAIComponent();

        SeePlayerInfo seePlayerInfo = new SeePlayerInfo(SeePlayerInfo.PlayerTeam.OTHER,
                0,
                false,
                14.1,
                45,
                0,
                0,
                0,
                0
        );

        EnvironmentModel model = oppositionLocationAIComponent.processModel(getModel(seePlayerInfo, new Vector2D(0, 0)));
        Vector2D opposingPlayerLocation = model.getOpposingPlayerLocations().get(0);

        assertThat("Model contains correct X location", opposingPlayerLocation.getX(), is(closeTo(10,0.1)));
        assertThat("Model contains correct Y location", opposingPlayerLocation.getY(), is(closeTo(10,0.1)));
    }

    @Test
    public void testPlayer10BehindOpposing10Ahead20Right() throws Exception {
        OppositionLocationAIComponent oppositionLocationAIComponent = new OppositionLocationAIComponent();

        SeePlayerInfo seePlayerInfo = new SeePlayerInfo(SeePlayerInfo.PlayerTeam.OTHER,
                0,
                false,
                14.1,
                45,
                0,
                0,
                0,
                0
        );

        EnvironmentModel model = oppositionLocationAIComponent.processModel(getModel(seePlayerInfo, new Vector2D(0, -10)));
        Vector2D opposingPlayerLocation = model.getOpposingPlayerLocations().get(0);

        assertThat("Model contains correct X location", opposingPlayerLocation.getX(), is(closeTo(10,0.1)));
        assertThat("Model contains correct Y location", opposingPlayerLocation.getY(), is(closeTo(10,0.1)));
    }
}
