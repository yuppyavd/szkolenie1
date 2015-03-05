package pl.tecna.test.server;

import java.util.List;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.ChildActivity;

public class ChildActivityBeanImpl implements ChildActivityBean {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public ChildActivity create(Child child, Activity activity) {
		ChildActivity childActivity = new ChildActivity();
		childActivity.setChild(child);
		childActivity.setActivity(activity);
		em.get().persist(childActivity);
		return childActivity;
	}
	
	@Override
	@Transactional
	public List<Child> getChildrenListInActivity(Activity activity) {
		List<Child> children = em.get().createQuery("SELECT ca.Child FROM ChildActivity ca WHERE Activity=:activityId", Child.class)
				.setParameter("activityId",  activity.getId()).getResultList();
		return children;
	}

}
