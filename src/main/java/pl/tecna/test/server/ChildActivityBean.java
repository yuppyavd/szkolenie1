package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.ChildActivity;

import com.google.inject.ImplementedBy;

@ImplementedBy(ChildActivityBeanImpl.class)
public interface ChildActivityBean {
	
	ChildActivity create(Child child, Activity activity);
	List<Child> getChildrenListInActivity(Activity activity);

}
