package pl.tecna.test.server;

import java.util.List;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.Group;

public class GroupBeanImpl implements GroupBean {

	@Inject
	private EntityManagerProvider em;
	
	@Override
	@Transactional
	public Group create(String name) {
		Group group = new Group();
		group.setName(name);
		em.get().persist(group);
		return group;
	}

	@Override
	@Transactional
	public List<Group> getAllGroupsList() {
		List<Group> groups = em.get().createQuery("FROM Group", Group.class).getResultList();
		return groups;
	}

	@Override
	@Transactional
	public List<Child> getChildrenListFromGroup(Group group) {
		List<Child> children = em.get().createQuery("SELECT c FROM Child c WHERE Group=:group", Child.class)
				.setParameter("group", group.getId()).getResultList();
		return children;
	}

}
