package pl.tecna.test.domain;

import java.sql.Time;
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
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="Activity_Id")
	private Activity Activity;
	
	@Column
	@Enumerated(EnumType.STRING)
	private enumDay WeekDay;
	
	@Column
	@Temporal(TemporalType.TIME)
	private Date Hour;

	public Long getId() {
		return Id;
	}

	public Activity getActivity() {
		return Activity;
	}

	public void setActivity(Activity activity) {
		Activity = activity;
	}

	public enumDay getWeekDay() {
		return WeekDay;
	}

	public void setWeekDay(enumDay weekDay) {
		WeekDay = weekDay;
	}

	public Date getHour() {
		return Hour;
	}

	public void setHour(Date hour) {
		Hour = hour;
	}

}
