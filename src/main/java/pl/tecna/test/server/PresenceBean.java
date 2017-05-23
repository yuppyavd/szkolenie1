package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.History;
import pl.tecna.test.domain.Presence;

public interface PresenceBean {

	Presence add(Child child, History history, Boolean attended);
	List<Child> getPresentChildren(Activity activity, Date activityDate);
	List<Child> getAbsentChildren(Activity activity, Date activityDate);
}
