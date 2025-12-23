package character;

import constants.GameConstants;
import execption.DeadChampionActionException;
import execption.ManaActionException;
import log.Logger;

public abstract class Champion {

    // 속성
    private final String name;
    private int level;
    private int hp;
    private int attackDamage;
    private int defense;
    private int mana;

    // 생성자
    public Champion(String name, int level, int hp, int attackDamage, int defense, int mana) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defense = defense;
        this.mana = mana;
        GameConstants.addCreatedCount();
    }

    // 기능

    // 챔피언 기본 공격
    public void basicAttack(Champion target) {
        Logger.addLog(name + "이(가) " + target.getName() + "에게 기본공격!");
        target.takeDamage(this, attackDamage);
    }

    // 챔피언 피해 처리
    public void takeDamage(Champion damageGiver, int damage) {

        int trueDamage = Math.max(damage - defense, 0);
        Logger.addLog(damageGiver.getName() + "이(가) " + name + "에게 " + trueDamage + " 피해를 주었습니다");

        if (trueDamage >= hp) {
            hp = 0;
            throw new DeadChampionActionException(name + " 사망! 전투불능", damageGiver, this);
        } else {
            hp -= trueDamage;
        }

        Logger.addLog(name + " 현재 체력: " + hp);
    }

    // 레벨업 처리
    public void levelUp() {
        if (level == GameConstants.MAX_LEVEL){
            Logger.addLog(name + " 은(는) 최대 레벨입니다!");
            return;
        }

        level++;
        hp += growthHpByLevel();
        attackDamage += growthADByLevel();
        defense += growthDFByLevel();
        Logger.addLog(name + " 레벨업! 현재 레벨: "+ level + " 현재 체력: " + hp + " AD: " + attackDamage + " DF: " + defense );
    }

    // 챔피언별 고정 성장 능력치 반환
    public abstract int growthHpByLevel();
    public abstract int growthADByLevel();
    public abstract int growthDFByLevel();


    // Q 스킬 사용 메서드
    public abstract void useQ(Champion target);

    public void useMana(int useMana, Champion target) {
        if(mana < useMana){
            throw new ManaActionException(name + " 이(가) 마나가 부족하여 전투를 종료합니다.", target, this);
        } else {
            mana -= useMana;
        }
    }

    // getter
    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", attackDamage=" + attackDamage +
                ", defense=" + defense +
                ", mana=" + mana;

    }
}
