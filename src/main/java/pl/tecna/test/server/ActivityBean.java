package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Activity;

import com.google.inject.ImplementedBy;

@ImplementedBy(ActivityBeanImplTest.class)
public interface ActivityBean {
	
	Activity create(String name);
	List<Activity> getAllActivitiesList();
	
}
