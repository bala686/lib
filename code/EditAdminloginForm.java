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
 * Servlet implementation class EditAdminloginForm
 */
@WebServlet("/EditAdminloginForm")
public class EditAdminloginForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit member Form</title>");
	
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		out.println("<div class='container'>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		member book=memberDao.viewByid(id);
		
		out.print("<form action='Editmember' method='post' style='width:300px'>");
		out.print("<input type='text' class='form-control' value='"+book.getName()+"' name='name' id='name1' placeholder='Name'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='email1'>Email address</label>");
		out.print("<input type='email' class='form-control' value='"+book.getEmail()+"'  name='email' id='email1' placeholder='Email'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='password1'>Password</label>");
		out.print("<input type='password' class='form-control' value='"+book.getPassword()+"'  name='password' id='password1' placeholder='Password'/>");
		out.print("</div>  ");
		out.print("<button type='submit' class='btn btn-primary'>Update</button>");
		out.print("</form>");
		out.println("</div>");
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
		
	}
}
