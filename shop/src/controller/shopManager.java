package controller;

import models.shop;

public class shopManager {
	private int cnt = -1;
	public static shopManager instance = new shopManager();
	private userManager um = userManager.instance;
	private itemManager im = itemManager.instance;
	
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
		System.out.println(cnt);
		if(shop.log!=-1) um.printLoginUser();
		if(this.cnt==-1) {
			System.out.println("1.가입\n2.탈퇴\n3.로그인\n4.로그아웃\n5.쇼핑 매뉴\n6.관리자\n7.종료");
		}
		else {
			System.out.println("1.쇼핑\n2.장바구니 목록\n3.뒤로가기");
		}
	}
	
	private void shoppingIn() {
		if(shop.log!=-1) {
			this.cnt = 1;
		}
		else System.out.println("로그인 후 이용 바랍니다.");
	}
	
	//입력
	private void menuSelect() {
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			if(this.cnt==-1) {
				if(num == 1) { //가입
					um.joinUser();
				}
				else if(num == 2) {//탈퇴
					um.outUser();
				}
				else if(num == 3) {//로그인
					um.loginUser();
				}
				else if(num == 4) {//로그아웃
					um.logoutUser();
				}
				else if(num == 5) {//쇼핑 매뉴
					shoppingIn();
				}
				else if(num == 6) {//관리자
					im.manageMenu();
				}
				else if(num == 7) {//종료
					
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
		}
	}
	
	
	// 쇼핑
	// 카테고리 목록
	// 카테고리 선택
	// 상품 목록
	// 상품 선택
	// 수량 선택
	
	// 장바구니 목록
	// 장바구니 메뉴 - 장바구니 보기, 결제하기, 상품 제거
}
