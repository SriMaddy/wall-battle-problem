package app;

public class Wall {

	private Wall() {
	}

	public static Wall create() {
		Wall wall = null;
		if (wall == null) {
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
		}
		return wall;
	}

	private Side northSide;
	private Side southSide;
	private Side eastSide;
	private Side westSide;

	public void setNorthSide(Side northSide) {
		this.northSide = northSide;
	}

	public void setSouthSide(Side southSide) {
		this.southSide = southSide;
	}

	public void setEastSide(Side eastSide) {
		this.eastSide = eastSide;
	}

	public void setWestSide(Side westSide) {
		this.westSide = westSide;
	}

	public Side getSide(Direction direction) {
		if (direction == Direction.N) {
			return this.northSide;
		} else if (direction == Direction.S) {
			return this.southSide;
		} else if (direction == Direction.E) {
			return this.eastSide;
		} else if (direction == Direction.W) {
			return this.westSide;
		}
		return null;
	}

	@Override
	public String toString() {
		return northSide.toString() + " " + southSide.toString() + " " + eastSide.toString() + " "
				+ westSide.toString();
	}
}
