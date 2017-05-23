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
import pl.tecna.test.server.GuiceServletConfig.DatabaseModule;

@RunWith(JukitoRunner.class)
@UseModules(DatabaseModule.class)
public class ActivityBeanImplTest {

	@Inject
	private ActivityBeanImpl bean;
	
	@Inject
	private PersistenceService persistenceService;
	
	@Before
	public void setUp() {
		persistenceService.start();
	}
	
	@After
	public void tearDown() {
		persistenceService.stop();
	}

	@Test
	public void createTest() {
		// when
		Activity act = bean.create("test");
		
		// then
		Assert.assertNotNull(act);
		Assert.assertEquals("test", act.getName());
	}
	
	@Test
	public void getAllActivitiesListTest() {
		// when
		Activity act = bean.create("test");
		List<Activity> actList = bean.getAllActivitiesList();
		
		//then
		Assert.assertNotNull(actList);
		Assert.assertEquals("test", actList.get(0).getName());
	}
}
