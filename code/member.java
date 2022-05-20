package main;

public class member {
private int id;
private String name,email,password, membership;


public member() {}

public member(int id, String name, String email, String password,String membership) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.membership=membership;
}
public member(String name, String email, String password,String membership) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.membership=membership;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public  String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getMembership() {
	return membership;
}

public void setMembership(String membership) {
	this.membership = membership;
}

public int  getId() {
	return id;
}

}
