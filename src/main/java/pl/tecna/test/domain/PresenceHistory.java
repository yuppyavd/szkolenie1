package pl.tecna.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PresenceHistory {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name="activity")
	private Activity activity;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date presenceDate;
	
	public Long getId() {
		return id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Date getPresenceDate() {
		return presenceDate;
	}

	public void setPresenceDate(Date presenceDate) {
		this.presenceDate = presenceDate;
	}
}
