package app.tribe;

import java.util.List;

import app.Direction;
import app.Wall;
import app.Weapon;

public class Tribe {

	private String name;
	private List<Weapon> weapons;
	private Direction direction;

	Tribe() {
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean attack(Wall wall, Direction direction, Weapon weapon) {
		return wall.isSideBreakable(direction, weapon);
	}

	@Override
	public String toString() {
		return name + " " + weapons.toString() + " " + direction.toString();
	}

}
