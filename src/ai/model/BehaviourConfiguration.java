package ai.model;

/**
 * Defines the constant values that are used to configure the behaviour of the agents.
 *
 * @see BehaviourConfiguration#BALL_POSSESSION_RANGE is the range at which a player is said to posess the ball.
 * @see BehaviourConfiguration#PLAYER_SPEED_DECAY the decay rate of an agent as it approaches a ball.
 * @see BehaviourConfiguration#TEAM_POSSESSION_RANGE the range at which the team is said to posess the ball.
 */
public abstract class BehaviourConfiguration {

    public static final double TEAM_POSSESSION_RANGE = 1.5;
    public static final double BALL_POSSESSION_RANGE = 0.5;
    public static final double PLAYER_SPEED_DECAY = 0.4;

}
