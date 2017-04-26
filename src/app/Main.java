package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.factory.TimeUnit;
import app.factory.TimeUnitFactory;
import app.tribe.Tribe;
import app.tribe.TribeFactory;

public class Main {

	public static void main(String[] args) {
		String input;
		Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter input:");
		input = scanner.nextLine();
		scanner.close();

		WallBattleGame game = new WallBattleGame();
		game.setUp();
		List<TimeUnit> timeUnits = processInput(input);
		game.play(timeUnits);
	}

	private static List<TimeUnit> processInput(String input) {
		List<TimeUnit> timeUnits = new ArrayList<>();
		String[] days = input.split(Constants.DAY_SEPERATOR);
		for (String day : days) {
			day = day.replaceAll(" ", "");
			int indexOfSeperator = day.indexOf(Constants.DOLLAR_SEPERATOR);
			String attacksPerDay = day.substring(indexOfSeperator + 1);

			TimeUnitFactory timeUnitFactory = TimeUnitFactory.create();
			TribeFactory tribeFactory = TribeFactory.create();

			if (attacksPerDay.contains(Constants.TRIBE_SEPERATOR)) {
				String[] attacksArray = attacksPerDay.split(Constants.TRIBE_SEPERATOR);
				List<Tribe> tribes = new ArrayList<>();
				for (String singleAttack : attacksArray) {
					Tribe tribe = tribeFactory.createTribe(singleAttack);
					tribes.add(tribe);
				}
				timeUnits.add(timeUnitFactory.createTimeUnit(tribes));
			} else {
				List<Tribe> tribes = new ArrayList<>();
				Tribe tribe = tribeFactory.createTribe(attacksPerDay);
				tribes.add(tribe);
				// System.out.println("tribes: " + tribes.toString());
				timeUnits.add(timeUnitFactory.createTimeUnit(tribes));
			}
		}

		/*
		 * for (TimeUnit timeUnit : timeUnits) { System.out.println("Day: " +
		 * (timeUnits.indexOf(timeUnit) + 1) + timeUnit.toString()); }
		 * 
		 * System.out.println("TotalDays: " + timeUnits.size());
		 */
		return timeUnits;
	}
}
