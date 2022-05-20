package main;

public class ReserveBooks {
	int id;
	int memid;
	private String memname,bookname;
	private String returnstatus;


public ReserveBooks() {}
public ReserveBooks(int id,int memid, String memname,String bookname) {
	super();
	this.id = id;
	this.memid = memid;
	this.memname = memname;
	this.bookname=bookname;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMemid() {
	return memid;
}
public void setMemid(int memid) {
	this.memid = memid;
}
public String getMemname() {
	return memname;
}
public void setMemname(String memname) {
	this.memname = memname;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
}