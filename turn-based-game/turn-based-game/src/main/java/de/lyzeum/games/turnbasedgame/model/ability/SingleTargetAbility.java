package de.lyzeum.games.turnbasedgame.model.ability;

import de.lyzeum.games.turnbasedgame.model.ElementalType;
import de.lyzeum.games.turnbasedgame.model.GameCharacter;
import de.lyzeum.games.turnbasedgame.model.GameState;
import de.lyzeum.games.turnbasedgame.model.Position;

import java.util.Optional;

public class SingleTargetAbility extends ActiveAbility {

	protected double damage;
	protected int staminaCost;
	public SingleTargetAbility(String title,
							   ElementalType elementalType,
							   int range, double damage, int staminaCost) {
		super(
			title,
			elementalType,
			ActiveAbilityTargetType.OPPOSITE_FACTION_ONLY,
			range,
			0
		);
		this.damage = damage;
		this.staminaCost = staminaCost;
	}

	@Override
	public void applyActiveAbility(Position targetPosition, GameCharacter executor, GameState gameState) {
		// Ziel finden
		Optional<GameCharacter> target = gameState.getCharacters(!executor.isHumanControlled())
				.stream()
				.filter(character -> character.getCurrentPosition().equals(targetPosition))
				.findFirst();
		if (target.isPresent()) {
			// Schaden anwenden
			target.get().applyDamage(damage, elementalType);
			// Stamina reduzieren
			executor.subtractStamina(staminaCost);
		} else {
			throw new RuntimeException("Character not found");
		}

	}

	@Override
	public boolean canExecuteAbility(GameCharacter gameCharacter) {
		return gameCharacter.getCurStamina() >= staminaCost;
	}
}
