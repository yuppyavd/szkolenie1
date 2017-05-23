package pl.tecna.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Child {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="\"Group\"")
	private Group group;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
