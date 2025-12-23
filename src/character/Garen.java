package character;

import log.Logger;

public class Garen extends Champion{

    private static final int fixedGrowthHp = 50;
    private static final int fixedGrowthAD = 10;
    private static final int fixedGrowthDF = 5;


    public Garen(String name, int level, int hp, int attackDamage, int defense) {
        super(name, level, hp, attackDamage, defense);
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
        Logger.addLog(getName() + "이(가) " + target.getName() + "에게 결정타 스킬 사용");
        target.takeDamage(this, 100);
    }
}
