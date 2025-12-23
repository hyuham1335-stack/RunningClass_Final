package teambattle;

import character.Champion;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChampionPool {

    private Map<String, Champion> champions = new HashMap<>();

    public void addChampion(Champion champion) {
        champions.put(champion.getName(), champion);
    }

    public Optional<Champion> findChampion(String championName) {
        return Optional.ofNullable(champions.get(championName));
    }
}
