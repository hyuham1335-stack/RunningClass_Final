package character;

import log.Logger;

public class Teemo extends Champion{

    private static final int fixedGrowthHp = 30;
    private static final int fixedGrowthAD = 12;
    private static final int fixedGrowthDF = 4;


    public Teemo(String name, int level, int hp, int attackDamage, int defense) {
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
        Logger.addLog(getName() + "이(가) " + target.getName() + "에게 실명 스킬 사용");
        target.takeDamage(this, 100);
    }
}
