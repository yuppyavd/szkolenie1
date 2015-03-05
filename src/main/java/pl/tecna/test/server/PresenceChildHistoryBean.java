package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.PresenceChildHistory;
import pl.tecna.test.domain.PresenceHistory;

import com.google.inject.ImplementedBy;

@ImplementedBy(PresenceChildHistoryBeanImpl.class)
public interface PresenceChildHistoryBean {
	
	PresenceChildHistory create(Child child, PresenceHistory presenceHistory, Boolean isPresent);
	List<Child> getPresentChildList(Activity activity, Date date);
	List<Child> getAbsentChildList(Activity activity, Date date);

}
