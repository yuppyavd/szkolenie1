package pl.tecna.test.server;

import java.util.Date;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.onami.persist.EntityManagerProvider;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.History;

public class HistoryBeanImpl implements HistoryBean {

	@Inject
	private EntityManagerProvider em;
	
	@Override
	@Transactional
	public History add(Activity activity, Date date) {
		History historicalActivity = new History();
		historicalActivity.setActivity(activity);
		historicalActivity.setActivityDate(date);
		em.get().persist(historicalActivity);
		
		return historicalActivity;
	}

}
