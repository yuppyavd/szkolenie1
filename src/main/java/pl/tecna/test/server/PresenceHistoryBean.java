package pl.tecna.test.server;

import java.util.Date;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.PresenceHistory;

import com.google.inject.ImplementedBy;

@ImplementedBy(PresenceHistoryBeanImpl.class)
public interface PresenceHistoryBean {
	
	PresenceHistory create(Activity activity, Date date);

}
