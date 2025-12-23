package character;

import execption.DeadChampionActionException;
import log.Logger;

public abstract class Champion {

    // 속성
    private String name;
    private int level;
    private int hp;
    private int attackDamage;
    private int defense;

    // 생성자
    public Champion(String name, int level, int hp, int attackDamage, int defense) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defense = defense;
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
        level++;
        hp += growthHpByLevel();
        attackDamage += growthADByLevel();
        defense += growthDFByLevel();
        Logger.addLog(name + " 레벨업! 현재 레벨: "+ level + " 현재 체력: " + hp + " AD: " + attackDamage + " DF: " + defense );
    }

    public abstract int growthHpByLevel();
    public abstract int growthADByLevel();
    public abstract int growthDFByLevel();


    // Q 스킬 사용
    public abstract void useQ(Champion target);



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

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", attackDamage=" + attackDamage +
                ", defense=" + defense +
                '}';
    }
}
