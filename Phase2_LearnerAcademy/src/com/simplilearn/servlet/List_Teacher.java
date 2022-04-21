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
import com.simplilearn.cls.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class List_Teacher
 */
@WebServlet("/List-Teacher")
public class List_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List_Teacher() {
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

		List<Teacher> teacher = session.createQuery("from Teacher").list();

		out.println("<h1> Teacher List:- </h1>");
		out.println("<style>table,td,th {border:2px solid black; border-collapse: collapse;}</style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th> Teacher Id</th>");
		out.println("<th> First Name</th>");
		out.println("<th> Last name</th>");
		out.println("</tr>");

		for (Teacher t : teacher) {
			out.print("<tr>");
			out.println("<td>" + t.getTid() + "</td>");
			out.println("<td>" + t.getFname() + "</td>");
			out.println("<td>" + t.getLname() + "</td>");
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
