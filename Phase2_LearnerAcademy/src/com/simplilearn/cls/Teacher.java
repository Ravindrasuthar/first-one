package com.simplilearn.cls;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Detail")
public class Teacher {
	@Id
	@GeneratedValue
	@Column(name = "Teacher_Id",nullable = false ) 
	private int tid;
	
	@Column(name = "First_Name")
	private String fname;
	
	@Column(name = "Last_Name")
	private String lname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@OneToOne(targetEntity=Classes.class)  
	private Classes classes;

	
	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return  (fname +" "+ lname);
	}
	

}
