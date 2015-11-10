package ai;

import ai.model.EnvironmentModel;
import info.Percept;
import info.SeeBallInfo;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Created by James on 10/11/2015.
 */
public class BallLocationAIComponentTest {

    private EnvironmentModel getModel(SeeBallInfo seeBallInfo, Vector2D agentLocation){
        List<Percept> percepts = new ArrayList<>();
        Percept p = new Percept(0,0);
        p.addSeenBallInfo(seeBallInfo);
        percepts.add(p);
        EnvironmentModel model = new EnvironmentModel(percepts);
        model.setAgentLocation(agentLocation);
        return model;
    }

    @Test
    public void testBallCenterPlayer10Behind() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(10.0,
                0,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(0, -10)));
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(0,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(0,0.1)));
    }


    @Test
    public void testBallCenterPlayer10Ahead() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(10.0,
                180,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(0, 10)));
        model.setAgentAbsAngleRadians(180);
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(0,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(0,0.1)));
    }

    @Test
    public void testBallCenterPlayer10Left() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(10.0,
                90,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(-10, 0)));
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(0,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(0,0.1)));
    }

    @Test
    public void testBallCenterPlayer10Right() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(10.0,
                -90,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(10, 0)));
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(0,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(0,0.1)));
    }

    @Test
    public void testBall10LeftPlayer10Right() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(20.0,
                -90,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(10, 0)));
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(-10,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(0,0.1)));
    }

    @Test
    public void testBall10AheadPlayer10Behind() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(20.0,
                0,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(0, -10)));
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(0,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(10,0.1)));
    }

    @Test
    public void testBall10Ahead10LeftPlayer10Behind10Right() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(28.2,
                -45,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(10, -10)));
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(-10,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(10,0.1)));
    }

    @Test
    public void testBall10Ahead10RightPlayer10Behind10Right() throws Exception {
        BallLocationAIComponent ballLocationAIComponent = new BallLocationAIComponent();

        SeeBallInfo ball = new SeeBallInfo(20,
                0,
                0,
                0,
                0,
                0);

        EnvironmentModel model = ballLocationAIComponent.processModel(getModel(ball, new Vector2D(10, -10)));
        Vector2D location = model.getBallLocation();

        assertThat("Model contains correct X location", location.getX(), is(closeTo(10,0.1)));
        assertThat("Model contains correct Y location", location.getY(), is(closeTo(10,0.1)));
    }


}
