package main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Book;
import main.member;
import main.dao.BookDao;
import main.dao.memberDao;
@WebServlet("/EditbookForm")
public class EditbookForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit book Form</title>");
	
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		out.println("<div class='container'>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Book b=BookDao.viewByid(id);
		
		out.print("<form action='Editbook' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='id' value='"+b.getId()+"'/>");
		out.print("<label for='name1'>Name</label>");
		out.print("<input type='text' class='form-control' value='"+b.getName()+"' name='name' id='name1' placeholder='Name'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='author1'>author</label>");
		out.print("<input type='author' class='form-control' value='"+b.getAuthor()+"'  name='author' id='author1' placeholder='author'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='subject1'>subject</label>");
		out.print("<input type='subject' class='form-control' value='"+b.getSubject()+"'  name='subject' id='subject1' placeholder='subject'/>");
		out.print("</div>  ");
        out.print("<label for='quantity1'>quantity</label>");
		out.print("<input type='quantity' class='form-control' value='"+b.getQuantity()+"'  name='quantity' id='quantity1' placeholder='quantity'/>");
		out.print("</div>  ");
		out.print("<button type='submit' class='btn btn-primary'>Update</button>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
		
	}
}