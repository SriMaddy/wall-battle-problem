package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainClass {

	private static final String DAY_SEPERATOR = ";";
	private static final String DOLLAR_SEPERATOR = "$";
	private static final String TRIBE_SEPERATOR = ":";
	private static final String TASK_SEPERATOR = "-";

	private static final int TRIBE_POSITION = 0;
	private static final int DIRECTION_POSITION = 1;
	private static final int WEAPON_POSITION = 2;
	private static final int POWER_POSITION = 3;

	private static int possibleSucessfulAttackCount;

	private static Wall wall;

	public static void main(String[] args) {
		String input;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter input:");
		input = scanner.nextLine();
		scanner.close();

		createEmptyWall();
		processInput(input);
	}

	private static void createEmptyWall() {
		wall = new Wall();
		Side northSide = new Side();
		northSide.setDirection(Direction.valueOf(Direction.N.name()));
		northSide.setHeight(0);
		wall.setNorthSide(northSide);

		Side southSide = new Side();
		southSide.setDirection(Direction.valueOf(Direction.S.name()));
		southSide.setHeight(0);
		wall.setSouthSide(southSide);

		Side eastSide = new Side();
		eastSide.setDirection(Direction.valueOf(Direction.E.name()));
		eastSide.setHeight(0);
		wall.setEastSide(eastSide);

		Side westSide = new Side();
		westSide.setDirection(Direction.valueOf(Direction.W.name()));
		westSide.setHeight(0);
		wall.setWestSide(westSide);

//		System.out.println("wall: " + wall.toString());
	}

	private static void processInput(String input) {
		String[] inputs = input.split(DAY_SEPERATOR);

		List<TimeUnit> timeUnits = new ArrayList<>();

		for (String in : inputs) {
			// System.out.println("in:" + in);

			int indexOfSeperator = in.indexOf(DOLLAR_SEPERATOR);
			String subInput = in.substring(indexOfSeperator + 2);
			subInput = subInput.replaceAll(" ", "");

			// System.out.println("subInput:" + subInput);

			if (subInput.contains(TRIBE_SEPERATOR)) {
				String[] subInputArr = subInput.split(TRIBE_SEPERATOR);
				List<Tribe> tribes = new ArrayList<>();
				for (String s : subInputArr) {
					// System.out.println("s:" + s);
					Tribe tribe = getTribe(s);
					tribes.add(tribe);
				}
				// System.out.println("tribes: " + tribes.toString());
				timeUnits.add(createTimeUnit(tribes));
			} else {
				List<Tribe> tribes = new ArrayList<>();
				Tribe tribe = getTribe(subInput);
				tribes.add(tribe);
				timeUnits.add(createTimeUnit(tribes));
			}
		}

		for (TimeUnit timeUnit : timeUnits) {
//			System.out.println("TimeUnit: " + timeUnit.toString());
		}

//		System.out.println("timeUnitSize: " + timeUnits.size());

		// start to attack wall
		Map<Side, Integer> resultMap = new HashMap<>();
		int index = 0;
		do {
			TimeUnit timeUnit = timeUnits.get(index);
			List<Tribe> tribes = timeUnit.getTribes();
			for (Tribe tribe : tribes) {
				List<Weapon> weapons = tribe.getWeapons();
				Side sideToBeAttacked = wall.getSide(tribe.getDirection());
				Weapon weapon = weapons.get(0);
				boolean isAttackSuccessful = tribe.attackOneSideOfWall(sideToBeAttacked, weapon);
//				System.out.println("isAttackSuccessful: " + isAttackSuccessful);
				if (isAttackSuccessful) {
					possibleSucessfulAttackCount += 1;
					resultMap.put(sideToBeAttacked, weapon.getPower());
				}
			}
			index++;
			for (Entry<Side, Integer> entry : resultMap.entrySet()) {
				Side side = entry.getKey();
				int height = entry.getValue();
				side.setHeight(height);
				if (side.getDirection() == Direction.N) {
					wall.setNorthSide(side);
				} else if (side.getDirection() == Direction.S) {
					wall.setSouthSide(side);
				} else if (side.getDirection() == Direction.E) {
					wall.setEastSide(side);
				} else if (side.getDirection() == Direction.W) {
					wall.setWestSide(side);
				}
			}
//			System.out.println("wall after attack: " + wall.toString());
			resultMap.clear();
		} while (index < timeUnits.size());
		
		System.out.println(possibleSucessfulAttackCount);
	}

	private static TimeUnit createTimeUnit(List<Tribe> tribes) {
		TimeUnit timeUnit = new TimeUnit();
		timeUnit.setTribes(tribes);
		return timeUnit;
	}

	private static Tribe getTribe(String subInput) {
		String[] task = subInput.split(TASK_SEPERATOR);

		Tribe tribe = new Tribe();
		tribe.setName(task[TRIBE_POSITION]);

		// System.out.println("direction: " + task[DIRECTION_POSITION]);

		Direction direction = Direction.valueOf(task[DIRECTION_POSITION]);
		tribe.setDirection(direction);

		Weapon weapon = new Weapon();
		weapon.setName(task[WEAPON_POSITION]);
		weapon.setPower(Integer.parseInt(task[POWER_POSITION]));
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(weapon);
		tribe.setWeapons(weapons);

		return tribe;
	}

}
