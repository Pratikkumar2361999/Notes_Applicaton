<%@page import="com.kyu.bean.Note"%>
<%@page import="com.kyu.db.DBImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="css/editpage.css">
<meta charset="ISO-8859-1">


<title>Edit</title>
</head>
<body>
<%
int sno = Integer.parseInt(request.getParameter("sno"));
Note note = new DBImpl().getNoteBySno(sno);
%>

<div class="mainDiv">
<form action="EditNoteServlet">
	<input  type='hidden' name='sno' value='<%= note.getSno()%>'>
	<input class="input_title" type='text' name='title' value='<%= note.getTitle() %>' placeholder="Enter Title ..."><br>
	<hr>
	<textarea class="input_note" name='note' rows="30" cols="70"  placeholder="Write here........"><%= note.getNote()%></textarea><br>
	<p align="right" style="padding:unset;"><input class="submit_button" type="submit" value=""></p>
</form>
</div>


</body>
</html>