package main.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.IssueBooks;
import main.ReserveBooks;
import main.dao.BookDao;
@WebServlet("/ViewReserveBooks")
public class ViewReserveBooks extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
	
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		
		out.println("<div class='container'>");
		
		List<ReserveBooks> list=BookDao.viewReserveBooks();
		out.println("<center><h1>Reserve Book List</h1></center>");
		
		out.println("<table border='1' width='80%'\">");
		out.println("<tr><th>id</th><th>member id</th><th>member Name</th><th>Book name</th></tr>");
		for(ReserveBooks book1:list){
			out.println("<tr><td>"+book1.getId()+"</td><td>"+book1.getMemid()+"</td><td>"+book1.getMemname()+"</td><td>"+book1.getBookname()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}
}
