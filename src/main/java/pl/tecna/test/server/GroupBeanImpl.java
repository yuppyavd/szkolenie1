package pl.tecna.test.server;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.onami.persist.EntityManagerProvider;

import pl.tecna.test.domain.Group;

public class GroupBeanImpl implements GroupBean{

	@Inject
	private EntityManagerProvider em;
	
	@Override
	@Transactional
	public Group addGroup(String name) {
		Group newGroup = new Group();
		newGroup.setName(name);
		em.get().persist(newGroup);
		
		return newGroup;
	}

	@Override
	@Transactional
	public List<Group> getGroups() {
		List<Group> groups;
		groups = em.get().createQuery("SELECT gr FROM Group gr", Group.class).getResultList();
		
		return groups;
	}

}
