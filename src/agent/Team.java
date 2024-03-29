package agent;

import com.github.robocup_atan.atan.model.AbstractTeam;
import com.github.robocup_atan.atan.model.ControllerCoach;
import com.github.robocup_atan.atan.model.ControllerPlayer;

/**
 * This class is copied from SimpleSillyTeam with minor modifications.
 */
public class Team extends AbstractTeam {
    public Team(String teamName, int port, String hostname, boolean hasCoach) {
        super(teamName, port, hostname, hasCoach);
    }

    @Override
    public ControllerPlayer getNewControllerPlayer(int i) {
        return new Player(i);
    }

    @Override
    public ControllerCoach getNewControllerCoach() {
        return new Coach();
    }
}
