package main.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Book;
import main.member;
import main.dao.BookDao;
import main.dao.memberDao;
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
	
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		
		out.println("<div class='container'>");
		request.getRequestDispatcher("bsearch.jsp").include(request, response);
		List<Book> list=BookDao.getAllBook();
		
		out.println("<table border='1' width='80%'");
		out.println("<center><h1>Book List</h1></center>");
		out.println("<tr><th>id</th><th>Name</th><th>Author</th><th>subject</th><th>Quantity</th><th>Issued</th><th>---Action---</th></tr>");
		for(Book book:list){
			out.println("<tr><td>"+book.getId()+"</td><td>"+book.getName()+"</td><td>"+book.getAuthor()+"</td><td>"+book.getSubject()+"</td><td>"+book.getQuantity()+"</td><td>"+book.getIssued()+"</td><td><a href='EditbookForm?id="+book.getId()+"'>[ Edit ]</a><a href='DeleteBook?id="+book.getId()+"'>[ Delete ]</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}
}
