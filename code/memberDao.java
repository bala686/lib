package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.member;

public class memberDao {

	public static int save(member mem){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into member(name,email,password,membership) values(?,?,?,?)");
			ps.setString(1,mem.getName());
			ps.setString(2,mem.getEmail());
			ps.setString(3,mem.getPassword());
			ps.setString(4,mem.getMembership());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	/*                        -------------          update member      ------------                    */

	
	public static int update( member mem){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update member set name=?,email=?,password=?,membership=? where id=?");
			ps.setString(1,mem.getName());
			ps.setString(2,mem.getEmail());
			ps.setString(3,mem.getPassword());
			ps.setString(4,mem.getMembership());
			ps.setInt(5,mem.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public static int updates(member mem) {
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update admin set name=?,email=?,password=? where id=?");
			ps.setString(1,mem.getName());
			ps.setString(2,mem.getEmail());
			ps.setString(3,mem.getPassword());
			ps.setInt(4,mem.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
		
	
	/*                        -------------          list member        ------------                    */

	public static List<member> view(){
		List<member> list=new ArrayList<member>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from member");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				member mem=new member();
			    mem.setId(rs.getInt("id"));
				mem.setName(rs.getString("name"));
				mem.setEmail(rs.getString("email"));
				mem.setPassword(rs.getString("password"));
				mem.setMembership(rs.getString("membership"));
				list.add(mem);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	/*          -------------          search by id     ------------                    */

	public static member viewByid(int id){
		member mem=new member();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from member where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				mem.setId(rs.getInt(1));
				mem.setName(rs.getString(2));
				mem.setEmail(rs.getString(4));
				mem.setPassword(rs.getString(3));
				mem.setMembership(rs.getString(5));

				
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return mem;
	}
	/*                        -------------         delete member       ------------                    */

	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from member where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	/*                        -------------         admin login check       ------------                    */


	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from member where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
/*                        -------------          login check       ------------                    */
	
	public static boolean aauthenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from admin where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static member viewBy(int id) {
		member mem=new member();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from admin where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				mem.setId(rs.getInt(1));
				mem.setName(rs.getString(2));
				mem.setEmail(rs.getString(3));
				mem.setPassword(rs.getString(4));
}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return mem;
	}

	

}
