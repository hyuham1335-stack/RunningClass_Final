package execption;

import character.Champion;

public class ManaActionException extends BattleEndException {

    public ManaActionException(String message, Champion winner, Champion loser) {
        super(message, winner, loser);
    }
}
