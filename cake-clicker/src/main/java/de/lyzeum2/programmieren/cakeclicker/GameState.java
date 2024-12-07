package de.lyzeum2.programmieren.cakeclicker;

public class GameState {
    private long counter;
    private long clickValue;
    private long automaticClickValue;
    private String[] upgradeNames;
    private long[] upgradeCosts;
    private Item[] items;

    public GameState() {
        counter = 0;
        clickValue = 1;
        automaticClickValue = 0;
        items = new Item[]{
                new Item( "Backofen", 100, 0, 1, 1),
                new Item( "Zitronenkuchen", 500, 0, 10, 1),
                new Item( "Schokokuchen", 2500, 0, 60, 3),
                new Item( "Pancake", 20000, 0, 750, 5),
                new Item( "Keksbaum", 100000, 0, 4000, 10),
                new Item( "Super Smelter", 5_000_000, 0, 5000, 10000),
                new Item( "Schwarzwälderkirschtorte", 10_000_000, 0, 50000, 50000),
        };
    }

    public void onClick() {
        counter += clickValue;
    }

    public long getCounter() {
        return counter;
    }

    public Item[] getUpgrades() {
        return items;
    }

    public void buyUpgrade(
            long upgradeCost,
            long clickValue,
            long automaticClickValue
    ) {
        this.counter = counter - upgradeCost;
        this.clickValue += clickValue;
        this.automaticClickValue += automaticClickValue;
    }
}
