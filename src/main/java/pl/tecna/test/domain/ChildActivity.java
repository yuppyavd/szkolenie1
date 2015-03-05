package pl.tecna.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChildActivity {

	@Id
	@GeneratedValue
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="Child_Id")
	private Child Child;
	
	@ManyToOne
	@JoinColumn(name="Activity_Id")
	private Activity Activity;

	public Long getId() {
		return Id;
	}

	public Child getChild() {
		return Child;
	}

	public void setChild(Child child) {
		Child = child;
	}

	public Activity getActivity() {
		return Activity;
	}

	public void setActivity(Activity activity) {
		Activity = activity;
	}
}
