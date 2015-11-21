package ai;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.Flag;
import info.Percept;
import info.SeeFlagInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * AgentLocationAIComponent tests
 */
public class AgentLocationAIComponentTest {

    private EnvironmentModel getModelFromFlags(List<SeeFlagInfo> flags, double angle){
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        flags.forEach(p::addSeenFlagInfo);
        percepts.add(p);
        EnvironmentModel m = new EnvironmentModel(percepts, new ArrayList<>());
        m.setAgentAbsAngleRadians(angle);
        m.setHasAgentAbsAngle();
        return m;
    }

    @Test
    public void testLeftOther40LeftOther50() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_40,
                16.1284,
                -19,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_50,
                20.73314,
                10,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags, FastMath.toRadians(301)));
        Vector2D location = model.getAgentLocation();
        //then
        assertThat("Model contains correct X location", location.getX(), is(closeTo(-23.3,0.5)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(36.5,0.5)));
    }

    @Test
    public void testOtherRight10OtherRight20() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.RIGHT_10,
                18.4,
                -27,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OTHER,
                Flag.RIGHT_20,
                19.8,
                3,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags, FastMath.toRadians(19)));
        Vector2D location = model.getAgentLocation();

        //then
        assertThat("Model contains correct X location", location.getX(), is(closeTo(12.3,0.5)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(39.2,0.5)));
    }


    @Test
    public void testOwnRight10OwnRight20() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.RIGHT_10,
                25,
                -5,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.RIGHT_20,
                22.3,
                -28,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags, FastMath.toRadians(212)));
        Vector2D location = model.getAgentLocation();

        //then
        assertThat("Model contains correct X location", location.getX(), is(closeTo(21.6,0.5)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(-35.2,0.5)));
    }

    @Test
    public void testLeftOwn10LeftOwn20() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OWN_10,
                20.1,
                -9,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OWN_20,
                17.6,
                -39,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags, FastMath.toRadians(308)));
        Vector2D location = model.getAgentLocation();

        //then
        assertThat("Model contains correct X location", location.getX(), is(closeTo(-21.4,0.5)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(-19.8,0.5)));
    }
    @Test
    public void testRightOther10RightOther20Far() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_10,
                50.098448,
                5,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_20,
                51.84813,
                -6,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags, FastMath.toRadians(86)));
        Vector2D location = model.getAgentLocation();

        //then
        assertThat("Model contains correct X location", location.getX(), is(closeTo(-12,1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(10.6,1)));
    }

    @Test
    public void testRightCenterRightOwn10() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.CENTER,
                15.8,
                13,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OWN_10,
                13.6,
                52,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags, FastMath.toRadians(45)));
        Vector2D location = model.getAgentLocation();

        //then
        assertThat("Model contains correct X location", location.getX(), is(closeTo(25.5,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(-8.3,0.1)));
    }
    @Test
    public void testOwnCenterOwnLeft10() throws Exception {
        //given
        AgentLocationAIComponent component = new AgentLocationAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.CENTER,
                18.4,
                22,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.OWN,
                Flag.LEFT_10,
                15.3,
                55,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);


        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags, FastMath.toRadians(124)));
        Vector2D location = model.getAgentLocation();

        //then
        assertThat("Model contains correct X location", location.getX(), is(closeTo(-10.2,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(-42.2,0.1)));
    }

}