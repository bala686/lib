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
@WebServlet("/Editadmin")
public class Editadmin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  

	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);   
	        String name=request.getParameter("name");   
	        String email=request.getParameter("email");
	        String password=request.getParameter("password");  
	  
	       member mem=new member();  
	       mem.setId(id);  
	        mem.setName(name);  
	        mem.setEmail(email);   
	        mem.setPassword(password);       
	        int status=memberDao.updates(mem);  
	        if(status>0){  
	            response.sendRedirect("index.jsp");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }  
	  
	}