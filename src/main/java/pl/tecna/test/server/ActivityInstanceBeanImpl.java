package pl.tecna.test.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.ActivityInstance;
import pl.tecna.test.domain.EnumDay;

public class ActivityInstanceBeanImpl implements ActivityInstanceBean {

	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public ActivityInstance create(Activity activity, EnumDay day, Date hour) {
		ActivityInstance activityDay = new ActivityInstance();
		activityDay.setActivity(activity);
		activityDay.setWeekDay(day);
		activityDay.setHour(hour);
		em.get().persist(activityDay);
		return activityDay;
	}

	@Override
	@Transactional
	public List<Activity> getActivitiesListFromDay(EnumDay day) {
		List<Activity> activities = em.get().createQuery("SELECT AI.activity FROM ActivityInstance AI WHERE WeekDay=:day", Activity.class)
				.setParameter("day",  day.toString()).getResultList();
		return activities;
	}

}