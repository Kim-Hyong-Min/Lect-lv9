package controller;

import models.shop;

public class shopManager {
	private int cnt = -1;
	public static shopManager instance = new shopManager();
	private userManager um = userManager.instance;
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	//실행
	public void run() {
		while(true) {
			printMenu();
			menuSelect();
		}
	}
	//메뉴
	private void printMenu() {
		System.out.println("===="+shop.getName()+"====");
		um.check();                                          //가입 검사문
		if(cnt==-1) {
			System.out.println("1.가입\n2.탈퇴\n3.로그인\n4.로그아웃\n5.관리자\n6.종료");
		}
		else {
			System.out.println("1.쇼핑\n2.장바구니 목록\n3.뒤로가기");
		}
	}
	
	//입력
	private void menuSelect() {
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			if(shop.log==-1) {
				if(num == 1) { //가입
					um.joinUser();
				}
				else if(num == 2) {//탈퇴
					
				}
				else if(num == 3) {//로그인
					um.loginUser();
				}
				else if(num == 4) {//로그아웃
					um.logoutUser();
				}
				else if(num == 4) {//쇼핑 매뉴
					this.cnt=1;
				}
				else if(num == 5) {//관리자
					
				}
				else if(num == 6) {//종료
					
				}
				
			}
			else{
				if(num == 1) { //쇼핑
					
				}
				else if(num == 2) {//장바구니 목록
					
				}
				else if(num == 3) {//뒤로가기
					this.cnt=-1;
				}
			}
			
		}catch (Exception e) {
			System.out.println("잘못된 입력 입니다.");
		}
	}
}
