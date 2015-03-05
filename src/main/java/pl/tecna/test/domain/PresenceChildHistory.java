package pl.tecna.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PresenceChildHistory {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column
	private Child Child_Id;
	
	@ManyToOne
	@JoinColumn(name="PresenceHistory_Id")
	private PresenceHistory PresenceHistory_Id;

	public Long getId() {
		return Id;
	}

	public Child getChild_Id() {
		return Child_Id;
	}

	public void setChild_Id(Child child_Id) {
		Child_Id = child_Id;
	}

	public PresenceHistory getPresenceHistory_Id() {
		return PresenceHistory_Id;
	}

	public void setPresenceHistory_Id(PresenceHistory presenceHistory_Id) {
		PresenceHistory_Id = presenceHistory_Id;
	}

}
