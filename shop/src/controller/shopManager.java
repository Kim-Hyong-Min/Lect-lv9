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
	
	public void shopping() {
		if(im.items.size()>0) {
			printShoppingMenu();
			String menu = shop.sc.next();
			try {
				int num = Integer.parseInt(menu)-1;
				
				if(num>=0 && num<im.items.size()) {//카테고리 선택
					itemChoice(num);
				}
				else if(num==im.items.size()) {//뒤로가기
					
				}
				else System.out.println("잘못된 입력 입니다.");
				
			}catch (Exception e) {
			}
			
		}
		else System.out.println("저장된 상품이 없습니다.");
	}
	
	public void itemChoice(int idx) {
		if(im.items.get(idx).getListSize()>0) {
			printItemMenu(idx);
			String menu = shop.sc.next();
			try {
				int num = Integer.parseInt(menu)-1;
				if(num>=0 && num<im.items.get(idx).getListSize()) {//아이템 선택
					itemNumChoice(idx, num);
				}
				else if(num==im.items.get(idx).getListSize()) {//뒤로가기
					
				}
				else System.out.println("잘못된 입력 입니다.");
			}catch (Exception e) {
			}
		}
		else System.out.println("해당 카테고리에 상품이 없습니다.");
	}
	
	public void printShoppingMenu() {
		System.out.println("[카테고리]");
		for(int i=0; i<im.items.size(); i++) {// 카테고리 목록
			System.out.println((i+1)+". ["+im.items.get(i).getCategory()+"]");
		}
		System.out.println((im.items.size()+1)+".[뒤로가기]");
		System.out.print("번호 입력 : ");
	}
	
	// 상품 목록
	public void printItemMenu(int idx) {
		System.out.println("["+im.items.get(idx).getCategory()+"]");
		System.out.println("[상품목록]");
		for(int i=0; i<im.items.get(idx).getList().size(); i++) {// 상품 목록
			System.out.println((i+1)+". ["+im.items.get(idx).getItems(i)+"]");
		}
		System.out.println((im.items.get(idx).getListSize()+1)+".[뒤로가기]");
		System.out.print("번호 입력 : ");
	}
	
	// 수량 선택
	public void itemNumChoice(int cateIdx, int itemIdx) {
		System.out.print("수량 선택 : ");
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			
			if(num>0 && num<=im.items.get(cateIdx).getCnt(itemIdx)) {
				
			}
			else System.out.println("잘못된 수량 입니다.");
			
		}catch (Exception e) {
		}
	}
	// 장바구니 목록
	// 장바구니 메뉴 - 장바구니 보기, 결제하기, 상품 제거
}
