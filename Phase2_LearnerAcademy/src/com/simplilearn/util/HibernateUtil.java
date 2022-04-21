package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.cls.Classes;
import com.simplilearn.cls.Student;
import com.simplilearn.cls.Subject;
import com.simplilearn.cls.Teacher;

public class HibernateUtil {

	static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(Subject.class).addAnnotatedClass(Classes.class).buildSessionFactory();
		return sessionFactory;
	}
}

