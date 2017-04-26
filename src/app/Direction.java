package app;

public enum Direction {

//	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	N("NORTH"), S("SOUTH"), E("EAST"), W("WEST");

	private String direction;

	private Direction(String direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return direction;
	}
}
