package execption;

import character.Champion;

public class BattleEndException extends RuntimeException {
    private final Champion winner;
    private final Champion loser;


    public BattleEndException(String message, Champion winner, Champion loser) {
        super(message);
        this.winner = winner;
        this.loser = loser;
    }

    public Champion getWinner() {
        return winner;
    }

    public Champion getLoser() {
        return loser;
    }
}
