package main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.member;
import main.dao.memberDao;

/**
 * Servlet implementation class adminreg
 */
@WebServlet("/adminreg")
public class adminreg extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        out.println("<h1>Update</h1>");  
		        String sid=request.getParameter("id"); 
		        int id =Integer.parseInt(sid);
		        	request.getRequestDispatcher("navadmin.jsp").include(request, response);
		        member mem=memberDao.viewBy(id);  
		        
		        out.print("<form action='Editadmin' method='post'>");  
		        out.print("<table>");  
		        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+mem.getId()+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+mem.getName()+"'/></td></tr>");  
		        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+mem.getEmail()+"'/></td></tr>");  
		        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+mem.getPassword()+"'/></td></tr>"); 
		        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");  
		          
		        out.close();  
		    }  
		}
