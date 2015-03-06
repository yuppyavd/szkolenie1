package pl.tecna.test.server;

import java.util.List;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.EnrolledChild;

public class EnrolledChildBeanImpl implements EnrolledChildBean {

	@Inject
	private EntityManagerProvider em;

	@Override
	public EnrolledChild enroll(Child child, Activity activity) {
		EnrolledChild newEnrolledChild = new EnrolledChild();
		newEnrolledChild.setChild(child);
		newEnrolledChild.setActivity(activity);
		
		return newEnrolledChild;
	}

	@Override
	public List<Child> getEnrolledList(Activity activity) {
		List<Child> children;
		children = em.get().createQuery("SELECT ec FROM EnrolledChild ec WHERE ec.activity = ?1", Child.class).setParameter(1, activity.getId()).getResultList();
		
		return children;
	}
}
