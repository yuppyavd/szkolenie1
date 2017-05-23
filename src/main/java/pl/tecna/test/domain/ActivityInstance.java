package pl.tecna.test.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ActivityInstance {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Activity activity;
	
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	@Column
	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOfWeek;
	
	@Column
	@Temporal(TemporalType.TIME)
	private Date hour;

	public Long getId() {
		return id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	
}
