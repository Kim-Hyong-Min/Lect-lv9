package controller;

import java.util.ArrayList;

import models.item;
import models.shop;

public class itemManager {
	public static itemManager instance = new itemManager();
	
	ArrayList<item>items = new ArrayList<>();
	//카테고리 관리 - 전체 카테고리, 카테고리 추가, 카테고리 삭제
	public void printManage() {
		System.out.println("1.카테고리 관리\n2.아이템 관리\n3.장바구니 관리");
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
		
	//장바구니 관리 - 전체 장바구니, 전체 매출액, 
	
	
}
