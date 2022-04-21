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

import com.simplilearn.cls.Classes;
import com.simplilearn.cls.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class List_Classes
 */
@WebServlet("/List-Classes")
public class List_Classes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List_Classes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		List<Classes> classes = session.createQuery("from Classes").list();
		
		out.println("<h1> Classes List :- </h1>");
		out.println("<style> table,td,th { border:2px solid black; border-collapse: collapse;}</style>");
		out.println("<table>");
		out.println("<tr>");
			out.println("<th>Session</th>");
			out.println("<th>Subjects</th>");
			out.println("<th>Student</th>");
			out.println("<th>Teacher</th>");
			
		out.println("</tr>");
		
		for(Classes cls: classes) {
			out.println("<tr>");
				out.println("<td>"+cls.getCid()+"</td>");
				out.println("<td>"+cls.getSubjects()+"</td>");
				out.println("<td>"+cls.getStudent()+"<\td>");
				out.println("<td>"+cls.getTeacher()+"<\td>");
				
			
			out.println("</tr>");
			
		}
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
