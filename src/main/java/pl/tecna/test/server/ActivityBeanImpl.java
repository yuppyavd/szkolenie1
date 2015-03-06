package pl.tecna.test.server;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.onami.persist.EntityManagerProvider;

import pl.tecna.test.domain.Activity;

public class ActivityBeanImpl implements ActivityBean {

	@Inject
	private EntityManagerProvider em;
	
	@Override
	@Transactional
	public Activity addActivity(String name) {
		Activity newActivity = new Activity();
		newActivity.setName(name);
		em.get().persist(newActivity);
		return newActivity;
	}
}
