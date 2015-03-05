package pl.tecna.test.domain;

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
	private Activity Activity;
}
