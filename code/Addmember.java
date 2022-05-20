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
@WebServlet("/Addmember")
public class Addmember extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add member</title>");
	
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		out.println("<div class='container'>");
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String membership=request.getParameter("membership");
		member book=new member(name, email, password,membership);
		memberDao.save(book);
		out.print("<h4>member one successfully</h4>");
		request.getRequestDispatcher("addmemberform.jsp").include(request, response);
		
		
		out.println("</div>");
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
