package com.simplilearn.cls;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.simplilearn.cls.Classes;

@Entity
@Table(name = "Subject_Details")
public class Subject {
	
	@Id
	@GeneratedValue
	@Column(name = "Subject_Id",nullable = false)
	private int subid;
	
	@Column(name = "Subject_Name")
	private String subname;

	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	
	private Classes classes;
	
	

	
	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}
	

	public Classes getClasses() {
		return classes;
	}


	public void setClasses(Classes classes) {
		this.classes = classes;
	}


	@Override
	public String toString() {
		return "Subject [subname=" + subname + "]";
	}


	
	
}
