package main.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.Book;
import main.IssueBooks;
import main.dao.BookDao;
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
	
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navmember.jsp").include(request, response);
		out.println("<div class='container'>");
		List<IssueBooks> list=BookDao.viewIssuedBooks();
		out.println("<center><h1>Issue Book List</h1></center>");
		out.println("<table border='1' width='80%'\">");
		out.println("<tr><th>id</th><th>member id</th><th>member Name</th><th>Return Status</th></tr>");
		for(IssueBooks book:list){
			out.println("<tr><td>"+book.getId()+"</td><td>"+book.getMemberid()+"</td><td>"+book.getMembername()+"</td><td>"+book.getReturnstatus()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		HttpSession session = request.getSession();
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}
}
