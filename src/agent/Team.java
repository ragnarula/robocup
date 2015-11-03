package agent;

import com.github.robocup_atan.atan.model.AbstractTeam;
import com.github.robocup_atan.atan.model.ControllerCoach;
import com.github.robocup_atan.atan.model.ControllerPlayer;

import java.util.Properties;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class Team extends AbstractTeam {
    public Team(String teamName, int port, String hostname, boolean hasCoach) {
        super(teamName, port, hostname, hasCoach);
    }

    @Override
    public ControllerPlayer getNewControllerPlayer(int i) {
        return new Player();
    }

    @Override
    public ControllerCoach getNewControllerCoach() {
        return new Coach();
    }
}
