package com.giri.manage.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="teach_det")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@Column(name ="tecid")
	private String tecid;
	@Column(name="username",unique = true)
	private String uname;
	@Column(name ="passWord")
	private String passw;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	@Column(name="dob",nullable =false)
	private String dob;
	@Column(name="disignation",nullable =false)
	private String disignation;
	@Column(name="email")
	private String email;
	@Column(name="experience")
	private int experience;
	@Column(name="name")
	private String name;
	@Column(name="phone")
	private long phone;
	@Column(name="sub1")
	private String sub1;
	@Column(name="sub11")
	private String sub11;
	@Column(name="sub2")
	private String sub2;
	@Column(name="sub22")
	private String sub22;
	@Column(name="sub3")
	private String sub3;
	@Column(name="sub33")
	private String sub33;
	

	@Column(name="subi21")
	private String subi21;
	@Column(name="subi22")
	private String subi22;
	@Column(name="subi23")
	private String subi23;
	@Column(name="subi31")
	private String subi31;
	@Column(name="subi32")
	private String subi32;
	@Column(name="subi33")
	private String subi33;
	@Column(name="subi41")
	private String subi41;
	@Column(name="subi42")
	private String subi42;
	@Column(name="subi43")
	private String subi43;
	@Column(name="rolls")
	private String roll;
	
	
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getSubi21() {
		return subi21;
	}
	public void setSubi21(String subi21) {
		this.subi21 = subi21;
	}
	public String getSubi22() {
		return subi22;
	}
	public void setSubi22(String subi22) {
		this.subi22 = subi22;
	}
	public String getSubi23() {
		return subi23;
	}
	public void setSubi23(String subi23) {
		this.subi23 = subi23;
	}
	public String getSubi31() {
		return subi31;
	}
	public void setSubi31(String subi31) {
		this.subi31 = subi31;
	}
	public String getSubi32() {
		return subi32;
	}
	public void setSubi32(String subi32) {
		this.subi32 = subi32;
	}
	public String getSubi33() {
		return subi33;
	}
	public void setSubi33(String subi33) {
		this.subi33 = subi33;
	}
	public String getSubi41() {
		return subi41;
	}
	public void setSubi41(String subi41) {
		this.subi41 = subi41;
	}
	public String getSubi42() {
		return subi42;
	}
	public void setSubi42(String subi42) {
		this.subi42 = subi42;
	}
	public String getSubi43() {
		return subi43;
	}
	public void setSubi43(String subi43) {
		this.subi43 = subi43;
	}
	public String getSub11() {
		return sub11;
	}
	public void setSub11(String sub11) {
		this.sub11 = sub11;
	}
	public String getSub22() {
		return sub22;
	}
	public void setSub22(String sub22) {
		this.sub22 = sub22;
	}
	public String getSub33() {
		return sub33;
	}
	public void setSub33(String sub33) {
		this.sub33 = sub33;
	}
	public String getTecid() {
		return tecid;
	}
	public void setTecid(String tecid) {
		this.tecid = tecid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDisignation() {
		return disignation;
	}
	public void setDisignation(String disignation) {
		this.disignation = disignation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getSub1() {
		return sub1;
	}
	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	public String getSub2() {
		return sub2;
	}
	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	public String getSub3() {
		return sub3;
	}
	public void setSub3(String sub3) {
		this.sub3 = sub3;
	}
	
	
	public Teachers(int id, String tecid, String uname, String passw, String image, String dob, String disignation,
			String email, int experience, String name, long phone, String sub1, String sub11, String sub2, String sub22,
			String sub3, String sub33, String subi21, String subi22, String subi23, String subi31, String subi32,
			String subi33, String subi41, String subi42, String subi43, String roll) {
		super();
		this.id = id;
		this.tecid = tecid;
		this.uname = uname;
		this.passw = passw;
		this.image = image;
		this.dob = dob;
		this.disignation = disignation;
		this.email = email;
		this.experience = experience;
		this.name = name;
		this.phone = phone;
		this.sub1 = sub1;
		this.sub11 = sub11;
		this.sub2 = sub2;
		this.sub22 = sub22;
		this.sub3 = sub3;
		this.sub33 = sub33;
		this.subi21 = subi21;
		this.subi22 = subi22;
		this.subi23 = subi23;
		this.subi31 = subi31;
		this.subi32 = subi32;
		this.subi33 = subi33;
		this.subi41 = subi41;
		this.subi42 = subi42;
		this.subi43 = subi43;
		this.roll = roll;
	}
	public Teachers(){
		
	}

}
