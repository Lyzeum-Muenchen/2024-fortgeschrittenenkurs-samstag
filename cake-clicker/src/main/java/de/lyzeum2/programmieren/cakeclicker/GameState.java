package de.lyzeum2.programmieren.cakeclicker;

public class GameState {
    private long counter;
    private long clickValue;
    private String[] upgradeNames;
    private long[] upgradeCosts;

    public GameState() {
        counter = 0;
        clickValue = 1;
        upgradeNames = new String[]{
                "Backofen",
                "Zitronenkuchen",
                "Schokokuchen",
                "Pancake",
                "Keksbaum",
                "Super Smelter",
                "Schwarzwälderkirschtorte"
        };
        upgradeCosts = new long[]{
                100,
                500,
                2500,
                20000,
                100000,
                5000000,
        };
    }

    public void onClick() {
        counter += clickValue;
    }

    public long getCounter() {
        return counter;
    }
}
