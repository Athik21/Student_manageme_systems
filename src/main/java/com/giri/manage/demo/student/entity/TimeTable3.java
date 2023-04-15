package com.giri.manage.demo.student.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table3")
public class TimeTable3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "days")
	private String days;
	@Column(name = "h1")
	private String hour1;
	@Column(name = "h2")
	private String hour2;
	@Column(name = "h3")
	private String hour3;
	@Column(name = "h4")
	private String hour4;
	@Column(name = "h5")
	private String hour5;
	@Column(name = "h6")
	private String hour6;
	@Column(name = "h7")
	private String hour7;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getHour1() {
		return hour1;
	}

	public void setHour1(String hour1) {
		this.hour1 = hour1;
	}

	public String getHour2() {
		return hour2;
	}

	public void setHour2(String hour2) {
		this.hour2 = hour2;
	}

	public String getHour3() {
		return hour3;
	}

	public void setHour3(String hour3) {
		this.hour3 = hour3;
	}

	public String getHour4() {
		return hour4;
	}

	public void setHour4(String hour4) {
		this.hour4 = hour4;
	}

	public String getHour5() {
		return hour5;
	}

	public void setHour5(String hour5) {
		this.hour5 = hour5;
	}

	public String getHour6() {
		return hour6;
	}

	public void setHour6(String hour6) {
		this.hour6 = hour6;
	}

	public String getHour7() {
		return hour7;
	}

	public void setHour7(String hour7) {
		this.hour7 = hour7;
	}

	public TimeTable3(int id, String days, String hour1, String hour2, String hour3, String hour4, String hour5,
			String hour6, String hour7) {
		super();
		this.id = id;
		this.days = days;
		this.hour1 = hour1;
		this.hour2 = hour2;
		this.hour3 = hour3;
		this.hour4 = hour4;
		this.hour5 = hour5;
		this.hour6 = hour6;
		this.hour7 = hour7;
	}

	@Override
	public String toString() {
		return "TimeTable3 [id=" + id + ", days=" + days + ", hour1=" + hour1 + ", hour2=" + hour2 + ", hour3=" + hour3
				+ ", hour4=" + hour4 + ", hour5=" + hour5 + ", hour6=" + hour6 + ", hour7=" + hour7 + "]";
	}

	public TimeTable3() {

	}
}
