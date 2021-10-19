package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	public static Shop instance = new Shop();
	private Guild gd = Guild.instance;
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Item>item = new ArrayList<>();
	
//	상점
//	ㄴ 무기, 갑옷, 반지
	
	public void shopReset() {
		this.item.clear();
	}
	
	public void shopMenu() {
		while(true) {
			gd.printGuild();
			System.out.println("1.무기\n2.갑옷\n3.반지\n4.뒤로가기");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//무기
					weapon();
				}
				else if(num==2) {//갑옷
					armor();
				}
				else if(num==3) {//반지
					ring();
				}
				else if(num==4) {//뒤로가기
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void weaponSet() {// 초기 상점무기
		Item newItem = new Item("나무검", 1, 0, 100, 1001);
		item.add(newItem);
		newItem = new Item("철검", 3, 0, 300, 1002);
		item.add(newItem);
		newItem = new Item("레이피어", 5, 0, 450, 1003);
		item.add(newItem);
		newItem = new Item("대검", 7, 0, 600, 1004);
		item.add(newItem);
		newItem = new Item("가시검", 9, 0, 800, 1005);
		item.add(newItem);
		newItem = new Item("황금검", 11, 0, 1000, 1006);
		item.add(newItem);
		newItem = new Item("화염의검", 15, 0, 1500, 1007);
		item.add(newItem);
	}
	
	public void armorSet() {// 초기 상점갑옷
		Item newItem = new Item("헌옷", 0, 1, 100, 2001);
		item.add(newItem);
		newItem = new Item("가죽옷", 0, 2, 300, 2002);
		item.add(newItem);
		newItem = new Item("철갑옷", 0, 5, 450, 2003);
		item.add(newItem);
		newItem = new Item("무쇠갑옷", 0, 8, 600, 2004);
		item.add(newItem);
		newItem = new Item("황금갑옷", 0, 10, 800, 2005);
		item.add(newItem);
		newItem = new Item("루비갑옷", 0, 12, 1000, 2006);
		item.add(newItem);
		newItem = new Item("다이아갑옷", 0, 18, 1500, 2007);
		item.add(newItem);
	}
	
	public void ringSet() {// 초기 상점반지
		Item newItem = new Item("나무반지", 1, 1, 200, 3001);
		item.add(newItem);
		newItem = new Item("철반지", 1, 2, 350, 3002);
		item.add(newItem);
		newItem = new Item("은반지", 2, 3, 600, 3003);
		item.add(newItem);
		newItem = new Item("금반지", 4, 4, 850, 3004);
		item.add(newItem);
		newItem = new Item("사파이어반지", 1, 8, 1000, 3005);
		item.add(newItem);
		newItem = new Item("에메랄드반지", 10, 2, 1500, 3006);
		item.add(newItem);
		newItem = new Item("다이아반지", 8, 8, 2000, 3007);
		item.add(newItem);
	}
	
	public void weapon() {//무기
		gd.printGuildMoney();
		int cnt = 0;
		for(int i=0; i<this.item.size(); i++) {
			if((this.item.get(i).getItemCode()/1000)==1) { // 무기 코드 체크
				System.out.printf("(%d) [%s] 공격력 : %d / 가격 : %dg\n",(cnt+1),this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getPrice());
				cnt++;
			}
		}
		System.out.printf("(%d)뒤로가기\n",cnt+1);
		while(true) {
		System.out.print("번호 입력 : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num<cnt) {
				int check = 0;
				for(int i=0; i<this.item.size(); i++) {
					if((this.item.get(i).getItemCode()/1000)==1) {
						if(check==num) {
							gd.setGuildMoney(this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getItemCode(), this.item.get(i).getPrice());
							break;
						}
						check++;
					}
				}
				break;
			}
			else if(num==cnt) {
				break;
			}
			else System.out.println("잘못된 번호 입니다.");
			
		}catch (Exception e) {
		}
		}
		
	}
	
	public void armor() {//갑옷
		gd.printGuildMoney();
		int cnt = 0;
		for(int i=0; i<this.item.size(); i++) {
			if((this.item.get(i).getItemCode()/1000)==2) { // 갑옷 코드 체크
				System.out.printf("(%d) [%s] 방어력 : %d / 가격 : %dg\n",(cnt+1),this.item.get(i).getName(), this.item.get(i).getDef(), this.item.get(i).getPrice());
				cnt++;
			}
		}
		System.out.printf("(%d)뒤로가기\n",cnt+1);
		while(true) {
		System.out.print("번호 입력 : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num<cnt) {
				int check = 0;
				for(int i=0; i<this.item.size(); i++) {
					if((this.item.get(i).getItemCode()/1000)==2) {
						if(check==num) {
							gd.setGuildMoney(this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getItemCode(), this.item.get(i).getPrice());
							break;
						}
						check++;
					}
				}
				break;
			}
			else if(num==cnt) {
				break;
			}
			else System.out.println("잘못된 번호 입니다.");
			
		}catch (Exception e) {
		}
		}
	}
	
	public void ring() {//반지
		gd.printGuildMoney();
		int cnt = 0;
		for(int i=0; i<this.item.size(); i++) {
			if((this.item.get(i).getItemCode()/1000)==3) { // 갑옷 코드 체크
				System.out.printf("(%d) [%s] 공격력 : %d / 방어력 : %d / 가격 : %dg\n",(cnt+1),this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getPrice());
				cnt++;
			}
		}
		System.out.printf("(%d)뒤로가기\n",cnt+1);
		while(true) {
		System.out.print("번호 입력 : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num<cnt) {
				int check = 0;
				for(int i=0; i<this.item.size(); i++) {
					if((this.item.get(i).getItemCode()/1000)==3) {
						if(check==num) {
							gd.setGuildMoney(this.item.get(i).getName(), this.item.get(i).getAtk(), this.item.get(i).getDef(), this.item.get(i).getItemCode(), this.item.get(i).getPrice());
							break;
						}
						check++;
					}
				}
				break;
			}
			else if(num==cnt) {
				break;
			}
			else System.out.println("잘못된 번호 입니다.");
			
		}catch (Exception e) {
		}
		}
	}
}