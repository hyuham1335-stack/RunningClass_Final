import character.*;
import log.Logger;
import teambattle.ChampionPool;
import teambattle.SafeBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ChampionPool championPool = new ChampionPool();
        championPool.addChampion(new Garen("가렌", 1, 300, 100, 20));
        championPool.addChampion(new Garlio("갈리오", 1, 350, 60, 30));
        championPool.addChampion(new Rize("라이즈", 1, 250, 120, 15));
        championPool.addChampion(new Teemo("티모", 1, 300, 140, 10));

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        List<Champion> list = new ArrayList<>(championPool.getChampions().values());

        Champion champion1 = list.get(random.nextInt(list.size()));
        list.remove(champion1);
        Champion champion2 = list.get(random.nextInt(list.size()));
        list.remove(champion2);

        SafeBattle safeBattle = new SafeBattle();
        safeBattle.startBattle(champion1, champion2);

    }
}
