package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.cls.Student;
import com.simplilearn.cls.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class List_Subject
 */
@WebServlet("/List-Subject")
public class List_Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List_Subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		// STEP 1: collect records from DB.

		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		List<Subject> subject = session.createQuery("from Subject").list();

		out.println("<h1> Subject List:- </h1>");
		out.println("<style>table,td,th {border:2px solid black; border-collapse: collapse;}</style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th> Subject Id</th>");
		out.println("<th> Subject Name</th>");
		out.println("</tr>");

		for (Subject su : subject) {
			out.print("<tr>");
			out.println("<td>" + su.getSubid() + "</td>");
			out.println("<td>" + su.getSubname() + "</td>");
			out.print("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		session.close();
		out.println("<a href='Logout'>Logout</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
