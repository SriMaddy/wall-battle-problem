package app.tribe;

import java.util.ArrayList;
import java.util.List;

import app.Constants;
import app.Direction;
import app.Weapon;

public class TribeFactory {

	private static TribeFactory tribeFactory;

	private TribeFactory() {
	}

	public static TribeFactory create() {
		if (tribeFactory == null) {
			tribeFactory = new TribeFactory();
		}
		return tribeFactory;
	}

	public Tribe createTribe(String subInput) {
		String[] task = subInput.split(Constants.TASK_SEPERATOR);

		Tribe tribe = new Tribe();
		tribe.setName(task[Constants.TRIBE_POSITION]);

		Direction direction = Direction.valueOf(task[Constants.DIRECTION_POSITION]);
		tribe.setDirection(direction);

		Weapon weapon = new Weapon();
		weapon.setName(task[Constants.WEAPON_POSITION]);
		weapon.setUnitPower(1);
		weapon.setNetPower(weapon.getUnitPower() * Integer.parseInt(task[Constants.POWER_POSITION]));
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(weapon);
		tribe.setWeapons(weapons);
		return tribe;
	}
}
