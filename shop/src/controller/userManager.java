package controller;

import java.util.ArrayList;

import models.cart;
import models.shop;
import models.user;

public class userManager {
	public static userManager instance = new userManager();
	private shopManager sm = shopManager.instance;
	private fileManager fm = fileManager.instance;
	ArrayList<user>users = new ArrayList<>();
	ArrayList<cart>cart = new ArrayList<>();
	
	public int getUserCode() {
		return this.users.get(shop.log).getUserCode();
	}
	
	//가입
	
	public void joinUser() {
		System.out.print("ID 입력 : ");
		String id = shop.sc.next();
		System.out.print("PW 입력 : ");
		String pw = shop.sc.next();
		
		if(this.users.size()==0) {
			int rNum = shop.rn.nextInt(8999)+1000;//코드부여
			user data = new user(id,pw,rNum);
			this.users.add(data);
			System.out.println("가입 완료!");
			fm.userSave(); // 저장
		}
		else {
			joinUserCheck(id, pw);
		}
	}
	
	private void joinUserCheck(String id, String pw) { // 유저 검사 및 가입처리
		int check = -1;
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).getId().equals(id)){
				check = i;
			}
		}
		if(check == -1) {
			while(true) {
				int rNum = shop.rn.nextInt(8999)+1000;//코드부여
				int rNumCheck = -1;
				for(int i=0; i<this.users.size(); i++) {
					if(this.users.get(i).getUserCode()==rNum){
						rNumCheck = i;
					}
				}
				if(rNumCheck==-1) {
					user data = new user(id,pw,rNum);
					this.users.add(data);
					System.out.println("가입 완료!");
					fm.userSave(); // 저장
					break;
				}
			}
		}
		else System.out.println("중복된 아이디가 존재합니다.");
	}
	
	//로그인
	public void loginUser() {
		if(shop.log==-1) {
			if(this.users.size()>0) {
				System.out.print("ID 입력 : ");
				String id = shop.sc.next();
				System.out.print("PW 입력 : ");
				String pw = shop.sc.next();
				
				int check = -1;
				for(int i=0; i<this.users.size(); i++) {
					if(this.users.get(i).getId().equals(id)){
						check = i;
					}
				}
				if(check != -1 && this.users.get(check).getPw().equals(pw)) {
					shop.log=check;
					System.out.println(id+"님 로그인 성공!");
				}
				else System.out.println("아이디나 비밀번호를 다시 확인해주세요.");
				
			}
			else System.out.println("가입된 인원이 없습니다.");
		}
		else System.out.println("로그인 중입니다.");
	}
	
	public void printLoginUser() {
		System.out.println(this.users.get(shop.log).getId()+"님 로그인중...");
	}
	
	//로그아웃
	public void logoutUser() {
		if(shop.log!=-1) {
			System.out.println(this.users.get(shop.log).getId()+"님 로그아웃 성공!");
			shop.log = -1;
		}
		else System.out.println("로그인 후 이용가능 합니다.");
	}
	
	//탈퇴
	public void outUser() {
		if(this.users.size()>0) {
			if(shop.log!=-1) {
				System.out.println("탈퇴 하시겠습니까?[Yes:1][No:2]");
				String select = shop.sc.next();
				try {
					int num = Integer.parseInt(select);
					if(num == 1) {
						this.users.remove(shop.log);
						shop.log=-1;
						System.out.println("탈퇴 완료!");
					}
					else if(num == 2) {
						System.out.println("많은 이용 부탁드립니다~");
					}
					
				}catch (Exception e) {
					System.out.println("잘못된 입력 입니다.");
				}
				
			}
			else System.out.println("로그인 후 이용가능 합니다.");
		}
		else System.out.println("가입된 인원이 없습니다.");
	}
	
	//관리자모드 - 유저관리 : , 유저추가, 유저삭제
	
	public void allUser() {//전체유저
		if(this.users.size()>0) {
			for(int i=0; i<this.users.size(); i++) {
				System.out.println("유저코드 : "+this.users.get(i).getUserCode()+"/ ID : "+this.users.get(i).getId()+"/ PW : "+this.users.get(i).getPw());
			}
		}
		else System.out.println("가입된 인원이 없습니다.");
	}
	
	
	public void userRemove() { // 유저삭제
		if(this.users.size()>0) {
			for(int i=0; i<this.users.size(); i++) {
				System.out.println((i+1)+". 유저코드 : "+this.users.get(i).getUserCode()+"/ ID : "+this.users.get(i).getId()+"/ PW : "+this.users.get(i).getPw());
			}
			System.out.print("번호 입력 : ");
			String idx = shop.sc.next();
			try {
				int num = Integer.parseInt(idx)-1;
				if(num>=0 && num<this.users.size()) {
					cartRemove(num);
					this.users.remove(num);
					System.out.println("삭제 완료!");
				}
				else System.out.println("잘못된 번호 입니다.");
			}catch (Exception e) {
			}
		}
		else System.out.println("가입된 인원이 없습니다.");
	}
	
	public void cartRemove(int number) {
		for(int i=0; i<cart.size(); i++) {
			if(this.users.get(number).getUserCode() == cart.get(i).getUserCode()) {
				cart.remove(i);
			}
		}
	}
	
	
}
