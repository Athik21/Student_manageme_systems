package com.giri.manage.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cources")
public class Cources {
		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		private int id;
		@Column(name = "name",nullable = false)
		private String name;
		@Column(name="staff", nullable=false)
		private String staff;
		@Column(name="links", nullable=false)
		private String links;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStaff() {
			return staff;
		}
		public void setStaff(String staff) {
			this.staff = staff;
		}
		public String getLinks() {
			return links;
		}
		public void setLinks(String links) {
			this.links = links;
		}
		public Cources(int id, String name, String staff, String links) {
			super();
			this.id = id;
			this.name = name;
			this.staff = staff;
			this.links = links;
		}
		
}
