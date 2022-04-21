package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.cls.Classes;
import com.simplilearn.cls.Student;
import com.simplilearn.cls.Subject;
import com.simplilearn.cls.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class Add_Class
 */
@WebServlet("/Add-Class")
public class Add_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Class() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Class.html").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Classes c = populateClasses(request);

		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();

		PrintWriter out = response.getWriter();
		out.println(
				"<html><body>Records successfully inserted in DB. <a href='List-Classes'>Click Here</a> to view Classes report</body></html>");
	}

	private Classes populateClasses(HttpServletRequest request) {

		String subject1 = request.getParameter("subject1");
		String subject2 = request.getParameter("subject2");
		String subject3 = request.getParameter("subject3");
		String subject4 = request.getParameter("subject4");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tfname = request.getParameter("tfname");
		String tlname = request.getParameter("tlname");
        
		Classes c = new Classes();
		

		// Populate Subjects
		List<Subject> subjects = new ArrayList<Subject>();

		Subject s1 = new Subject();
		s1.setSubname(subject1);
		s1.setClasses(c);
        
		Subject s2 = new Subject();
		s2.setSubname(subject2);
		s2.setClasses(c);

		Subject s3 = new Subject();
		s3.setSubname(subject3);
		s3.setClasses(c);
		
		Subject s4 = new Subject();
		s4.setSubname(subject4);
		s4.setClasses(c);

		subjects.add(s1);
		subjects.add(s2);
		subjects.add(s3);
		subjects.add(s4);
		c.setSubjects(subjects);
		
		 
		     //populate student   
		    Student student1=new Student();    
		    student1.setFname(fname);    
		    student1.setLname(lname);
		    student1.setGender(gender);
		    student1.setAddress(address);       
		        
		    c.setStudent(student1);    
		    student1.setClasses(c);    
		        

		     //populate Teacher  
		    Teacher teacher1=new Teacher();    
		    teacher1.setFname(tfname);    
		    teacher1.setLname(tlname);      
		        
		    c.setTeacher(teacher1);    
		    teacher1.setClasses(c);    
		        
		
		
		return c;
	}



	}


