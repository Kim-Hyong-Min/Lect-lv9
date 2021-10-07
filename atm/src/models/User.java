package models;

import java.util.ArrayList;

public class User {
	
	private int userCode;
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	
	private User() {}
	
	ArrayList<Account> accounts = new ArrayList<>();
	
	
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getuserCode() {
		return userCode;
	}
	
	public int getAccCnt() {
		return accCnt;
	}
	
	public void setAccCnt(int accCnt) {
		this.accCnt += accCnt;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	// 보유계좌의 객체주소 배열
	
	public User(int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		
		
	}
}
