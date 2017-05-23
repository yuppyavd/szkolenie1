package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.Group;

import com.google.inject.ImplementedBy;

@ImplementedBy(ChildBeanImpl.class)
public interface ChildBean {
	
	Child create(String name, Group group);
	List<Child> getChildrenList();
}
