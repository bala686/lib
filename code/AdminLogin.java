package main.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.dao.memberDao;
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
	
		out.println("</head>");
		out.println("<body>");
		

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(memberDao.aauthenticate(email, password)){
			HttpSession session=request.getSession();
			session.setAttribute("email",email);
			 request.setAttribute("data",email); 
			 System.out.println(email);
			request.getRequestDispatcher("navadmin.jsp").include(request, response);
		    request.getRequestDispatcher("Admininfo.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='container'>");
			out.println("<h3>Username or password error</h3>");
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.println("</div>");
		}
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
