import agent.Team;
import com.github.robocup_atan.atan.model.AbstractTeam;
import org.apache.log4j.BasicConfigurator;

/**
 * Main entry point in to the Intelligently Artificial Robocup Simulation League Team.
 * This class is a copy from Simple1Run.java included in the original files.zip made available on Moodle.
 * There are minor changes which are noted as a comment in the main method.
 *
 * For answers to additional coursework questions (PEAS etc) please see package-info.java in the root package.
 *
 */
public class Run {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        AbstractTeam team = null;
        if (args.length == 0) {
            team = new Team("IAFC", 6000, "localhost", true);
            //using our agent.Team
            team = new Team("IAFC", 6000, "localhost", true);
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
