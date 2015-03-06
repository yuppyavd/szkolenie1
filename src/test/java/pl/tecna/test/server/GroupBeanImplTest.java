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
public class GroupBeanImplTest {

	@Inject
	private GroupBeanImpl bean;
	
	@Inject
	private ChildBeanImpl childBean;
	
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
		Group group = bean.create("test");
		
		// then
		Assert.assertNotNull(group);
		Assert.assertEquals("test", group.getName());
	}
	
	@Test
	public void getAllGroupsListTest() {
		// when
		Group group = bean.create("test");
		List<Group> groups = bean.getAllGroupsList();
		
		// then
		Assert.assertNotNull(groups);
		Assert.assertEquals("test", groups.get(0).getName());
	}
	
	@Test
	public void getChildrenListFromGroupTest() {
		// when
		Group group = bean.create("test");
		Child child = childBean.create("testChild", group);
		List<Child> children = bean.getChildrenListFromGroup(group);
		
		//then
		Assert.assertNotNull(children);
		Assert.assertEquals("testChild", children.get(0).getName());
	}
}
