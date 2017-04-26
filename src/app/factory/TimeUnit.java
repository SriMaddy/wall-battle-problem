package app.factory;

import java.util.List;

import app.tribe.Tribe;

public class TimeUnit {

	private List<Tribe> tribes;
	
	TimeUnit() {
	}

	public List<Tribe> getTribes() {
		return tribes;
	}

	public void setTribes(List<Tribe> tribes) {
		this.tribes = tribes;
	}
	
	@Override
	public String toString() {
		return tribes.toString();
	}

}
