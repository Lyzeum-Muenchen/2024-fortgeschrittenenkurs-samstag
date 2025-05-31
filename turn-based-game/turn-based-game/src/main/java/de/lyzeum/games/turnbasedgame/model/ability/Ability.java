package de.lyzeum.games.turnbasedgame.model.ability;

import de.lyzeum.games.turnbasedgame.model.GameCharacter;
import de.lyzeum.games.turnbasedgame.model.GameState;
import de.lyzeum.games.turnbasedgame.model.Position;

import java.util.Optional;

public abstract class Ability {

	protected String title;
	// TODO description

	public Ability(String title) {
		this.title = title;
	}

	public abstract boolean hasActiveAbility();

	public abstract void applyPassiveAbility(
			GameCharacter executor,
			GameState gameState
	);

	public abstract void applyActiveAbility(
			Position targetPosition,
			GameCharacter executor,
			GameState gameState
	);

	public abstract boolean canExecuteAbility(GameCharacter gameCharacter);

	public String getTitle() {
		return title;
	}
}
