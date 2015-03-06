package pl.tecna.test.server;

import java.util.List;

import javax.inject.Inject;

import org.apache.onami.persist.PersistenceService;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.ChildActivity;
import pl.tecna.test.domain.Group;
import pl.tecna.test.server.GuiceServletConfig.DatabaseModule;

@RunWith(JukitoRunner.class)
@UseModules(DatabaseModule.class)
public class ChildActivityBeanImplTest {
	
	@Inject
	private ChildActivityBeanImpl bean;
	
	@Inject
	private ChildBeanImpl childBean;
	
	@Inject
	private GroupBeanImpl groupBean;
	
	@Inject
	private ActivityBeanImpl activityBean;
	
	@Inject
	private PersistenceService persistanceService;
	
	@Before
	public void setUp() {
		persistanceService.start();
	}
	
	@After
	public void tearDown() {
		persistanceService.stop();
	}
	
	@Test
	public void createTest() {
		// when
		Group group = groupBean.create("testGroup");
		Child child = childBean.create("testChild", group);
		Activity activity = activityBean.create("testActivity");
		ChildActivity childActivity = bean.create(child, activity);
		
		// then
		Assert.assertNotNull(childActivity);
		Assert.assertEquals("testActivity", childActivity.getActivity().getName());
	}
	
	@Test
	public void getChildrenListInActivityTest() {
		// when
		Group group = groupBean.create("testGroup");
		Child child = childBean.create("testChild", group);
		Activity activity = activityBean.create("testActivity");
		ChildActivity childActivity = bean.create(child, activity);
		List<Child> children = bean.getChildrenListInActivity(activity);
		
		// then
		Assert.assertNotNull(children);
		Assert.assertEquals("testChild", children.get(0).getName());
	}

}
