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

import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.Group;
import pl.tecna.test.server.GuiceServletConfig.DatabaseModule;

@RunWith(JukitoRunner.class)
@UseModules(DatabaseModule.class)
public class ChildBeanImplTest {

	@Inject
	private ChildBeanImpl childBean;
	
	@Inject
	private GroupBeanImpl groupBean;
	
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
		Group group = groupBean.create("testGroup");
		Child child = childBean.create("testChild", group);
		
		// then
		Assert.assertNotNull(child);
		Assert.assertEquals("testChild", child.getName());
		Assert.assertEquals("testGroup", child.getGroup().getName());
	}
	
	@Test
	public void getChildrenListTest() {
		//when
		Group group = groupBean.create("testGroup");
		Child child = childBean.create("testChild", group);
		List<Child> children = childBean.getChildrenList();
		
		//then
		Assert.assertNotNull(children);
		Assert.assertEquals("testChild", children.get(0).getName());
	}
}
