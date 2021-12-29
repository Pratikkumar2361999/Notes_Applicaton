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
<link href="https://fonts.googleapis.com/css2?family=Coming+Soon&display=swap" rel="stylesheet">

<script src="https://unpkg.com/minigrid@3.1.1/dist/minigrid.min.js"></script>



 <style>
	 @font-face{
			font-family: "whateverbold";
			src: url(fonts/whatever\ it\ takes\ bold.ttf);
	}
	.cards{
		margin-left: auto;
		margin-right: auto;
		max-width:90%;
	}

    .card{
      border: 1px solid #E0E0E0;
      height: fit-content;
      width: 200px;
      border-radius: 10px;
      margin-right:auto;
      margin-left:auto;
      max-height: 400px;
      
    }
    .card:hover{
		box-shadow:0 0 8px #dfd9d9;
    }  
    .title{
      padding-left: 10px;
      padding-right: 10px;
      font-family: 'Coming Soon', cursive;

    }

    .note{
      padding-left: 10px;
      padding-right: 10px;
      font-family: 'Coming Soon', cursive;
      overflow:auto;
      max-height:267px;
    }
    .edit{
      border-radius: 30px;
		position: static;
		height: 30px;
		width: 30px;
		/* align-items: baseline; */
		background-image: url(images/edit-icon1.png);
		background-size: cover;
  
    }
    .delete{
      border-radius: 30px;
		position: static;
		height: 30px;
		width: 30px;
		/* align-items: baseline; */
		background-image: url(images/deleteicon1.png);
		background-size: cover;
    margin-right: 5px;
    }
    
    .createAll{
      border-radius: 30px;
		position: fixed;
		height: 50px;
		width: 50px;
		/* align-items: baseline; */
		background-image: url(images/deleteicon1.png);
		background-size: cover;
    margin-right: 5px;
    bottom: 50px;
    right: 115px;
    transform: rotate(135deg);
    }

    .deleteAll{
      border-radius: 30px;
		position: fixed;
		height: 50px;
		width: 50px;
		/* align-items: baseline; */
		background-image: url(images/deleteicon1.png);
		background-size: cover;
    margin-right: 5px;
    bottom: 50px;
    right: 50px;
    }
    
    .edit:focus{
    	outline: none;
    }
    .delete:focus{
    	outline: none;
    }
    .createAll:focus{
    	outline: none;
    }
    .deleteAll:focus{
    	outline: none;
    }
    
      </style>
      
<style>
/* width */
.note::-webkit-scrollbar {
  width: 2px;
 
}

/* Track */
.note::-webkit-scrollbar-track {
  background: #f1f1f1; 
  
}
 
/* Handle */
.note::-webkit-scrollbar-thumb {
  background: #888;
  border-radius: 8px; 
  
}



/* width */
::-webkit-scrollbar {
  width: 7px; 
}

/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f1;
  background-color: transparent; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #888;
  border-radius: 8px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #555;
}

</style>
<script>
    
(function(){
  var grid;
  function init() {
    grid = new Minigrid({
      container: '.cards',
      item: '.card',
      gutter: 12
    });
    grid.mount();
  }
  
  // mount
  function update() {
    grid.mount();
  }

  document.addEventListener('DOMContentLoaded', init);
  window.addEventListener('resize', update);
})();
  </script>



</head>
<body>

<h1 style="text-align:center; font-family: 'Coming Soon', cursive; ">Notes App</h1>



	<%
			ArrayList<Note> list = new DBImpl().getAllNotes();
			if(!list.isEmpty()){
	%>
	<div class="cards">
    
    
    <%
			for(Note note:list){
			%>
				<div class="card">
				<h4 class="title"><%= note.getTitle() %></h4>
			<div class="note">
			<%  String[] s =note.getNote().split("\n");
					for(String temp : s){
						out.print(temp+"<br>");
					}
			
			%>
			</div>
				
				<p style="margin:0px;margin-top: 10px;" align="right">
				<a class="button" href="edit.jsp?sno=<%= note.getSno()%>"><input class="edit" type="submit" value=""></a>
				<a class="button" href="DeleteServlet?sno=<%= note.getSno()%>"><input class="delete" type="submit" value=""></a>
				</p>
						
			 </div>
			<%	
			}
			%>
    
   
    
    
  </div>
			
			
			<%}else{
					out.print("<br><h1>aise aise chutiya log palle pad gye hain kachu dalo hai nae aur dekhwe aa jatae</h1>");	
			}%>
			
			<a href="insertnote.jsp"><input class="createAll" type='submit' value=""></a>
			<a href=''><input class="deleteAll" type='submit' value=""></a>
		
	
</body>
</html>