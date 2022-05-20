package main;

public class IssueBooks {
int id;
private String memberid,membername;
private String returnstatus;

public IssueBooks() {}
public IssueBooks(int id, String memberid, String membername) {
	super();
	this.id = id;
	this.memberid = memberid;
	this.membername = membername;
}

public String getReturnstatus() {
	return returnstatus;
}
public void setReturnstatus(String returnstatus) {
	this.returnstatus = returnstatus;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMemberid() {
	return memberid;
}
public void setMemberid(String memberid) {
	this.memberid = memberid;
}
public String getMembername() {
	return membername;
}
public void setMembername(String membername) {
	this.membername = membername;
}
}