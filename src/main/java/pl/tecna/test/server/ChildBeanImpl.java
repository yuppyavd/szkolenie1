package pl.tecna.test.server;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.Group;

public class ChildBeanImpl implements ChildBean {

	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public Child create(String name, Group group) {
		Child child = new Child();
		child.setName(name);
		child.setGroup(group);
		em.get().persist(child);
		return child;
	}
}
