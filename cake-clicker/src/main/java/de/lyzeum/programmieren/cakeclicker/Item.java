package de.lyzeum.programmieren.cakeclicker;

public class Item {
    private String upgradeName;
    private long upgradeCost;
    private int count;
    private long manualClickValue;
    private long automaticClickValue;

    public Item(String upgradeName,
                long upgradeCost,
                int count,
                long manualClickValue,
                long automaticClickValue) {
        this.upgradeCost = upgradeCost;
        this.upgradeName = upgradeName;
        this.count = count;
        this.manualClickValue = manualClickValue;
        this.automaticClickValue = automaticClickValue;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

    public long getUpgradeCost() {
        return upgradeCost;
    }

    public int getCount() {
        return count;
    }

    public long getManualClickValue() {
        return manualClickValue;
    }

    public long getAutomaticClickValue() {
        return automaticClickValue;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setUpgradeCost(long upgradeCost) {
        this.upgradeCost = upgradeCost;
    }
}
