import agent.Team;
import com.github.robocup_atan.atan.model.AbstractTeam;
import org.apache.log4j.BasicConfigurator;

/**
 * <h1>Intelligently Artificial FC - A Robocup Simulation League Team</h1>
 * <p>
 * IN3044 Coursework - Created by James Frost and Raghav Narula
 * <H2>The PEAS</H2>
 * <H5>Performance Measures</H5>
 * <H5>Environment</H5>
 * <H5>Actuators</H5>
 * <H5>Sensors</H5>
 *
 * <H5>System Architecture</H5>
 *
 * <p>
 * Our solution for this coursework is a model-reflex agent designed around the concept of a one-way data flow.
 * Our model is re-created at every simulation step. The process begins with the server sending our ControllerPlayer
 * information via the info* methods. Once all the information is gathered into A Percept, a new model object is created.
 * This model object is passed sequentially through a chain of "AI Components" that implement the IChainable Interface via
 * the AbstractSimpleAIComponent abstract class.
 * <p>
 * Each component is responsible for adding more information in to the model by using information contained in the percept.
 * This could be simple information such as the current play mode, or involved more complex calculations such as to determine
 * the agent's current location.
 * <p>
 * By the time the model has passed through all the components the model should contain enough information to determine
 * what set of actions need to be executed. Actions are executed in the final compoenet, the AgentAction component. Here
 * the state design pattern is used to organise the agent's behaviour.
 * <p>
 * The concept is illustrated in the diagram below.
 *
 * <img src="./doc-files/arch_functional.jpg" alt="">
 * <br>
 * <h2>Run Class Description</h2>
 * This class is the main entry point in to the Intelligently Artificial Robocup Simulation League Team.
 * This class is a copy from Simple1Run.java included in the original files.zip made available on Moodle.
 * There are minor changes which are noted as a comment in the main method.
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
