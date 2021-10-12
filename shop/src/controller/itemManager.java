package controller;

import java.util.ArrayList;

import models.item;
import models.shop;

public class itemManager {
	public static itemManager instance = new itemManager();
	private int num = -1;
	
	ArrayList<item>items = new ArrayList<>();
	//카테고리 관리 - 전체 카테고리, 카테고리 추가, 카테고리 삭제
	public void manageMenu() {
		while(true) {
			printManage();
			String menu = shop.sc.next();
			if(this.num==-1) { // 전체 매뉴
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //카테고리 관리
						this.num=1;
					}
					else if(num == 2) { //아이템 관리
						this.num=2;
					}
					else if(num == 3) { //장바구니 관리
						this.num=3;
					}
					else if(num == 4) { //뒤로가기
						break;
					}
					
				}catch (Exception e) {
				}
			}
			else if(this.num==1){// 카테고리
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //카테고리 추가
						categoryAdd();
					}
					else if(num == 2) { //카테고리 삭제
						categoryRemove();
					}
					else if(num == 3) { //전체 카테고리
						printAllCategory();
					}
					else if(num == 4) { //뒤로가기
						this.num = -1;
					}
					
				}catch (Exception e) {
				}
			}
			else if(this.num==2){
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //아이템 추가
						itemMenu(num);
					}
					else if(num == 2) { //아이템 삭제
						itemMenu(num);
					}
					else if(num == 3) { //전체 아이템
						printAllItem();
					}
					else if(num == 4) { //뒤로가기
						this.num = -1;
					}
					
				}catch (Exception e) {
				}
			}
			else if(this.num==3){
				try {
					int num = Integer.parseInt(menu);
					if(num == 1) { //장바구니 추가
						
					}
					else if(num == 2) { //장바구니 삭제
						
					}
					else if(num == 3) { //장바구니 관리
						
					}
					else if(num == 4) { //뒤로가기
						this.num = -1;
					}
					
				}catch (Exception e) {
				}
			}
		}
	}
	
	public void printManage() {
		if(this.num==-1) {
			System.out.println("1.카테고리 관리\n2.아이템 관리\n3.장바구니 관리\n4.뒤로가기");
		}
		else if(this.num==1) {
			System.out.println("1.카테고리 추가\n2.카테고리 삭제\n3.전체 카테고리\n4.뒤로가기");
		}
		else if(this.num==2) {
			System.out.println("1.아이템 추가\n2.아이템 삭제\n3.전체 아이템\n4.뒤로가기");
		}
		else if(this.num==3) {
			System.out.println("1.장바구니 추가\n2.장바구니 삭제\n3.전체 장바구니\n4.뒤로가기");
		}
	}
	
	
	public void printAllCategory() {
		if(this.items.size()>0) {
			for(int i=0; i<this.items.size(); i++) {
				System.out.println((i+1)+". "+this.items.get(i).getCategory()+" / 아이템 수량 : "+this.items.get(i).getListSize());
			}
		}
		else System.out.println("카테고리가 존재하지 않습니다.");
	}
	
	
	//카테고리 추가
	public void categoryAdd() {
		System.out.print("카테고리명 입력 : ");
		String name = shop.sc.next();
		
		if(this.items.size()==0) {
			int rNum = shop.rn.nextInt(899)+100;
			item cate = new item(name, rNum);
			this.items.add(cate);
			System.out.println("추가 완료!");
		}
		else {
			int check = -1;
			for(int i=0; i<this.items.size(); i++) {
				if(this.items.get(i).getCategory().equals(name)) {
					check = i;
				}
			}
			
			if(check == -1) {
				while(true) {
					int rNum = shop.rn.nextInt(899)+100;
					int rNumCheck = -1;
					for(int i=0; i<this.items.size(); i++) {
						if(this.items.get(i).getCategoryCode() == rNum) {
							rNumCheck = i;
						}
					}
					if(rNumCheck==-1) {
						item cate = new item(name, rNum);
						this.items.add(cate);
						System.out.println("추가 완료!");
						break;
					}
				}
			}
			else System.out.println("중복된 카테고리가 존재합니다.");
		}
	}
	
	//카테고리 삭제
	public void categoryRemove() {
		if(this.items.size()>0) {
			System.out.print("카테고리명 입력 : ");
			String name = shop.sc.next();
			int check = -1;
			for(int i=0; i<this.items.size(); i++) {
				if(this.items.get(i).getCategory().equals(name)) {
					check = i;
				}
			}
			if(check != -1) {
				this.items.remove(check);
				System.out.println("삭제 완료!");
			}
			else System.out.println("입력하신 카테고리가 존재하지 않습니다.");
			
		}
		else System.out.println("입력된 카테고리가 존재하지 않습니다.");
	}
	
	//아이템 관리 - 전체 아이템, 아이템 추가, 아이템 삭제
	public void itemMenu(int menu) {
		if(this.items.size()>0) {
			for(int i=0; i<this.items.size(); i++) {
				System.out.println((i+1)+". "+this.items.get(i).getCategory());
			}
			System.out.print("번호 입력 : ");
			String idx = shop.sc.next();
			try {
				int num = Integer.parseInt(idx)-1;
				
				if(num>=0 && num<this.items.size()) {
					if(menu == 1) {
						itemAdd(num);
					}
					else if(menu == 2) {
						itemRemove(num);
					}
				}
			}catch (Exception e) {
			}
			
		}
	}
	
	public void itemAdd(int idx) { // 아이템 추가
		System.out.print("아이템명 입력 : ");
		String name = shop.sc.next();
		System.out.print("아이템 수량 입력 : ");
		String cnt = shop.sc.next();
		System.out.print("아이템 가격 입력 : ");
		String price = shop.sc.next();
		try {
			int num = Integer.parseInt(cnt);
			int money = Integer.parseInt(price);
			
			if(num>0 && money>0) {
				if(this.items.get(idx).getListSize()==0) {
					int rNum = shop.rn.nextInt(8999)+1000;
					this.items.get(idx).setItem(name, num, money, rNum);
					System.out.println("아이템 추가 완료!");
				}
				else {
					int check = -1;
					for(int i=0; i<this.items.get(idx).getListSize(); i++) {
						if(this.items.get(idx).getItems(i).equals(name)) {
							check = i;
						}
					}
					if(check == -1) {
						while(true) {
							int rNum = shop.rn.nextInt(8999)+1000;
							int rNumCheck = -1;
							for(int i=0; i<this.items.get(idx).getListSize(); i++) {
								if(this.items.get(idx).getItemCode(i) == rNum) {
									rNumCheck = i;
								}
							}
							if(rNumCheck ==-1) {
								this.items.get(idx).setItem(name, num, money, rNum);
								System.out.println("아이템 추가 완료!");
								break;
							}
						}
					}
					else System.out.println("중복되는 상품이 카테고리 내에 존재합니다.");
				}
			}
		}catch (Exception e) {
		}
	}
	
	public void itemRemove(int idx) { 
		if(this.items.get(idx).getListSize()>0) {
			System.out.print("아이템명 입력 : ");
			String name = shop.sc.next();
			int check = -1;
			for(int i=0; i<this.items.get(idx).getListSize(); i++) {
				if(this.items.get(idx).getItems(i).equals(name)) {
					check = i;
				}
			}
			if(check!=-1) {
				this.items.get(idx).setItem(check);
				System.out.println("아이템 삭제 완료!");
			}
			else System.out.println("동일한 상품이 없습니다.");
		}
		else System.out.println("해당 카테고리내에 상품이 없습니다.");
	}
	
	public void printAllItem() {
		if(this.items.size()>0) {
			int cnt = 1;
			for(int i=0; i<this.items.size(); i++) {
				if(this.items.get(i).getListSize()>0) {
					for(int j=0; j<this.items.get(i).getListSize(); j++) {
						System.out.println(cnt+". 아이템명 : "+this.items.get(i).getItems(j)+" / 수량 : "+this.items.get(i).getCnt(j)+"개 / 가격 : "+this.items.get(i).getPrice(j)+"원");
						cnt++;
					}
				}
			}
		}
		else System.out.println("내역이 존재하지 않습니다.");
	}
		
	//장바구니 관리 - 전체 장바구니, 전체 매출액, 
	
	
}
