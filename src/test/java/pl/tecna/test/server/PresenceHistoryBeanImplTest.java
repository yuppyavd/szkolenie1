package pl.tecna.test.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import pl.tecna.test.domain.PresenceHistory;
import pl.tecna.test.server.GuiceServletConfig.DatabaseModule;

@RunWith(JukitoRunner.class)
@UseModules(DatabaseModule.class)
public class PresenceHistoryBeanImplTest {
	
	@Inject
	private PresenceHistoryBeanImpl bean;
	
	@Inject
	private ActivityBeanImpl activityBean;
	
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
		//when
		String strDate = "05-03-2015";
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Activity activity = activityBean.create("testAct");
		PresenceHistory ph = bean.create(activity, date);
		
		//then
		Assert.assertNotNull(ph);
		Assert.assertEquals("testAct", ph.getActivity().getName());
	}

}
