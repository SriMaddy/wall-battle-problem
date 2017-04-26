package app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import app.factory.TimeUnit;
import app.tribe.Tribe;

public class WallBattleGame {

	private static int possibleSucessfulAttackCount;
	private static Wall wall;

	public void setUp() {
		createEmptyWall();
	}

	private void createEmptyWall() {
		wall = Wall.create();
//		System.out.println("wall: " + wall.toString());
	}

	public void play(List<TimeUnit> timeUnits) {
		// start to attack wall
		Map<Direction, Weapon> resultMap = new HashMap<>();
		int index = 0;
		do {
//			System.out.println("attack on Day" + (index + 1) + " starting...");
			TimeUnit timeUnit = timeUnits.get(index);
			List<Tribe> tribes = timeUnit.getTribes();
			for (Tribe tribe : tribes) {
				List<Weapon> weapons = tribe.getWeapons();
				Weapon weapon = weapons.get(0);
				boolean isAttackSuccessful = tribe.attack(wall, tribe.getDirection(), weapon);
//				System.out.println("isAttackSuccessful: " + isAttackSuccessful);
				if (isAttackSuccessful) {
					possibleSucessfulAttackCount += 1;
					resultMap.put(tribe.getDirection(), weapon);
				}
			}
			index++;
			for (Entry<Direction, Weapon> entry : resultMap.entrySet()) {
				Direction direction = entry.getKey();
				Weapon weapon = entry.getValue();
				wall.updateHeight(direction, weapon.getNetPower());
			}
//			System.out.println("wall after attack-" + index + ": " + wall.toString());
			resultMap.clear();
		} while (index < timeUnits.size());

		System.out.println(possibleSucessfulAttackCount);
	}
}
