package app;

public class Side {

	private int height;
	private Direction direction;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isBreakable(int power) {
		return power > this.height;
	}

	@Override
	public String toString() {
		return direction.toString() + " " + height;
	}
}
