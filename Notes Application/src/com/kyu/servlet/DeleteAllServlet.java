package com.kyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyu.db.DBImpl;


public class DeleteAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean status  = new DBImpl().deleteAllNote();
		if (status) {
			System.out.println("All Notes Deleted");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("All Notes Deleted<br>");
			rd.include(request, response);
		} else {
			System.out.println("Problem in Deletion");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("Problem in Deletion.........<br>");
			rd.include(request, response);
		}
		
	}


}
