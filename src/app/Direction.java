package app;

public enum Direction {

	N("NORTH"), S("SOUTH"), E("EAST"), W("WEST");

	private String direction;

	private Direction(String direction) {
		this.direction = direction;
	}

	public boolean isNorth() {
		return this == Direction.N;
	}

	public boolean isSouth() {
		return this == Direction.S;
	}

	public boolean isEast() {
		return this == Direction.E;
	}

	public boolean isWest() {
		return this == Direction.W;
	}

	@Override
	public String toString() {
		return direction;
	}
}
