package com.giri.manage.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name = "sec_year")
public class SecondYear {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@Column(name="username",unique = true)
	private String uname;
	@Column(name ="passWord")
	private String passw;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	@Column(name="roll", nullable = false)
	private String roll;
	@Column(name="name")
	private String name;
	@Column(name="dob")
	private String dob;
	@Column(name="father")
	private String father;
	@Column(name="mother")
	private String mother;
	@Column(name="par_num")
	private String par_num;
	@Column(name="year")
	private String year;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="aadhar")
	private String aadhar;
	@Column(name="cast")
	private String cast;
	@Column(name="regulation")
	private String regulation;
	@Column(name="sem")
	private String sem;
	@Column(name="address")
	private String address;
	@Column(name="state")
	private String state;
	@Column(name="taluk")
	private String taluk;
	@Column(name="district")
	private String district;
	@Column(name="pincode")
	private String pincode;
	@Column(name="bgrp")
	private String b_grp;
	@Column(name="gender")
	private String gender;
	
	
	
	public SecondYear(int id, String uname, String passw, String image, String roll, String name, String dob,
			String father, String mother, String par_num, String year, String phone, String email, String aadhar,
			String cast, String regulation, String sem, String address, String state, String taluk, String district,
			String pincode, String b_grp, String gender) {
		super();
		this.id = id;
		this.uname = uname;
		this.passw = passw;
		this.image = image;
		this.roll = roll;
		this.name = name;
		this.dob = dob;
		this.father = father;
		this.mother = mother;
		this.par_num = par_num;
		this.year = year;
		this.phone = phone;
		this.email = email;
		this.aadhar = aadhar;
		this.cast = cast;
		this.regulation = regulation;
		this.sem = sem;
		this.address = address;
		this.state = state;
		this.taluk = taluk;
		this.district = district;
		this.pincode = pincode;
		this.b_grp = b_grp;
		this.gender = gender;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getRoll() {
		return roll;
	}



	public void setRoll(String roll) {
		this.roll = roll;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getFather() {
		return father;
	}



	public void setFather(String father) {
		this.father = father;
	}



	public String getMother() {
		return mother;
	}



	public void setMother(String mother) {
		this.mother = mother;
	}



	public String getPar_num() {
		return par_num;
	}



	public void setPar_num(String par_num) {
		this.par_num = par_num;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAadhar() {
		return aadhar;
	}



	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}



	public String getCast() {
		return cast;
	}



	public void setCast(String cast) {
		this.cast = cast;
	}



	public String getRegulation() {
		return regulation;
	}



	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}



	public String getSem() {
		return sem;
	}



	public void setSem(String sem) {
		this.sem = sem;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getTaluk() {
		return taluk;
	}



	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public String getB_grp() {
		return b_grp;
	}



	public void setB_grp(String b_grp) {
		this.b_grp = b_grp;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public SecondYear() {
		
	}
}
