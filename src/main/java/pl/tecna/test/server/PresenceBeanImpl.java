package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.onami.persist.EntityManagerProvider;
import org.hibernate.Query;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.History;
import pl.tecna.test.domain.Presence;

public class PresenceBeanImpl implements PresenceBean {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public Presence add(Child child, History history, Boolean attended) {
		Presence newPresence = new Presence();
		newPresence.setChild(child);
		newPresence.setHistory(history);
		newPresence.setAttended(attended);
		em.get().persist(newPresence);
		
		return newPresence;
	}

	@Override
	@Transactional
	public List<Child> getPresentChildren(Activity activity, Date activityDate) {
		TypedQuery<History> query = em.get().createQuery("SELECT h FROM History WHERE h.activity = ?1 AND activityDate = ?2", History.class);
		query.setParameter(1, activity);
		query.setParameter(2, activityDate);
		History pastActivity = query.getSingleResult();
		
		List<Child> children;
		children = em.get().createQuery("SELECT p.child FROM Presence p WHERE p.history = ?1 AND attended  = 1", Child.class).setParameter(1, pastActivity).getResultList();
		return children;
	}

	@Override
	@Transactional
	public List<Child> getAbsentChildren(Activity activity, Date activityDate) {
		TypedQuery<History> query = em.get().createQuery("SELECT h FROM History WHERE h.activity = ?1 AND activityDate = ?2", History.class);
		query.setParameter(1, activity);
		query.setParameter(2, activityDate);
		History pastActivity = query.getSingleResult();
		
		List<Child> children;
		children = em.get().createQuery("SELECT p.child FROM Presence p WHERE p.history = ?1 AND attended  = 0", Child.class).setParameter(1, pastActivity).getResultList();
		return children;
	}
	

}
