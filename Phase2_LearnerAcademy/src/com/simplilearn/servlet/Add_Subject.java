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

import com.simplilearn.cls.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class Add_Subject
 */
@WebServlet("/Add-Subject")
public class Add_Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Subject.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subname = request.getParameter("subname");
		Subject su = new Subject();
		su.setSubname(subname);
		
		// STEP 1: Get SessionFactory Object
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		// STEp 2: Create session object
		Session session = sf.openSession();
		
		// Step 3: Persist object (using transaction)
		Transaction tx = session.beginTransaction();
				session.save(su);
		tx.commit();
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>"
				+ "Subject successfully saved in DB. Please <a href='List-Subject'>Click here</a> to view all Subject list"
				+ "</body></html>");
		
		session.close();
	}

}
