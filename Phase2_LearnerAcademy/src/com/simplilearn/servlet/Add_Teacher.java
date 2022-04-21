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

import com.simplilearn.cls.Student;
import com.simplilearn.cls.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class Add_Teacher
 */
@WebServlet("/Add-Teacher")
public class Add_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Teacher.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		Teacher t = new Teacher();
		t.setFname(fname);
		t.setLname(lname);
		
		
		// STEP 1: Get SessionFactory Object
				SessionFactory sf = HibernateUtil.buildSessionFactory();
				
				// STEp 2: Create session object
				Session session = sf.openSession();
				
				// Step 3: Persist object (using transaction)
				Transaction tx = session.beginTransaction();
						session.save(t);
				tx.commit();
				
				PrintWriter pw = response.getWriter();
				pw.println("<html><body>"
						+ "Teacher successfully saved in DB. Please <a href='List-Teacher'>Click here</a> to view all Teacher list"
						+ "</body></html>");
				
				session.close();
	}

}
