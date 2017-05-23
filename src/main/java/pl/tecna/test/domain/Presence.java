package pl.tecna.test.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Presence {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Child child;
	
	@ManyToOne
	@JoinColumn
	private History historyActivity;
	
	@Column
	private Boolean presence;

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public History getHistoryActivity() {
		return historyActivity;
	}

	public void setHistoryActivity(History historyActivity) {
		this.historyActivity = historyActivity;
	}

	public Boolean getPresence() {
		return presence;
	}

	public void setPresence(Boolean presence) {
		this.presence = presence;
	}

	public Long getId() {
		return id;
	}
	
	
}
