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
	private Long Id;
	
	@ManyToOne
	@JoinColumn
	private Child Child;
	
	@ManyToOne
	@JoinColumn
	private History History;
	
	@Column
	private Boolean Attended;

	public Child getChild() {
		return Child;
	}

	public void setChild(Child child) {
		Child = child;
	}

	public History getHistory() {
		return History;
	}

	public void setHistory(History history) {
		History = history;
	}

	public Boolean getAttended() {
		return Attended;
	}

	public void setAttended(Boolean attended) {
		Attended = attended;
	}

	public Long getId() {
		return Id;
	}
}
