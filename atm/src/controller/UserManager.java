package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Bank;
import models.User;

public class UserManager {

	public static UserManager instance = new UserManager();

	private UserManager() {
	}

	private Random rn = new Random();

	// users : 중앙 (총) 데이터
	ArrayList<User> users = new ArrayList<>();

	// 가입
	public void joinUser() {
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();
		System.out.print("name : ");
		String name = Bank.sc.next();

		User newUser = new User(randomCode(), id, pw, name);
		if (this.users.size() > 0) {
			int check = -1;
			for (int i = 0; i < this.users.size(); i++) {
				if (id.equals(this.users.get(i).getId())) {
					check = i;
				}
			}
			if (check == -1) {
				this.users.add(newUser);
			} else
				System.out.println("중복된 아이디가 존재합니다.");
		} else {
			this.users.add(newUser);
		}
	}

	public int loginUser() {
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();

		if (id.equals("admin") && pw.equals("0000")) {
			return -10;
		} else {
			for (int i = 0; i < this.users.size(); i++) {
				if (id.equals(this.users.get(i).getId()) && pw.equals(this.users.get(i).getPw())) {
					return i;
				}
			}
			return -1;
		}
	}

	private int randomCode() {
		if (this.users.size() > 0) {
			int rNum = 0;
			while (true) {
				int check = -1;
				rNum = rn.nextInt(8999) + 1000;
				for (int i = 0; i < this.users.size(); i++) {
					if (this.users.get(i).getuserCode() == rNum) {
						check = i;
					}
				}
				if (check == -1) {
					break;
				}
			}
			return rNum;
		} else {
			int rNum = rn.nextInt(8999) + 1000;
			return rNum;
		}
	}

	public void adminUserCheck() {
		if (this.users.size() > 1) {
			System.out.println("전체 회원수 : " + (this.users.size() - 1) + "명");
			for (int i = 1; i < this.users.size(); i++) {
				System.out.println((i + 1) + ". 회원번호 : " + this.users.get(i).getuserCode() + " / 회원명 : "
						+ this.users.get(i).getName() + " / 회원아이디 : " + this.users.get(i).getId() + " / 회원비밀번호 : "
						+ this.users.get(i).getPw() + " / 보유 계좌 수 : " + this.users.get(i).getAccCnt());
			}
		} else
			System.out.println("전체 회원수 : 0명");
	}

}
