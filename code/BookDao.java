package main.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.Book;
import main.IssueBooks;
import main.ReserveBooks;
import main.member;
import main.servlets.Editbook;

public class BookDao {


	/*                        ---------------        save book   -----------                        */
	
public static int save(Book e){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into book  values (?,?,?,?,?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2,e.getName());
			ps.setString(3,e.getAuthor());
			ps.setString(4,e.getSubject());
			//ps.setString(4,e.getDate());
			ps.setInt(5,e.getQuantity());
			ps.setInt(6,0);
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	

/*                        ---------------        update book   -----------                        */

	
	public static int update(Book e){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update book set name=?,author=?,subject=?,quantity=?  where id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getAuthor());
			ps.setString(3,e.getSubject());
			//ps.setString(4,e.getDate());
			ps.setInt(4,e.getQuantity());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	

	/*                        ---------------        delete book   -----------                        */
	
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from book where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	

	/*                        ---------------        view by id book   -----------                        */
	
	
	public static Book getBookById(int id){
		Book e=new Book();
		
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAuthor(rs.getString(3));
				e.setSubject(rs.getString(4));
				//e.setDate(rs.getString(5));
				e.setQuantity(rs.getInt(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}

	/*                        ---------------        list book   -----------                        */
	
	
	public static List<Book> getAllBook(){
		List<Book> list=new ArrayList<Book>();
		
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from book");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Book e=new Book();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAuthor(rs.getString(3));
				e.setSubject(rs.getString(4));
				e.setQuantity(rs.getInt(5));
				e.setIssued(rs.getInt(6));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	

	/*                        ---------------       get issue book   -----------                        */
	
	
	public static int getIssued(int id){
		int issued=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return issued;
	}

	/*                        ---------------        check issue book   -----------                        */
	
	
	public static boolean checkIssue(int id){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from book where id=? and quantity>issued");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	

	/*                        ---------------        issue book   -----------                        */
	
	
	public static int issueBook(IssueBooks book){
		int id=book.getId();
		boolean checkstatus=checkIssue(id);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("insert into issuebook values(?,?,?,?)");
				ps.setInt(1,book.getId());
				ps.setString(2,book.getMemberid());
				ps.setString(3,book.getMembername());
				ps.setString(4,"no");
				
				status=ps.executeUpdate();
				System.out.println(status);
				if(status>0){
					
					PreparedStatement ps2=con.prepareStatement("update book set issued=?,quantity=? where id=?");
			        System.out.println(id+"id of book");
					int d=(getissuedbook(id));
					int c=(getquantity(id));
					System.out.println(d+"count in issued");
					ps2.setInt(1,++d);
					ps2.setInt(2,--c);
					ps2.setInt(3,id);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}
		else{
			return 0;
		}
	}
	

	private static int getissuedcount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	/*                        ---------------        return  book   -----------                        */
	
	public static int returnBook(int id,String smemberid){
		int status=0;
			try{
				System.out.println("id in"+id);
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("update issuebook set returnstatus='yes' where id=? and memberid=?");
				String sid=Integer.toString(id);
				ps.setString(1,sid);
				ps.setString(2,smemberid);
				System.out.println("update issuebook set returnstatus=? where id=? and memberid=?"+id+smemberid);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update book set issued=?,quantity=? where id=?");
					int d=getissuedbook(id);
					int c=getquantity(id);
					ps2.setInt(1,--d);
					ps2.setInt(2,++c);
					ps2.setInt(3,id);
					
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}

	/*                        ---------------        list issue book   -----------                        */
	
	
	public static List<IssueBooks> viewIssuedBooks(){
		List<IssueBooks> list=new ArrayList<IssueBooks>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from issuebook");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBooks book=new IssueBooks();
				book.setId(rs.getInt("id"));
				book.setMemberid(rs.getString("memberid"));
				book.setMembername(rs.getString("membername"));
				book.setReturnstatus(rs.getString("returnstatus"));
				list.add(book);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static List<IssueBooks> viewIssuedBook(int memberid){
		List<IssueBooks> list=new ArrayList<IssueBooks>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from issuebook where memberid=?");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBooks book=new IssueBooks();
				book.setId(rs.getInt("id"));
				book.setMemberid(rs.getString("memberid"));
				book.setMembername(rs.getString("membername"));
				book.setReturnstatus(rs.getString("returnstatus"));
				list.add(book);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	

	/*                        ---------------        save book   -----------                        */
	
public static int update(member book){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update member set name=?,email=?,password=? where id=?");
			ps.setString(1,book.getName());
			ps.setString(2,book.getEmail());
			ps.setString(3,book.getPassword());
			ps.setInt(5,book.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}


/*                        ---------------        search by id book   -----------                        */


	public static Book viewByid(int id){
		Book book=new Book();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setSubject(rs.getString(4));
				book.setQuantity(rs.getInt(5));
				
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return book;
	}
	

	/*                        ---------------        reserve book   -----------                        */
	
	
	public static int reserveBook(ReserveBooks book1) {
				int status=0;
				try{
					Connection con=DB.getCon();
					PreparedStatement ps=con.prepareStatement("insert into reserve values(?,?,?,?)");
					ps.setInt(1,book1.getId());
					ps.setInt(2,book1.getMemid());
					ps.setString(3,book1.getMemname());
					ps.setString(4,book1.getBookname());
					status=ps.executeUpdate();
					con.close();
					
				}catch(Exception e){System.out.println(e);}
				
				return status;
			}
	

	/*                        ---------------        view reserve  book   -----------                        */
	
	
	
	public static List<ReserveBooks> viewReserveBooks(){
		List<ReserveBooks> list=new ArrayList<ReserveBooks>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from reserve");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ReserveBooks book=new ReserveBooks();
				book.setId(rs.getInt("id"));
				book.setMemid(rs.getInt("memid"));
				book.setMemname(rs.getString("memname"));
				book.setBookname(rs.getString("name"));
				list.add(book);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int  getissuedbook(int a){
		int b=3;
		
		try{
			Connection con=DB.getCon();
			String sql="select * from book where id="+a;
			PreparedStatement ps=con.prepareStatement(sql);
		       System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				 b=rs.getInt(6);
				}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return b;
	}

	public static int  getquantity(int a){
		int b=0;
		
		try{
			Connection con=DB.getCon();
			String sql="select * from book where id="+a;
			PreparedStatement ps=con.prepareStatement(sql);
		       System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				 b=rs.getInt(5);
				}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return b;
	}
	

}


