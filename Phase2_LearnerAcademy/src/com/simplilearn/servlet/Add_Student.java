package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.simplilearn.cls.*;

import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Add-Student")
public class Add_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Student.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		Student s = new Student();
		s.setFname(fname);
		s.setLname(lname);
		s.setAddress(address);
		s.setGender(gender);
		// STEP 1: Get SessionFactory Object
				SessionFactory sf = HibernateUtil.buildSessionFactory();
				
				// STEp 2: Create session object
				Session session = sf.openSession();
				
				// Step 3: Persist object (using transaction)
				Transaction tx = session.beginTransaction();
						session.save(s);
				tx.commit();
				
				PrintWriter pw = response.getWriter();
				pw.println("<html><body>"
						+ "Student successfully saved in DB. Please <a href='List-Student'>Click here</a> to view all Student list"
						+ "</body></html>");
				
				session.close();
		
	}

}
