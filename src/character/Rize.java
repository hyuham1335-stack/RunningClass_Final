package character;

import log.Logger;

public class Rize extends Champion {

    private static final int fixedGrowthHp = 40;
    private static final int fixedGrowthAD = 6;
    private static final int fixedGrowthDF = 7;


    public Rize(String name, int level, int hp, int attackDamage, int defense, int mana) {
        super(name, level, hp, attackDamage, defense, mana);
    }


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
        useMana(100, target);
        Logger.addLog(getName() + "이(가) " + target.getName() + "에게 과부하 스킬 사용 / " + getName() + " 현재 마나: " + getMana());
        target.takeDamage(this, 120);
    }
}
