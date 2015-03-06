package pl.tecna.test.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import pl.tecna.test.domain.PresenceChildHistory;
import pl.tecna.test.domain.PresenceHistory;
import pl.tecna.test.server.GuiceServletConfig.DatabaseModule;

@RunWith(JukitoRunner.class)
@UseModules(DatabaseModule.class)
public class PresenceChildHistoryBeanImplTest {
	
	@Inject
	private PresenceChildHistoryBeanImpl presenceChildHistoryBean;
	
	@Inject
	private PresenceHistoryBeanImpl presenceHistoryBean;
	
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
		String strDate = "05-03-2015";
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Group group = groupBean.create("testGroup");
		Child child1 = childBean.create("testChild1", group);
		Child child2 = childBean.create("testChild2", group);
		Activity activity = activityBean.create("testActivity");
		PresenceHistory presenceHistory = presenceHistoryBean.create(activity, date);
		PresenceChildHistory presenceChildHistory1 = presenceChildHistoryBean.create(child1, presenceHistory, true);
		PresenceChildHistory presenceChildHistory2 = presenceChildHistoryBean.create(child2, presenceHistory, false);
		
		// then
		Assert.assertNotNull(presenceChildHistory1);
		Assert.assertNotNull(presenceChildHistory2);
		Assert.assertEquals("testChild1", presenceChildHistory1.getChild().getName());
		Assert.assertEquals("testChild2", presenceChildHistory2.getChild().getName());
		Assert.assertTrue(presenceChildHistory1.getIsPresent());
		Assert.assertFalse(presenceChildHistory2.getIsPresent());
	}
	
	@Test
	public void getPresentChildListTest() {
		// when
		String strDate = "05-03-2015";
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Group group = groupBean.create("testGroup");
		Child child1 = childBean.create("testChild1", group);
		Child child2 = childBean.create("testChild2", group);
		Activity activity = activityBean.create("testActivity");
		PresenceHistory presenceHistory = presenceHistoryBean.create(activity, date);
		PresenceChildHistory presenceChildHistory = presenceChildHistoryBean.create(child1, presenceHistory, true);
		PresenceChildHistory presenceChildHistory2 = presenceChildHistoryBean.create(child2, presenceHistory, false);
		List<Child> children = presenceChildHistoryBean.getPresentChildList(activity, date);
		
		// then
		Assert.assertNotNull(children);
		Assert.assertEquals("testChild1", children.get(0).getName());
	}
	
	@Test
	public void getAbsentChildListTest() {
		// when
		String strDate = "05-03-2015";
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Group group = groupBean.create("testGroup");
		Child child1 = childBean.create("testChild1", group);
		Child child2 = childBean.create("testChild2", group);
		Activity activity = activityBean.create("testActivity");
		PresenceHistory presenceHistory = presenceHistoryBean.create(activity, date);
		PresenceChildHistory presenceChildHistory = presenceChildHistoryBean.create(child1, presenceHistory, true);
		PresenceChildHistory presenceChildHistory2 = presenceChildHistoryBean.create(child2, presenceHistory, false);
		List<Child> children = presenceChildHistoryBean.getAbsentChildList(activity, date);
		
		// then
		Assert.assertNotNull(children);
		Assert.assertEquals("testChild2", children.get(0).getName());
	}
}
