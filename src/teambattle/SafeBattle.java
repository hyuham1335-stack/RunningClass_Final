package teambattle;

import character.Champion;
import execption.DeadChampionActionException;
import log.Logger;

public class SafeBattle {

    public void startBattle(Champion champ1, Champion champ2) {

        Logger.addLog(champ1.getName() + " 와(과) " + champ2.getName() + " 1:1 대결 진행!");

        try{
            Logger.addLog(champ1.toString());
            Logger.addLog(champ2.toString());

            while(true){
                champ1.basicAttack(champ2);
                champ2.basicAttack(champ1);

                champ1.useQ(champ2);
                champ2.useQ(champ1);

                champ1.levelUp();
                champ2.levelUp();

            }
        } catch(DeadChampionActionException e) {
            Logger.addLog(e.getMessage());
            Logger.addLog(e.getWinner().getName() + " 이(가) " + e.getLoser().getName() + " 상대로 승리하였습니다.");
        }
        Logger.addLog("전투를 종료합니다.");
    }
}
