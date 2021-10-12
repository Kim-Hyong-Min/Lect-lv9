package models;

import java.util.ArrayList;

public class user {
	private int userCode;
	private String id;
	private String pw;
	
	private user() {
	}
	
	public user(String id, String pw, int userCode) {
		this.id = id;
		this.pw = pw;
		this.userCode = userCode;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public int getUserCode() {
		return this.userCode;
	}
	
}
