package pl.tecna.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Presence {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Child child;
	
	@ManyToOne
	@JoinColumn
	private History history;
	
	@Column
	private Boolean attended;

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public Boolean getAttended() {
		return attended;
	}

	public void setAttended(Boolean attended) {
		this.attended = attended;
	}

	public Long getId() {
		return id;
	}
}
