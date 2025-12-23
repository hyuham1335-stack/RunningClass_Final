package character;

import log.Logger;

public class Garlio extends Champion{

    // 속성
    private static final int fixedGrowthHp = 80;
    private static final int fixedGrowthAD = 5;
    private static final int fixedGrowthDF = 10;

    // 생성자
    public Garlio(String name, int level, int hp, int attackDamage, int defense, int mana) {
        super(name, level, hp, attackDamage, defense, mana);
    }

    // 기능
    @Override
    public int growthHpByLevel() {
        return fixedGrowthHp;
    }

    @Override
    public int growthADByLevel() {
        return fixedGrowthAD;
    }

    @Override
    public int growthDFByLevel() {
        return fixedGrowthDF;
    }

    @Override
    public void useQ(Champion target) {
        useMana(40, target);
        Logger.addLog(getName() + "이(가) " + target.getName() + "에게 전장의 돌풍 스킬 사용 / " + getName() + " 현재 마나: " + getMana());
        target.takeDamage(this, 80);
    }
}
