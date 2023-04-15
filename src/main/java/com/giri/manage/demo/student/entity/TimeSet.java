package com.giri.manage.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timeho")
public class TimeSet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hour;
	
	@Column(name = "starthour")
	private String starthour;
	@Column(name = "endhour")
	private String endhour;
	@Column(name = "starthour2")
	private String s2;
	@Column(name = "endhour2")
	private String e2;
	@Column(name = "starthour3")
	private String s3;
	@Column(name = "endhour3")
	private String e3;
	@Column(name = "starthour4")
	private String s4;
	@Column(name = "endhour4")
	private String e4;
	@Column(name = "starthour5")
	private String s5;
	@Column(name = "endhour5")
	private String e5;
	@Column(name = "starthour6")
	private String s6;
	@Column(name = "endhour6")
	private String e6;
	@Column(name = "starthour7")
	private String s7;
	@Column(name = "endhour7")
	private String e7;
	@Column(name = "sl")
	private String sl;
	@Column(name = "el")
	private String el;
	
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getEl() {
		return el;
	}
	public void setEl(String el) {
		this.el = el;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public String getStarthour() {
		return starthour;
	}
	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}
	public String getEndhour() {
		return endhour;
	}
	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}
	
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getE2() {
		return e2;
	}
	public void setE2(String e2) {
		this.e2 = e2;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}
	public String getE3() {
		return e3;
	}
	public void setE3(String e3) {
		this.e3 = e3;
	}
	public String getS4() {
		return s4;
	}
	public void setS4(String s4) {
		this.s4 = s4;
	}
	public String getE4() {
		return e4;
	}
	public void setE4(String e4) {
		this.e4 = e4;
	}
	public String getS5() {
		return s5;
	}
	public void setS5(String s5) {
		this.s5 = s5;
	}
	public String getE5() {
		return e5;
	}
	public void setE5(String e5) {
		this.e5 = e5;
	}
	public String getS6() {
		return s6;
	}
	public void setS6(String s6) {
		this.s6 = s6;
	}
	public String getE6() {
		return e6;
	}
	public void setE6(String e6) {
		this.e6 = e6;
	}
	public String getS7() {
		return s7;
	}
	public void setS7(String s7) {
		this.s7 = s7;
	}
	public String getE7() {
		return e7;
	}
	public void setE7(String e7) {
		this.e7 = e7;
	}
	
	public TimeSet(int hour, String starthour, String endhour, String s2, String e2, String s3, String e3, String s4,
			String e4, String s5, String e5, String s6, String e6, String s7, String e7, String sl, String el) {
		super();
		this.hour = hour;
		this.starthour = starthour;
		this.endhour = endhour;
		this.s2 = s2;
		this.e2 = e2;
		this.s3 = s3;
		this.e3 = e3;
		this.s4 = s4;
		this.e4 = e4;
		this.s5 = s5;
		this.e5 = e5;
		this.s6 = s6;
		this.e6 = e6;
		this.s7 = s7;
		this.e7 = e7;
		this.sl = sl;
		this.el = el;
	}
	public TimeSet() {
		
	}
	@Override
	public String toString() {
		return "TimeSet [hour=" + hour + ", starthour=" + starthour + ", endhour=" + endhour + ", s2=" + s2 + ", e2="
				+ e2 + ", s3=" + s3 + ", e3=" + e3 + ", s4=" + s4 + ", e4=" + e4 + ", s5=" + s5 + ", e5=" + e5 + ", s6="
				+ s6 + ", e6=" + e6 + ", s7=" + s7 + ", e7=" + e7 + "]";
	}
	
}
