package app;

public class Wall {

	private Side northSide;
	private Side southSide;
	private Side eastSide;
	private Side westSide;

	private Wall() {
		this.buildSides();
	}

	public static Wall create() {
		Wall wall = null;
		if (wall == null) {
			wall = new Wall();
		}
		return wall;
	}

	private void buildSides() {
		this.northSide = new Side(Direction.valueOf(Direction.N.name()));
		northSide.setHeight(Constants.INITIAL_WALL_HEIGHT);

		this.southSide = new Side(Direction.valueOf(Direction.S.name()));
		this.southSide.setHeight(Constants.INITIAL_WALL_HEIGHT);

		this.eastSide = new Side(Direction.valueOf(Direction.E.name()));
		this.eastSide.setHeight(Constants.INITIAL_WALL_HEIGHT);

		this.westSide = new Side(Direction.valueOf(Direction.W.name()));
		this.westSide.setHeight(Constants.INITIAL_WALL_HEIGHT);
	}

	private Side getSide(Direction direction) {
		if (direction.isNorth()) {
			return this.northSide;
		} else if (direction.isSouth()) {
			return this.southSide;
		} else if (direction.isEast()) {
			return this.eastSide;
		} else if (direction.isWest()) {
			return this.westSide;
		}
		return null;
	}

	public void updateHeight(Direction direction, int height) {
		Side side = getSide(direction);
		side.setHeight(height);
	}

	public boolean isSideBreakable(Direction direction, Weapon weapon) {
		Side side = getSide(direction);
		return side.isBreakable(weapon.getNetPower());
	}

	@Override
	public String toString() {
		return northSide.toString() + " " + southSide.toString() + " " + eastSide.toString() + " "
				+ westSide.toString();
	}
}
