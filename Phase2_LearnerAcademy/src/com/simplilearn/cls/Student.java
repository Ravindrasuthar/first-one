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
@Table(name = "Student_Details")
public class Student {
	   @Id
	   @Column(name = "Student_Id", nullable = false)
	   @GeneratedValue
       private int sid;
	   
	   @Column(name = "Student_First_Name")
	   private String fname;
	   
	   @Column(name = "Gender")
	   private String gender;
	   
	   @Column(name = "Student_Last_Name")
	   private String lname;
	   
	   @Column(name = "Student_Address")
	   private String address;

	   
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return  (fname +" "+ lname) ;
	}
	   
	   
	   
}
