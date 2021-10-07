package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Bank;
import models.User;
public class UserManager {
	
	public static UserManager instance = new UserManager();
	private UserManager() {}
	
	private Random rn = new Random();
	
	// users : 중앙 (총) 데이터
	ArrayList<User> users = new ArrayList<>();
	
	//가입
	public void joinUser() {
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();
		System.out.print("name : ");
		String name = Bank.sc.next();
		
		User newUser = new User(randomCode(), id, pw, name);
		this.users.add(newUser);
	}
	
	public int loginUser() {
			System.out.print("id : ");
			String id = Bank.sc.next();
			System.out.print("pw : ");
			String pw = Bank.sc.next();
			
			for(int i=0; i<this.users.size(); i++) {
				if(id.equals(this.users.get(i).getId()) && pw.equals(this.users.get(i).getPw())) {
					return i;
				}
			}
			return -1;
		
	}
	
	private int randomCode() {
		if(this.users.size()>0) {
			int rNum = 0;
			while(true) {
				int check = -1;
				rNum = rn.nextInt(8999)+1000;
				for(int i=0; i<this.users.size(); i++) {
					if(this.users.get(i).getuserCode()==rNum) {
						check = i;
					}
				}
				if(check == -1) {
					break;
				}
			}
			return rNum;
		}
		else {
			int rNum = rn.nextInt(8999)+1000;
			return rNum;
		}
	}
}
