package E1_Working_with_Abstraction.P6_Greedy_Times;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentWeight;
    private long totalGold;
    private boolean hasGold;
    private long totalGems;
    private Map<String, Long> mapGems;
    private long totalCash;
    private Map<String, Long> mapCash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentWeight = 0;
        this.totalGold = 0;
        this.hasGold = false;
        this.totalGems = 0;
        this.mapGems = new HashMap<>();
        this.totalCash = 0;
        this.mapCash = new HashMap<>();
    }

    public void addGold(long quantity) {
        if (hasFreeSpace(quantity)) {
            totalGold += quantity;
            currentWeight += quantity;
            hasGold = true;
        }
    }

    public void addGems(String gem, long quantity) {
        if (hasFreeSpace(quantity) && totalGems + quantity <= totalGold) {
            if (mapGems.containsKey(gem)) {
                mapGems.put(gem, mapGems.get(gem) + quantity);
            }
            mapGems.putIfAbsent(gem, quantity);
            totalGems += quantity;
            currentWeight += quantity;
        }
    }

    public void addCash(String currency, long quantity) {
        if (hasFreeSpace(quantity) && totalCash + quantity <= totalGems) {
            if (mapCash.containsKey(currency)) {
                mapCash.put(currency, mapCash.get(currency) + quantity);
            }
            mapCash.putIfAbsent(currency, quantity);
            totalCash += quantity;
            currentWeight += quantity;
        }
    }

    public boolean hasFreeSpace(long quantity) {
        return currentWeight + quantity <= capacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (hasGold){
            stringBuilder.append(String.format("<Gold> $%d", totalGold)).append(System.lineSeparator());
            stringBuilder.append(String.format("##Gold - %d", totalGold)).append(System.lineSeparator());
        }

        if (mapGems.size() > 0) {
            stringBuilder.append(String.format("<Gem> $%d", totalGems)).append(System.lineSeparator());
            mapGems.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                stringBuilder.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                        .append(System.lineSeparator());
            });
        }

        if (mapCash.size() > 0) {
            stringBuilder.append(String.format("<Cash> $%d", totalCash)).append(System.lineSeparator());
            mapCash.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                stringBuilder.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                        .append(System.lineSeparator());
            });
        }

        return stringBuilder.toString();
    }
}
