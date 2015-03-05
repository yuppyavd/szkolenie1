package pl.tecna.test.server;

import pl.tecna.test.domain.Group;

import com.google.inject.ImplementedBy;

@ImplementedBy(UserBeanImpl.class)
public interface GroupBean {

	Group create(String name);
}
