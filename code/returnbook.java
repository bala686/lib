package main;

public class returnbook {
	int id;
	String memberid;
	private String membername;
	private String returnstatus;
	public returnbook() {}
	public returnbook(int id, String memberid) {
		super();
		this.id = id;
		this.memberid = memberid;
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

