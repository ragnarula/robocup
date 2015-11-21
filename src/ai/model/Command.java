package ai.model;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * This class is a value type to represent commands which have been send to the server.
 * The comand paramenets are stored as type Object with an enum to indicate the actual type stored.
 * This is so that these commands can be stored in a homogeneous list.
 *
 * Getters are provided which cast the Object to the correct type. It is the user's responsibility
 * to check the various 'is*' methods to figure out which is the appropriate getter to use.
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
