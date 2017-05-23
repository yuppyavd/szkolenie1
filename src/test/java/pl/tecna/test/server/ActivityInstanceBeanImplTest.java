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
import pl.tecna.test.domain.ActivityInstance;
import pl.tecna.test.domain.EnumDay;
import pl.tecna.test.server.GuiceServletConfig.DatabaseModule;

@RunWith(JukitoRunner.class)
@UseModules(DatabaseModule.class)
public class ActivityInstanceBeanImplTest {
	
	@Inject
	private ActivityInstanceBeanImpl bean;
	
	@Inject
	private ActivityBeanImpl beanActivity;
	
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
		//when
		String hour = "18:00";
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = formatter.parse(hour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Activity activity = beanActivity.create("test");
		ActivityInstance activityInstance = bean.create(activity, EnumDay.MONDAY, date);
		
		//then
		Assert.assertNotNull(activityInstance);
		Assert.assertEquals("test", activityInstance.getActivity().getName());
	}
	
	@Test
	public void getActivitiesListFromDayTest() {
		//when
		String hour = "18:00";
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = formatter.parse(hour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Activity activity = beanActivity.create("test");
		ActivityInstance activityInstance = bean.create(activity, EnumDay.MONDAY, date);
		List<Activity> activities = bean.getActivitiesListFromDay(EnumDay.MONDAY);
		
		//then
		Assert.assertNotNull(activities);
		Assert.assertEquals("test", activities.get(0).getName());
		
	}

}
