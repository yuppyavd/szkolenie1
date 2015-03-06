package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Group;

import com.google.inject.ImplementedBy;

@ImplementedBy(GroupBeanImpl.class)
public interface GroupBean {

	Group addGroup(String name);
	List<Group> getGroups();
}
