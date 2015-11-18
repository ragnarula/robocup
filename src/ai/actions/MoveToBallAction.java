package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 12/11/2015.
 */
public class MoveToBallAction implements Action {
    @Override
        public void takeAction(CommandPlayer player, EnvironmentModel model) {

//            if(model.getLastPercept().getLastSeenBall().getDistance() < 5 && model.getLastPercept().getLastSensedBody().getSpeedAmount() > 5 )
//                player.dash(60);
//            else
                player.dash(80);

            player.turn(model.getBallAngle() - model.getAgentAbsAngleRadians());

        }
}
