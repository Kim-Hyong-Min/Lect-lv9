package controller;

import models.cart;
import models.shop;

public class shopManager {
	private int cnt = -1;
	public static shopManager instance = new shopManager();
	private userManager um = userManager.instance;
	private itemManager im = itemManager.instance;
	private int check = -1;
	//실행
	
	private boolean finish() {
		if(this.check==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void run() {
		im.categorySet();
		while(finish()) {
			printMenu();
			menuSelect();
		}
	}
	//메뉴
	private void printMenu() {

		System.out.println("===="+shop.getName()+"====");
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
					shop.log = -1;
					im.manageMenu();
				}
				else if(num == 7) {//종료
					this.check = 1;
				}
				
			}
			else{
				if(num == 1) { //쇼핑
					shopping();
				}
				else if(num == 2) {//장바구니 목록
					cartMenu();
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
			while(true) {
				String menu = shop.sc.next();
				try {
					int num = Integer.parseInt(menu)-1;
					
					if(num>=0 && num<im.items.size()) {//카테고리 선택
						itemChoice(num);
						break;
					}
					else if(num==im.items.size()) {//뒤로가기
						break;
					}
					else System.out.println("잘못된 입력 입니다.");
					
				}catch (Exception e) {
				}
			}
			
		}
		else System.out.println("저장된 상품이 없습니다.");
	}
	
	public void itemChoice(int idx) {
		if(im.items.get(idx).getListSize()>0) {
			printItemMenu(idx);
			while(true) {
			String menu = shop.sc.next();
			try {
				int num = Integer.parseInt(menu)-1;
				if(num>=0 && num<im.items.get(idx).getListSize()) {//아이템 선택
					itemNumChoice(idx, num);
					break;
				}
				else if(num==im.items.get(idx).getListSize()) {//뒤로가기
					break;
				}
				else System.out.println("잘못된 입력 입니다.");
			}catch (Exception e) {
			}
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
			System.out.println((i+1)+". ["+im.items.get(idx).getItems(i)+"] 수량 : "+im.items.get(idx).getCnt(i)+"개 / 가격 : "+im.items.get(idx).getPrice(i)+"원");
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
				if(um.cart.size()==0) {
					cart addItem = new cart(im.items.get(cateIdx).getItems(itemIdx), um.getUserCode(), im.items.get(cateIdx).getCategoryCode(), im.items.get(cateIdx).getItemCode(itemIdx), num, im.items.get(cateIdx).getPrice(itemIdx));
					im.items.get(cateIdx).setCnt(itemIdx, -num);// 상품 수량 감소
					um.cart.add(addItem);
					System.out.println("상품을 담았습니다!");
				}
				else {
					sameItemCheck(cateIdx, itemIdx, num);
				}
			}
			else System.out.println("잘못된 수량 입니다.");
			
		}catch (Exception e) {
		}
	}
	
	// 중복 체크
	public void sameItemCheck(int cateIdx, int itemIdx, int num) {
		int check = -1;
		for(int i=0; i<um.cart.size(); i++) {// 장바구니 목록
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode() && um.cart.get(i).getCategoryCode()==im.items.get(cateIdx).getCategoryCode() && um.cart.get(i).getItemCode()==im.items.get(cateIdx).getItemCode(itemIdx)) {
				im.items.get(cateIdx).setCnt(itemIdx, -num);
				um.cart.get(i).setItemNum(num);
				check = i;
			}
		}
		
		if(check == -1) {
			cart addItem = new cart(im.items.get(cateIdx).getItems(itemIdx), um.getUserCode(), im.items.get(cateIdx).getCategoryCode(), im.items.get(cateIdx).getItemCode(itemIdx), num, im.items.get(cateIdx).getPrice(itemIdx));
			im.items.get(cateIdx).setCnt(itemIdx, -num);// 상품 수량 감소
			um.cart.add(addItem);
		}
	}
	
	
	// 장바구니 목록
	public void cartMenu() {
		System.out.println("1.장바구니 보기\n2.결제하기\n3.상품 제거\n4.뒤로가기");
		while(true) {
			String menu = shop.sc.next();
			try {
				int num = Integer.parseInt(menu);
				if(num == 1) { //장바구니 보기
					cart();
					break;
				}
				else if(num == 2) {//결제하기
					cartPaying();
					break;
				}
				else if(num == 3) {//상품제거
					cartRemove();
					break;
				}
				else if(num == 4) {//뒤로가기
					break;
				}
				
			}catch (Exception e) {
			}
		}
	}
	
	//장바구니 보기
	
	public void cart() {
		if(um.cart.size()>0) {
			printCart();
		}
		else System.out.println("장바구니가 비어있습니다.");
	}
	
	public void printCart() {
		int check = 0;
		System.out.println("[장바구니]");
		for(int i=0; i<um.cart.size(); i++) {// 장바구니 목록
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
				check++;
				System.out.println(check+". 품명 : "+um.cart.get(i).getItems()+"/ 수량 : "+um.cart.get(i).getItemNum()+"/ 가격 : "+um.cart.get(i).getTotalPrice());
			}
		}
		if(check==0) System.out.println("장바구니에 상품이 존재하지 않습니다.");
	}
	
	// 결제하기
	public void cartPaying() {
		int check = 0;
		System.out.println("[장바구니]");
		for(int i=0; i<um.cart.size(); i++) {
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
				check++;
				System.out.println(check+". 품명 : "+um.cart.get(i).getItems()+"/ 수량 : "+um.cart.get(i).getItemNum()+"/ 가격 : "+um.cart.get(i).getTotalPrice());
			}
		}
		if(check==0) {
			System.out.println("장바구니에 상품이 존재하지 않습니다.");
		}
		else {
			System.out.println("현재 장바구니에 있는 상품을 구매 하시겠습니까?[Yes:1][No:2]");
			cartReset();
		}
	}
	
	public void cartReset() {
		String menu = shop.sc.next();
		try {
			int num = Integer.parseInt(menu);
			if(num == 1) {
				int total = 0;
				for(int i=0; i<um.cart.size(); i++) {
					if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
						shop.setTotalSales(um.cart.get(i).getTotalPrice());
						total+=um.cart.get(i).getTotalPrice();
						um.cart.remove(i);
					}
				}
				System.out.printf("총 금액 : %d원\n결제 완료!\n",total);
			}
			else if(num == 2) {
				
			}
		}catch (Exception e) {
		}
	}
	
	
	// 장바구니 메뉴 - 상품 제거
	public void cartRemove() {
		int check = 0;
		System.out.println("[장바구니]");
		for(int i=0; i<um.cart.size(); i++) {
			if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
				check++;
				System.out.println(check+". 품명 : "+um.cart.get(i).getItems()+"/ 수량 : "+um.cart.get(i).getItemNum()+"/ 가격 : "+um.cart.get(i).getTotalPrice());
			}
		}
		System.out.println((check+1)+".[뒤로가기]");
		if(check==0) {
			System.out.println("장바구니에 상품이 존재하지 않습니다.");
		}
		else {
			System.out.print("번호 입력 : ");
			String choice = shop.sc.next();
			try {
				int num = Integer.parseInt(choice)-1;
				if(num>=0 && num<check) {
					int cnt=0;
					for(int i=0; i<um.cart.size(); i++) {
						if(um.cart.get(i).getUserCode()==um.users.get(shop.log).getUserCode()) {
							if(num==cnt) {
								um.cart.remove(i);
								System.out.println("제거 완료!");
								break;
							}
							cnt++;
						}
					}
				}
				else if(num==check) {
					
				}
			}catch (Exception e) {
			}
		}
	}
	
	
	
}
