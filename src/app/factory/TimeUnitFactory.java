package app.factory;

import java.util.List;

import app.TimeUnit;
import app.Tribe;

public class TimeUnitFactory {

	private static TimeUnitFactory timeUnitFactory;

	private TimeUnitFactory() {
	}

	public static TimeUnitFactory create() {
		if (timeUnitFactory == null) {
			timeUnitFactory = new TimeUnitFactory();
		}
		return timeUnitFactory;
	}

	public TimeUnit createTimeUnit(List<Tribe> tribes) {
		TimeUnit timeUnit = new TimeUnit();
		timeUnit.setTribes(tribes);
		return timeUnit;
	}
}
