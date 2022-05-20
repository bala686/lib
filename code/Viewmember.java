package main.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.member;
import main.dao.memberDao;
@WebServlet("/Viewmember")
public class Viewmember extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View member</title>");
	
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		request.getRequestDispatcher("msearch.jsp").include(request, response);
		out.println("<div class='container'>");
		List<member> list=memberDao.view();
		out.println("<center><h1>Member List List</h1></center>");
		
		out.println("<table border='1' width='80%'\">");
		out.println("<tr><th>id</th><th>Name</th><th>Email</th><th>Password</th><th>Membership</th><th>Edit</th><th>Delete</th></tr>");
		for(member mem:list){
			out.println("<tr><td>"+mem.getId()+"</td><td>"+mem.getName()+"</td><td>"+mem.getEmail()+"</td><td>"+mem.getPassword()+"</td><td>"+mem.getMembership()+"</td><td><a href='EditmemberForm?id="+mem.getId()+"'>Edit</a></td><td><a href='Deletemember?id="+mem.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
		
	}
}
