package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.onami.persist.EntityManagerProvider;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.ActivityInstance;
import pl.tecna.test.domain.DayOfWeek;

public class ActivityInstanceBeanImpl implements ActivityInstanceBean {

	@Inject
	private EntityManagerProvider em;
	
	@Override
	@Transactional
	public ActivityInstance addActivityInstance(Activity activity,
			DayOfWeek dayOfWeek, Date hour) {
		
		ActivityInstance newActivityInstance = new ActivityInstance();
		newActivityInstance.setActivity(activity);
		newActivityInstance.setDayOfWeek(dayOfWeek);
		newActivityInstance.setHour(hour);
		em.get().persist(newActivityInstance);
		
		return newActivityInstance;
	}
	
	@Override
	@Transactional
	public List<Activity> getActivitiesInWeekday(DayOfWeek dayOfWeek) {
		List<Activity> activities;
		activities = em.get().createQuery("SELECT ai.activity FROM ActivityInstance ai WHERE ai.dayOfWeek = ?1", Activity.class)
				.setParameter(1, dayOfWeek).getResultList();
		
		return activities;
	}
	
}
