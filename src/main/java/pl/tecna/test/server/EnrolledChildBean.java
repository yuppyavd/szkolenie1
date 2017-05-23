package pl.tecna.test.server;

import java.util.List;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.EnrolledChild;

public interface EnrolledChildBean {

	EnrolledChild enroll(Child child, Activity activity);
	List<Child> getEnrolledList(Activity activity);
}
