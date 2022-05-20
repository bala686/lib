package main.servlets;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.IssueBooks;
import main.returnbook;
import main.dao.BookDao;
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Return Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		request.getRequestDispatcher("navmember.jsp").include(request, response);
		String sid=request.getParameter("id");
		String smemberid=request.getParameter("memberid");
		int memberid=Integer.parseInt(smemberid);
		int id=Integer.parseInt(sid);
		System.out.print("id"+id);
		System.out.print(memberid);
		returnbook book=new returnbook(id,smemberid);
		int i=BookDao.returnBook(id,smemberid);
		if(i>0){
			out.println("<h3>Book returned successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to return book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
		}
		out.println("</div>");
		out.close();
	}

}
