package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.Group;

import com.google.inject.ImplementedBy;

@ImplementedBy(ChildBeanImpl.class)
public interface ChildBean {

	Child addChild(String name, Group group);
//	Child setGroup(Group group);
	List<Child> getChildren();
	List<Child> getChildrenFromGroup(Group group);
}
