package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.EnumDay;

import com.google.inject.ImplementedBy;

@ImplementedBy(ActivityBeanImpl.class)
public interface ActivityBean {
	
	Activity create(String name);
	List<Activity> getAllActivitiesList();
	List<Activity> getActivitiesListFromDay(EnumDay day);
	
}
