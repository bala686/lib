package main.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.dao.DB;
 
@WebServlet("/servlet")
public class servlet extends HttpServlet
{
     int i;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            i++;
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            String un = request.getParameter("id");
            int id =Integer.parseInt(un);
            String name = request.getParameter("name");
            String subject = request.getParameter("subject");
            Connection con=DB.getCon();
            pst = con.prepareStatement("select * from book where id=?");
            pst.setInt(1, id);
            
          /*   }
             else if((name!=null)&&(un==null)&&(subject==null))
             {
            	 pst = con.prepareStatement("select * from book where name=? ");
                 pst.setString(2,name); 
             }
             else if((subject!=null)&&(un==null)&&(name==null))
             {
            	 pst = con.prepareStatement("select * from book where subject=?");
                 pst.setString(4,subject); 
             }
             else
             {
            	 pst = con.prepareStatement("select * from book");
             }*/
             rs = pst.executeQuery();
             out.println("<table width=60% border= 1   >");
             out.println("<tr><td colspan=4 " );
             out.println("<center><h2>Result of Search Page</h2></center>");
             out.println("</td></tr>");
             out.println("<tr>");
             out.println("<th>id</th>");
             out.println("<th> name</th>");
             out.println("<th>Title</th>");
             out.println("<th>quantity</th>");
             out.println("<th>issued</th>");
             out.println("</tr>");
              
              while(rs.next())
              {
                  out.println("<tr>");
                  out.println("<td>" + rs.getString("id") + "</td> ");
                  out.println("<td>" + rs.getString("name") + "</td> ");
                  out.println("<td>" + rs.getString("subject") + "</td> ");
                  out.println("<td>" + rs.getString("quantity") + "</td> ");
                  out.println("<td>" + rs.getString("issued") + "</td> ");
                  out.println("</tr>");
 
                  
              }
              out.println("</table>");
        
               }
            catch (Exception ex) {
          
        }
    }
    
    public void destory()
    {
        i = 0;
    }
 
    
}