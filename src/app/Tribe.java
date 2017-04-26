package app;

import java.util.List;

public class Tribe {

	private String name;
	private List<Weapon> weapons;
	private Direction direction;

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
	
	public boolean attackOneSideOfWall(Side side, Weapon weapon) {
		return side.isBreakable(weapon.getPower());
	}
	
	@Override
	public String toString() {
		if(direction != null) {
			return name + " " + weapons.toString() + " " + direction.toString();
		}
		return name + " " + weapons.toString();
	}

}
