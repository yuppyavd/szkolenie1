package pl.tecna.test.server;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Activity;

public class ActivityBeanImpl implements ActivityBean {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public Activity create(String name) {
		Activity activity = new Activity();
		activity.setName(name);
		em.get().persist(activity);
		return activity;
	}

}
