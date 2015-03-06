package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.ActivityInstance;
import pl.tecna.test.domain.DayOfWeek;

import com.google.inject.ImplementedBy;

@ImplementedBy(ActivityBeanImpl.class)
public interface ActivityInstanceBean {

	ActivityInstance addActivityInstance(Activity activity, DayOfWeek dayOfWeek, Date hour);
	List<Activity> getActivitiesInWeekday(DayOfWeek dayOfWeek);
}
