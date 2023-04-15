package com.giri.manage.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "achievmt")
public class Achievements {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	int id;
	@Column(name = "uname")
	private String uname;
	@Column(name = "des")
	private String desc;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String img;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String image) {
		this.img = image;
	}
	public Achievements(String uname, String desc, String image) {
		super();
		this.uname = uname;
		this.desc = desc;
		this.img = image;
	}
	
	public Achievements() {
		
	}
}
