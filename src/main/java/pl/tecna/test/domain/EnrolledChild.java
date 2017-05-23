package pl.tecna.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EnrolledChild {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Child child;
	
	@ManyToOne
	@JoinColumn
	private Activity activity;

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Long getId() {
		return id;
	}
}
