package de.lyzeum.games.turnbasedgame.model;

import java.util.Set;

public abstract class GameCharacter {
    protected double curHealth;
    protected double maxHealth;
    protected double curStamina;
    protected double maxStamina;

    protected double baseAttackDmg;
    protected double baseResistance;
    protected Set<ElementalType> resistances;

    protected Position currentPosition;
    protected int stepsPerTurn;
    protected boolean isHumanControlled;
    // TODO
    // baseDodgeChange

    // TODO Definition Attack
    // ElementalType, StaminaVerbrauch
    // DamageMultiplier, Name,
    // dodgeable ( true/false)


    public GameCharacter(double curHealth, double maxHealth, double curStamina, double maxStamina, double baseAttackDmg, double baseResistance, Set<ElementalType> resistances, Position currentPosition, int stepsPerTurn, boolean isHumanControlled) {
        this.curHealth = curHealth;
        this.maxHealth = maxHealth;
        this.curStamina = curStamina;
        this.maxStamina = maxStamina;
        this.baseAttackDmg = baseAttackDmg;
        this.baseResistance = baseResistance;
        this.resistances = resistances;
        this.currentPosition = currentPosition;
        this.stepsPerTurn = stepsPerTurn;
        this.isHumanControlled = isHumanControlled;
    }


    public double getCurHealth() {
        return curHealth;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getCurStamina() {
        return curStamina;
    }

    public double getMaxStamina() {
        return maxStamina;
    }

    public double getBaseAttackDmg() {
        return baseAttackDmg;
    }

    public double getBaseResistance() {
        return baseResistance;
    }

    public Set<ElementalType> getResistances() {
        return resistances;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getStepsPerTurn() {
        return stepsPerTurn;
    }
}
