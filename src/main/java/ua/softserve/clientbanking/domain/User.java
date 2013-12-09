package ua.softserve.clientbanking.domain;

public class User {
	private int id;
	private String name;
	private String login;
	private String role;
	
	
	public User(int id, String name, String login, String role) {
		this.id=id;
		this.name=name;
		this.login=login;
		this.role=role;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getLogin() {
		return login;
	}


	public String getRole() {
		return role;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setRole(String role) {
		this.role = role;
	}
	

}
