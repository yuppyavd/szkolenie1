package pl.tecna.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {

	@Id
	@GeneratedValue
	private Long Id;
	
	@Column
	private String Name;
	
	public Long getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
