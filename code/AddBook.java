package main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Book;
import main.dao.BookDao;
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
	
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navmember.jsp").include(request, response);
		
		out.println("<div class='container'>");
		String sid=request.getParameter("id");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String subject=request.getParameter("subject");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		int id=Integer.parseInt(sid);
		Book book=new Book(id,name,author,subject,quantity);
		int i=BookDao.save(book);
		if(i>0){
			out.println("<h3>Book saved successfully</h3>");
		}
		request.getRequestDispatcher("addbookform.jsp").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
