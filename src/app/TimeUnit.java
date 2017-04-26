package app;

import java.util.List;

public class TimeUnit {

	private List<Tribe> tribes;

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
