package main.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Book;
import main.IssueBooks;
import main.ReserveBooks;
import main.dao.BookDao;
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
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
		String bname=request.getParameter("name");
		String memberid=request.getParameter("memberid");
		String membername=request.getParameter("membername");
		int id =Integer.parseInt(sid);
		IssueBooks book=new IssueBooks(id,memberid,membername);
		int i=BookDao.issueBook(book);
		if(i>0){
			out.println("<h3>Book issued successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to issue book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
		//ReserveBooks book1=new ReserveBooks(id,bname,memberid,membername);
		//BookDao.reserveBook(book1);
		}
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
