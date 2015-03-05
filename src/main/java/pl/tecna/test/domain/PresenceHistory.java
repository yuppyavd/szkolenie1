package pl.tecna.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PresenceHistory {

	@Id
	@GeneratedValue
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="Child_Id")
	private Child Child;
	
	@ManyToOne
	@JoinColumn(name="Activity_Id")
	private Activity Activity;
	
	@Column
	private Date PresenceDate;

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

	public Date getPresenceDate() {
		return PresenceDate;
	}

	public void setPresenceDate(Date presenceDate) {
		PresenceDate = presenceDate;
	}
}
