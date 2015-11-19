import agent.Team;
import com.github.robocup_atan.atan.model.AbstractTeam;
import org.apache.log4j.BasicConfigurator;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class Run {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        AbstractTeam team = null;
        if (args.length == 0) {
            team = new Team("IAFC", 6000, "localhost", true);
        } else {
            Integer val      = new Integer(args[0]);
            int     port     = val.intValue();
            String  hostname = args[1];
            team = new Team("IAFC", port, hostname, true);
        }
        team.connectAll();
    }
}
