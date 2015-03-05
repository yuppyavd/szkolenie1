package pl.tecna.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Presence {

	@Id
	@GeneratedValue
	private Long Id;
	
	@ManyToOne
	private Child Child;
	
	@ManyToOne
	private Activity Activity;
}
