package ai;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.Flag;
import info.Percept;
import info.SeeFlagInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class AgentLocationAIComponentTest {

    @Test
    public void shouldGiveLocationAtCenterWithCenterFlag() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.CENTER,
                39, // distance
                -90.0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(0,0)));
    }

    private boolean almostEqual(Vector2D agentLoc, Vector2D test) {
        return Math.abs(agentLoc.getX() - test.getX()) <= 0.1 &&
                Math.abs(agentLoc.getY() - test.getY()) <= 0.1;
    }

    @Test
    public void shouldGiveLocationAtCenterFacingLeft() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.CENTER,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                -90, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(0,0)));
    }

    @Test
    public void shouldGiveLocationAtCenterFacingRight() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.CENTER,
                39, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                90, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(0,0)));
    }

    @Test
    public void shouldGiveLocationAtCenterFacingForward() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.CENTER,
                57.5, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(0,0)));
    }

    @Test
    public void shouldGiveLocationAtNegativeYCenter() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.CENTER,
                77.5, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(0,-20)));
    }

    @Test
    public void shouldGiveLocationAtPositiveYCenter() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.CENTER,
                37.5, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(0,20)));
    }

    @Test
    public void shouldGiveLocationAtNegativeXCenter() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.LEFT_20,
                57.5, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(-20,0)));
    }

    @Test
    public void shouldGiveLocationAtPositiveXCenter() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.RIGHT_20,
                57.5, // distance
                0, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(20,0)));
    }

    @Test
    public void shouldworkforsomeplace() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenFlagInfo(new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_30,
                49.40648, // distance
                -35.9, // direction
                0, //distChange
                0, //dirChange
                0, //bodyFacing
                0)); //headFacing

        percepts.add(p);

        EnvironmentModel model = new EnvironmentModel(percepts);
        //when
        EnvironmentModel result = component.processModel(model);

        //then
        Vector2D agentLoc = result.getAgentLocation();
        System.out.println(agentLoc.toString());
        Assert.assertTrue(almostEqual(agentLoc, new Vector2D(-10,-10)));
    }


}