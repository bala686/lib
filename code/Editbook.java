package main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import main.Book;
import main.dao.BookDao;
import main.dao.memberDao;

@WebServlet("/Editbook")
public class Editbook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String subject=request.getParameter("subject");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		//String date=request.getParameter("date");
		Book e=new Book();
		e.setId(id);
		e.setName(name);
		e.setAuthor(author);
		e.setSubject(subject);
		e.setQuantity(quantity);
		//e.setDate(date);
		int status=BookDao.update(e);
		if(status>0){
			response.sendRedirect("ViewBook");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
