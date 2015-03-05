package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

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
		List<Child> children = em.get().createQuery("SELECT Child FROM PresenceChildHistory WHERE Activity="+activity.getId()
				+" AND PresenceDate="+date+ "AND isPresent = 1", Child.class).getResultList();
		return children;
	}
	
	@Override
	@Transactional
	public List<Child> getAbsentChildList(Activity activity, Date date) {
		List<Child> children = em.get().createQuery("SELECT Child FROM PresenceChildHistory WHERE Activity="+activity.getId()
				+" AND PresenceDate="+date+ "AND isPresent = 0", Child.class).getResultList();
		return children;
	}

}
