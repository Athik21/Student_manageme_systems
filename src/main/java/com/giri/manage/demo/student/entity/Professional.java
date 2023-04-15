package com.giri.manage.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Professional")
public class Professional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="code", nullable=false)
	private String code;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="credit")
	private String credit;
	@Column(name="type",  nullable=false)
	private String type;
	@Column(name="sem")
	private String sem;
	@Column(name="cate")
	private String category;
	@Column(name="year")
	private String year;
	@Column(name="reg")
	private String reg;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public Professional(int id, String code, String name, String credit, String type, String sem, String category, String year, String reg) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.type = type;
		this.sem = sem;
		this.category = category;
		this.year = year;
		this.reg = reg;
	}
	public Professional() {
		
	}
	
}
