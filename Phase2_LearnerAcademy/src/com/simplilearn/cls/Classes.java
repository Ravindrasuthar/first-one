package com.simplilearn.cls;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.simplilearn.cls.Subject;


@Entity
@Table(name = "Class")
public class Classes {

	@Id
	@GeneratedValue
	@Column(name = "Section", nullable = false)
	private int cid;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	@OneToMany(targetEntity = Subject.class, cascade = CascadeType.ALL)
	List<Subject> subjects;

	public String getSubjects() {
		StringBuilder sb = new StringBuilder();

		if (this.subjects != null) {
			for (Subject ss : this.subjects) {
				if(ss.getSubname()!=null)
				{
					sb.append(ss.getSubname() + ",");
				}
			}
		}
		return sb.toString();
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL)  
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}  
	
	@OneToOne(targetEntity=Teacher.class,cascade=CascadeType.ALL)  
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	
}

