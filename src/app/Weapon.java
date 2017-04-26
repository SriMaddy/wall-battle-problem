package app;

public class Weapon {

	private String name;
	private int unitPower;
	private int netPower;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPower() {
		return unitPower;
	}

	public void setUnitPower(int unitPower) {
		this.unitPower = unitPower;
	}

	public int getNetPower() {
		return netPower;
	}

	public void setNetPower(int netPower) {
		this.netPower = netPower;
	}

	@Override
	public String toString() {
		return name + " " + unitPower + " " + netPower;
	}
}
