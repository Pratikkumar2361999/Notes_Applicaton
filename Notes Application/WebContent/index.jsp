<%@page import="com.kyu.bean.Note"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kyu.db.DBImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notes</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Coming+Soon&display=swap"
	rel="stylesheet">

<script src="https://unpkg.com/minigrid@3.1.1/dist/minigrid.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src='js/jquery.textareaAutoResize.js'></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css" />



</head>
<body onmouseup="submitForm()" onmousedown="allowClick()">
	<%
	String message = (String) session.getAttribute("message");
	String color = (String) session.getAttribute("color");
	String status = (String) session.getAttribute("status");
	if (message != null && status != null && color != null) {
	%>
	<div class="alert alert-<%=color %>">
		<span class="closebtn closebtn-<%=color %> %>"
			onclick="this.parentElement.style.display='none';">&times;</span> <strong>Success!</strong>
		<%= message %>
	</div>
	<%
	session.setAttribute("message", null);
	session.setAttribute("status", null);
	session.setAttribute("color", null);
	}
	%>
	<h1 style="text-align: center; font-family: 'Coming Soon', cursive;">Notes
		App</h1>

	<div onclick="submitForm()">
		<div class="mainDiv" onmousedown="event.stopImmediatePropagation()"
			onmouseup="event.stopImmediatePropagation()">
			<form id="form" action="InsertNoteServlet">
				<input class="input_title" id="title" type='text' name='title'
					placeholder="Enter Title ..." autocomplete="none"><br>
				<hr>
				<textarea class="input_note" id="des" name='note'
					style="overflow: hidden;" placeholder="Write here........"></textarea>
				<br>
			</form>
		</div>
	</div>


	<%
	ArrayList<Note> list = new DBImpl().getAllNotes();
	if (!list.isEmpty()) {
	%>
	<div class="cards">


		<%
		for (Note note : list) {
		%>
		<div class="card">
			<h4 class="title"><%=note.getTitle()%></h4>
			<div class="note">
				<%
				String[] s = note.getNote().split("\n");
				for (String temp : s) {
					out.print(temp + "<br>");
				}
				%>
			</div>

			<p style="margin: 0px; margin-top: 10px;" align="right">
				<a class="button" href="edit.jsp?sno=<%=note.getSno()%>"><input
					class="edit" type="submit" value=""></a> <a class="button"
					href="DeleteServlet?sno=<%=note.getSno()%>"><input
					class="delete" type="submit" value=""></a>
			</p>

		</div>
		<%
		}
		%>




	</div>
	<div style="height: 100px;"></div>

	<%
	} else {
	out.print("<br><h1>aise aise chutiya log palle pad gye hain kachu dalo hai nae aur dekhwe aa jatae</h1>");
	}
	%>

	<a href="insertnote.jsp"><input class="createAll" type='submit'
		value=""></a>
	<a href=''><input class="deleteAll" type='submit' value=""></a>


</body>
</html>