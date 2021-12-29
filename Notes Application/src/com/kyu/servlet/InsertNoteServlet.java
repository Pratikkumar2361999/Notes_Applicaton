package com.kyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kyu.bean.Note;
import com.kyu.db.DBImpl;


public class InsertNoteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String note = request.getParameter("note");	
//		out.print("Title:-"+title+"<br>Content:<br>");
//		String[] temp = note.split("\n");
//		for (String string : temp) {
//			out.print(string+"<br>");
//		}
		Note noteObj = new Note(title,note);
		boolean b = new DBImpl().insertNotes(noteObj);
		if (b) {
			System.out.println("Note Inserted");
			HttpSession session = request.getSession();
			session.setAttribute("message", "Note Inserted.");
			session.setAttribute("status", "Success");
			session.setAttribute("color", "green");
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("Note Inserted<br>");
//			rd.include(request, response);
//			response.sendRedirect("index.jsp");
		}else {
//			System.out.println("Note not Inserted");
			HttpSession session = request.getSession();
			session.setAttribute("message", "Note not Inserted");
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("Note not Inserted.........<br>");
//			rd.include(request, response);
		}
		response.sendRedirect("index.jsp");
	}

}
