package pl.tecna.test.server;

import java.util.Date;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.ActivityInstance;
import pl.tecna.test.domain.EnumDay;

import com.google.inject.ImplementedBy;

@ImplementedBy(ActivityInstanceBeanImpl.class)
public interface ActivityInstanceBean {
	
	ActivityInstance create(Activity activity, EnumDay day, Date hour);

}
