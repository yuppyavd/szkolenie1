package pl.tecna.test.domain;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ActivityInstance {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="Activity_Id")
	private Activity Activity;
	
	@Column
	private String WeekDay;
	
	@Column
	private Time Hour;

	public Long getId() {
		return Id;
	}

	public Activity getActivity() {
		return Activity;
	}

	public void setActivity(Activity activity) {
		Activity = activity;
	}

	public String getWeekDay() {
		return WeekDay;
	}

	public void setWeekDay(String weekDay) {
		WeekDay = weekDay;
	}

	public Time getHour() {
		return Hour;
	}

	public void setHour(Time hour) {
		Hour = hour;
	}

}
