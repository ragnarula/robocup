package ai.model;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Movement Area Tests
 */
public class MovementAreaTest {
    @Test
    public void testContains() throws Exception {
        MovementArea movementArea = new MovementArea(new Vector2D(-10, 10), new Vector2D(10, -10));
        assertTrue(movementArea.contains(new Vector2D(0, 0)));
        assertTrue(movementArea.contains(new Vector2D(5, 5)));
        assertTrue(movementArea.contains(new Vector2D(-5, -5)));
        assertTrue(movementArea.contains(new Vector2D(9, 9)));
        assertTrue(movementArea.contains(new Vector2D(-9, 9)));
        assertTrue(movementArea.contains(new Vector2D(9, -9)));

        assertFalse(movementArea.contains(new Vector2D(11, 11)));
        assertFalse(movementArea.contains(new Vector2D(-11, 5)));
    }

    @Test
    public void testExtendsToGoal() throws Exception {
        MovementArea movementArea = new MovementArea(new Vector2D(-10, 10), new Vector2D(10, -10));
        assertFalse(movementArea.extendsToGoal());

        movementArea = new MovementArea(-34.0, 52.5, 20.0, 0.0);
        assertTrue(movementArea.extendsToGoal());
    }
}
