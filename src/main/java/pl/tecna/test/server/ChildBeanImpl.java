package pl.tecna.test.server;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.onami.persist.EntityManagerProvider;

import pl.tecna.test.domain.Child;
import pl.tecna.test.domain.Group;

public class ChildBeanImpl implements ChildBean {

	@Inject
	private EntityManagerProvider em;
	
	@Override
	@Transactional
	public Child addChild(String name, Group group) {
		Child newChild = new Child();
		newChild.setName(name);
		newChild.setGroup(group);
		em.get().persist(newChild);
		
		return newChild;
	}

	@Override
	@Transactional
	public List<Child> getChildren() {
		List<Child> children;
		children = em.get().createQuery("SELECT ch FROM Child ch", Child.class).getResultList();
		
		return children;
	}

	@Override
	@Transactional
	public List<Child> getChildrenFromGroup(Group group) {
		List<Child> children;
		children = em.get().createQuery("SELECT ch FROM Child ch WHERE ch.group = ?1", Child.class).setParameter(1, group.getId()).getResultList();
		
		return children;
	}

//	@Override
//	@Transactional
//	public Child setGroup(Group group) {
//		
//		return null;
//	}

}
