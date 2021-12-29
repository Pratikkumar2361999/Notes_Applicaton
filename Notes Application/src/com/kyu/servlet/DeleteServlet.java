package com.kyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kyu.db.DBImpl;


public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int sno = Integer.parseInt(request.getParameter("sno"));
		boolean status = new DBImpl().deleteNoteBySno(sno);
		if (status) {
			System.out.println("Note Deleted");
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			out.println("Note Deleted<br>");
//			rd.include(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("message", "Note Deleted.");
			session.setAttribute("status", "Success");
			session.setAttribute("color", "red");
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("Note not Deleted");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("Note not Deleted.........<br>");
			rd.include(request, response);
		}
		
	}

}
