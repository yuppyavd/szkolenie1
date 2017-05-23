package pl.tecna.test.server;

import java.util.Date;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.PresenceHistory;

public class PresenceHistoryBeanImpl implements PresenceHistoryBean {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public PresenceHistory create(Activity activity, Date date) {
		PresenceHistory ph = new PresenceHistory();
		ph.setActivity(activity);
		ph.setPresenceDate(date);
		em.get().persist(ph); 
		return ph;
	}

}
