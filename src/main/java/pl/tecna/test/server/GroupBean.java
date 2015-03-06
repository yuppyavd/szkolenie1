package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.Group;

import com.google.inject.ImplementedBy;

@ImplementedBy(UserBeanImpl.class)
public interface GroupBean {

	Group create(String name);
	List<Group> getAllGroupsList();
	List<Child> getChildrenListFromGroup(Group group);
}
