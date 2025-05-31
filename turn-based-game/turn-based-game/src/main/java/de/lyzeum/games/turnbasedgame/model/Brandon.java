package de.lyzeum.games.turnbasedgame.model;

import java.util.Set;

public class Brandon extends GameCharacter {
	private static final double MAX_HEALTH = 100;
	private static final double MAX_STAMINA = 25;
	private static final double ATTACK_DMG = 10;
	private static final double BASE_RES = 3;
	private static final int STEPS_PER_TURN = 4;

	public Brandon(Position currentPosition, boolean isHumanControlled) {
		super(
			MAX_HEALTH,
			MAX_HEALTH,
			MAX_STAMINA,
			MAX_STAMINA,
			ATTACK_DMG,
			BASE_RES,
			Set.of(),
			currentPosition,
			STEPS_PER_TURN,
			isHumanControlled
		);
	}
}
