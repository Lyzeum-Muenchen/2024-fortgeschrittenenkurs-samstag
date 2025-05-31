package de.lyzeum.games.turnbasedgame.model.ability;

import de.lyzeum.games.turnbasedgame.model.ElementalType;
import de.lyzeum.games.turnbasedgame.model.GameCharacter;
import de.lyzeum.games.turnbasedgame.model.GameState;

public abstract class ActiveAbility extends Ability {

	protected ElementalType elementalType;
	protected ActiveAbilityTargetType targetType; // beliebiges Feld oder nur Gegner
	protected int range;
	protected int blastRadius;

	public ActiveAbility(
			String title,
			ElementalType elementalType,
			ActiveAbilityTargetType targetType,
			int range,
			int blastRadius) {
		super(title);
		this.elementalType = elementalType;
		this.targetType = targetType;
		this.range = range;
		this.blastRadius = blastRadius;
	}

	@Override
	public boolean hasActiveAbility() {
		return true;
	}

	@Override
	public void applyPassiveAbility(GameCharacter executor, GameState gameState) {
		throw new RuntimeException("Active Ability cannot have passive!");
	}
}
