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
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="child")
	private Child child;
	
	@ManyToOne
	@JoinColumn(name="presenceHistory")
	private PresenceHistory presenceHistory;
	
	@Column
	private Boolean isPresent;

	public Long getId() {
		return id;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public PresenceHistory getPresenceHistory() {
		return presenceHistory;
	}

	public void setPresenceHistory(PresenceHistory presenceHistory) {
		this.presenceHistory = presenceHistory;
	}

	public Boolean getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(Boolean isPresent) {
		this.isPresent = isPresent;
	}

}
