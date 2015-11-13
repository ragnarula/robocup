package ai.model;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by raghavnarula on 10/11/2015.
 */
public class Command {

    public enum Type {
        DASH,
        TURN,
        MOVE,
        KICK
    }

    private Type type;
    private Object value;

    public Command(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public double getDoubleValue(){
        return (double) value;
    }

    public int getIntValue(){
        return (int) value;
    }

    public Vector2D getVector2DValue(){
        return (Vector2D) value;
    }

    public boolean isMoveCommand(){
        return type == Type.MOVE;
    }

    public boolean isTurnCommand(){
        return type == Type.TURN;
    }

    public boolean isDashCommand(){
        return type == Type.DASH;
    }
}
