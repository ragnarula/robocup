import agent.Team;
import com.github.robocup_atan.atan.model.AbstractTeam;
import org.apache.log4j.BasicConfigurator;

/**
 * This class is the main entry point in to the Intelligently Artificial Robocup Simulation League Team.
 * This class is a copy from Simple1Run.java included in the original files.zip made available on Moodle.
 * There are minor changes which are noted as a comment in the main method.
 * <p>
 * See docs/index.html for answers to coursework questions and system docs.
 * <br>
 * If you have re-generated the javadoc, be sure to include overview.html by using the "-overview overview.html" option.
 * It is this file that contains the specific comments for coursework requirements (PEAS, Environment Properties etc).
 */
public class Run {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        AbstractTeam team = null;
        if (args.length == 0) {
            //using our agent.Team
            team = new Team("IAF2", 6000, "localhost", true);
        } else {
            Integer val      = new Integer(args[0]);
            int     port     = val.intValue();
            String  hostname = args[1];
            //added team name parameter
            String  teamname = args[2];
            team = new Team(teamname, port, hostname, true);
        }
        team.connectAll();
    }
}
