package ai.model;

import com.github.robocup_atan.atan.model.ActionsPlayer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by raghavnarula on 10/11/2015.
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
        queue.add(new Command(Command.Type.MOVE, new Vector2D(-y,x)));
    }

    public synchronized void kick(int power, double angle) {
        player.kick(power,angle);
        queue.add(new Command(Command.Type.KICK, power));
    }

    public synchronized List<Command> getAndClearHistory(){
        List<Command> copy = queue;
        queue = new ArrayList<Command>();
        return copy;
    }

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
