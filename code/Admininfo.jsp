<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="main.dao.DB" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body > table{
    width: 100%;
}

table{
    border-collapse: collapse;
    text-align: center;
}
table.list{
    width:100%;
    text-align: center;
}
table.list td{
    text-align: center;
}
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
tr:nth-child(even),table.list thead>tr {
    background-color: orange;
}
input[type=text], input[type=number] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=submit]{
    width: 30%;
    background-color: #ddd;
    color: #000;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
form{
    background-color: #D6AB81;
    padding: 10px;

}
form div.form-action-buttons{
    text-align: center;

}
a{
    cursor: pointer;
    text-decoration: underline;
    color: #0000ee;
    margin-right: 4px;
}
label.validation-error{
    color:   red;
    margin-left: 5px;
}
.hide{
    display:none;
}  
body   
{  
height: 125vh;  
margin-top: 80px;  
padding: 30px;  
background-size: cover;  
font-family: sans-serif;  
}  
abody {  
background-color: orange;  
position: fixed;  
left: 0;  
right: 0;  
top: 5px;  
height: 30px;  
display: flex;  
align-items: center;  
box-shadow: 0 0 25px 0 black;  
}  
abody * {  
display: inline;  
}  
abody li {  
margin: 20px;  
}  
abody li a {  
color: blue;  
text-decoration: none;  
}    
</style>
<body>
<%@page import="java.sql.*" %>
<%
try
{  
	String email =(String)request.getAttribute("data");
	Connection con =DB.getCon();
    Statement st=con.createStatement();
	ResultSet  rs=st.executeQuery("select *from admin where email='"+email+"'");
	if(rs.next()){
		
%>
<table style="width:30%">
 <h1>My Profile</h1>
  <tr>
    <td>ID</td>
    <td><%=rs.getString(1)%></td>
  </tr>
   <tr>
   <td>Name</td>
   <td><%=rs.getString(2)%></td>
  </tr>
   <tr>
   <td>Email ID</td>
    <td><%=rs.getString(3)%></td>
  </tr>
   <tr>
   <td>password</td>
    <td><%=rs.getString(4)%></td>
  </tr>
  </table>
  <% String s=rs.getString(1);
       int c=Integer.parseInt(s);
       session.setAttribute("userId",c);
     }
   rs.close();
   rs = null;}
	catch(Exception b)
	{
	}%>
<abody>
<nav>  
<ul>     <li><a href="adminreg?id=${userId}">Edit</a></li>
        <li><a href="AddmemberForm">Add Member</a></li>
        <li><a href="Viewmember">View Member</a></li>
        <li><a href="AddBookForm">Add Book</a></li>
        <li><a href="ViewBook">View Book</a></li>
         <li><a href="ViewIssuedBook?id="0>View Issued Book</a></li>
        <li><a href="ViewReserveBooks">Reserve Book</a></li>
        <li><a href="LogoutAdmin">Logout</a></li>
</ul>  
</nav>  
</abody>
</body>
</html>