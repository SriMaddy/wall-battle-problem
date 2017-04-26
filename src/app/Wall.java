package app;

public class Wall {

	/*
	 * private List<Side> sides;
	 * 
	 * public List<Side> getSides() { return sides; }
	 * 
	 * public void setSide(List<Side> sides) { this.sides = sides; }
	 * 
	 * @Override public String toString() { return sides.toString(); }
	 */

	private Side northSide;
	private Side southSide;
	private Side eastSide;
	private Side westSide;

	public Side getNorthSide() {
		return northSide;
	}

	public void setNorthSide(Side northSide) {
		this.northSide = northSide;
	}

	public Side getSouthSide() {
		return southSide;
	}

	public void setSouthSide(Side southSide) {
		this.southSide = southSide;
	}

	public Side getEastSide() {
		return eastSide;
	}

	public void setEastSide(Side eastSide) {
		this.eastSide = eastSide;
	}

	public Side getWestSide() {
		return westSide;
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
