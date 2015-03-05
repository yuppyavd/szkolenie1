package pl.tecna.test.server;

import pl.tecna.test.domain.Activity;

import com.google.inject.ImplementedBy;

@ImplementedBy(ActivityBeanImpl.class)
public interface ActivityBean {
	
	Activity create(String name);

}
