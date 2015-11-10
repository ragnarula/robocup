package ai;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.Flag;
import info.Percept;
import info.SeeFlagInfo;
import org.apache.commons.math3.util.FastMath;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Created by raghavnarula on 06/11/2015.
 */
public class AgentAngleAIComponentTest {

    private EnvironmentModel getModelFromFlags(List<SeeFlagInfo> flags){
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        flags.forEach(p::addSeenFlagInfo);
        percepts.add(p);
        return new EnvironmentModel(percepts);
    }

    @Test
    public void testAngleForFlagsLeftOther40LeftOther50() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_40,
                16.1,
                -19,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.LEFT,
                Flag.OTHER_50,
                20.7,
                10,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(301),0.1)));
    }

    @Test
    public void testAngleForFlagsOtherRight10OtherRight20() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
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
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(19),0.1)));
    }

    @Test
    public void testRightOther10RightOther20() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
        List<SeeFlagInfo> flags = new ArrayList<>();
        SeeFlagInfo flag1 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_10,
                23.4,
                -13,
                0,0,0,0);
        SeeFlagInfo flag2 = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY,
                SeeFlagInfo.FlagSide.RIGHT,
                Flag.OTHER_20,
                20.0,
                -39,
                0,0,0,0);
        flags.add(flag1);
        flags.add(flag2);

        //when
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(135),0.1)));
    }

    @Test
    public void testOwnCenterOwnLeft10() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
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
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(124),0.1)));
    }

    @Test
    public void testOwnRight10OwnRight20() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
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
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(212),0.1)));
    }
    @Test
    public void testLeftOwn10LeftOwn20() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
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
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(308),0.1)));
    }

    @Test
    public void testRightOther10RightOther20Far() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
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
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(86),0.1)));
    }

    @Test
    public void testRightCenterRightOwn10() throws Exception {
        //given
        AgentAngleAIComponent component = new AgentAngleAIComponent();
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
        EnvironmentModel model = component.processModel(getModelFromFlags(flags));
        double angle = model.getAgentAbsAngleRadians();
        //then
        assertThat("Model contains correct angle", angle, is(closeTo(FastMath.toRadians(45),0.1)));
    }
}