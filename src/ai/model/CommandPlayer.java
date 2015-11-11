package ai.model;

import com.github.robocup_atan.atan.model.ActionsPlayer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by raghavnarula on 10/11/2015.
 */
public class CommandPlayer {
    private ActionsPlayer player;

    private List<Command> history = new ArrayList<Command>();

    public CommandPlayer(ActionsPlayer player) {
        this.player = player;
    }

    public synchronized void dash(int power){
        player.dash(power);
        history.add(new Command(Command.Type.DASH, power));
    }

    public synchronized void turn(double angle){
        player.turn(angle);
        history.add(new Command(Command.Type.TURN, angle));
    }

    public synchronized void move(int x, int y){
        player.move(x,y);
        history.add(new Command(Command.Type.MOVE, new Vector2D(-y,x)));
    }

    public synchronized List<Command> getAndClearHistory(){
        List<Command> copy = history;
        history = new ArrayList<Command>();
        return copy;
    }
}
