package pl.tecna.test.server;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

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

}
