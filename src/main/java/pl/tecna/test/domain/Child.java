package pl.tecna.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column
	private String Name;
	
	@ManyToOne
	@JoinColumn(name="Group")
	private Group Group;

	public Long getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Group getGroup() {
		return Group;
	}

	public void setGroup(Group group) {
		Group = group;
	}
	
}
