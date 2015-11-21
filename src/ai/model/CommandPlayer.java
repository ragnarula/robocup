package ai.model;

import com.github.robocup_atan.atan.model.ActionsPlayer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.ArrayList;
import java.util.List;

/**
 * This object forms a proxy to the ATAN ActoinsPLayer .
 * It is used to store and retrieve the commands sent to the server during each simulation step.
 * The commands since the previous step are then added in to the model to be used to estimate
 * agent position in case enough flags are not visible.
 */
public class CommandPlayer {
    private ActionsPlayer player;

    private List<Command> queue = new ArrayList<>();

    public CommandPlayer(ActionsPlayer player) {
        this.player = player;
    }

    public synchronized void dash(int power){
        player.dash(power);
        queue.add(new Command(Command.Type.DASH, power));
    }

    public synchronized void turn(double angle){
        double degrees = getTurnAngle(angle);
        player.turn(degrees);
        queue.add(new Command(Command.Type.TURN, degrees));
    }

    public synchronized void move(int x, int y){
        player.move(x,y);
//        queue.add(new Command(Command.Type.MOVE, new Vector2D(-y,x)));
        queue.add(new Command(Command.Type.MOVE, new Vector2D(x,y)));
    }

    public synchronized void kick(int power, double angle) {

        player.kick(power,FastMath.toDegrees(angle));
        queue.add(new Command(Command.Type.KICK, power));
    }


    /**
     * Returns a copy of the commands sent to the server since the previous call to this method.
     * Calling this method will return the current history and initialise a new list of commands.
     * @return List of Commands.
     */
    public synchronized List<Command> getAndClearHistory(){
        List<Command> copy = queue;
        queue = new ArrayList<Command>();
        return copy;
    }

    /**
     * Converts radians to degrees as well as normalising angles to be between -90 and +90 degrees
     * @param radians The angle in radians that the agent should turn to.
     * @return the normalised angle in degrees.
     */
    private double getTurnAngle(double radians){
        double angleDegrees = FastMath.toDegrees(radians);
        if(angleDegrees > 180){
            angleDegrees = angleDegrees - 360;
        }
        if(angleDegrees < 90 && angleDegrees > -90){
            return angleDegrees;
        }
        if(angleDegrees > 90){
            return 90;
        }
        return -90;
    }

    public ActionsPlayer getPlayer(){
        return player;
    }
}
