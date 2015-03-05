package pl.tecna.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class History {

	@Id
	@GeneratedValue
	private Long Id;
	
	@ManyToOne
	@JoinColumn
	private Activity Activity;
	
	@Column
	private Date ActivityDate;

	public Activity getActivity() {
		return Activity;
	}

	public void setActivity(Activity activity) {
		Activity = activity;
	}

	public Date getActivityDate() {
		return ActivityDate;
	}

	public void setActivityDate(Date activityDate) {
		ActivityDate = activityDate;
	}

	public Long getId() {
		return Id;
	}
}
