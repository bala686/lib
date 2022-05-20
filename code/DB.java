package main.dao;

import java.sql.*;

public class DB {
public static Connection getCon(){
	String jdbc="jdbc:postgresql://localhost:3030/postgres";
	String name="postgres";
	String pass="1234";
	Connection con=null;
	try{
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection(jdbc,name,pass);
		System.out.println("connected");
		return con;
	}catch(Exception e){System.out.println(e);}
	return null;
}
}
