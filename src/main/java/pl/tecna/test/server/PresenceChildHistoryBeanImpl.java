package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.PresenceChildHistory;
import pl.tecna.test.domain.PresenceHistory;

public class PresenceChildHistoryBeanImpl implements PresenceChildHistoryBean {

	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public PresenceChildHistory create(Child child, PresenceHistory presenceHistory, Boolean isPresent) {
		PresenceChildHistory pch = new PresenceChildHistory();
		pch.setChild(child);
		pch.setPresenceHistory(presenceHistory);
		pch.setIsPresent(isPresent);
		em.get().persist(pch); 
		return pch;
	}

	@Override
	@Transactional
	public List<Child> getPresentChildList(Activity activity, Date date) {
		Query query = em.get().createQuery("SELECT pch.Child FROM PresenceChildHistory pch WHERE Activity=:activityId AND PresenceDate=:date AND isPresent = 1", Child.class);
		query.setParameter("activityId", activity.getId());
		query.setParameter("date", date);
		List<Child> children = query.getResultList();
		return children;
	}
	
	@Override
	@Transactional
	public List<Child> getAbsentChildList(Activity activity, Date date) {
		Query query = em.get().createQuery("SELECT pch.Child FROM PresenceChildHistory pch WHERE Activity=:activityId AND PresenceDate=:date AND isPresent = 0", Child.class);
		query.setParameter("activityId", activity.getId());
		query.setParameter("date", date);
		List<Child> children = query.getResultList();
		return children;
	}

}
