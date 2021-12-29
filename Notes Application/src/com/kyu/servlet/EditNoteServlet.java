package com.kyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyu.bean.Note;
import com.kyu.db.DBImpl;


public class EditNoteServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int sno = Integer.parseInt(request.getParameter("sno"));
		String title = request.getParameter("title");
		String note = request.getParameter("note");
		Note noteObj = new Note(title, note);
		noteObj.setSno(sno);

		boolean status = new DBImpl().updateNote(noteObj);
		if (status) {
			System.out.println("Note Updated");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("Note Updated<br>");
			rd.include(request, response);
		} else {
			System.out.println("Note not Updated");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("Note not Updated.........<br>");
			rd.include(request, response);
		}
		
		
		
		
	}

}
