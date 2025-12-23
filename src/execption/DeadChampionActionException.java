package execption;

import character.Champion;

public class DeadChampionActionException extends BattleEndException {

    public DeadChampionActionException(String message, Champion winner, Champion loser) {
        super(message, winner, loser);
    }
}
