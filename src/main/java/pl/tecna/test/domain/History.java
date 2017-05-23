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
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Activity activity;
	
	@Column
	private Date activityDate;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Long getId() {
		return id;
	}
}
