package character;

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
    public void takeDamage(Champion enemy, int damage) {

        int trueDamage = Math.max(damage - defense, 0);
        Logger.addLog(enemy.getName() + "이(가) " + name + "에게 " + trueDamage + " 피해를 주었습니다");

        if (trueDamage >= hp) {
            hp = 0;
            Logger.addLog(name + " 사망! 전투불능");
        } else {
            hp -= trueDamage;
        }
    }

    // 레벨업
    public void levelUp() {
        Logger.addLog(name + " 레벨업!");
        statusUp();
    }

    // 레벨 업 시 캐릭터별 스탯 증가
    public abstract void statusUp();


    // Q 스킬 사용
    public void useQ(Champion target){
        Logger.addLog(name + "이(가) " + target.getName() + "에게 Q 스킬 사용");
        useQByChampion(target);
    }

    // 챔피언별 Q 스킬 세분화
    public abstract void useQByChampion(Champion target);


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
}
