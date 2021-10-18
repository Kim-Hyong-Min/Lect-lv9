package game;
import java.util.ArrayList;

public class Guild {
	public static Guild instance = new Guild();
	private Unit ut = Unit.instance;
	ArrayList<Inventory> inven = new ArrayList<>();
	private String gulidName;
	private int playerCode;
	private int guildMoney;
	private final int maxParty = 4;
	
	Guild(){
	}
	
	public int getGuildMoney() {
		return this.guildMoney;
	}
	
	public void setGuildMoney(int itemCode, int money) {
		if(this.guildMoney-money>=0) {
			if(this.inven.size()==0) {
				this.guildMoney-= money;
				Inventory it = new Inventory(itemCode, 1);
				this.inven.add(it);
				System.out.println("구매 완료!");
			}
			else {
				int check = -1;
				for(int i=0; i<this.inven.size(); i++) {
					if(this.inven.get(i).getItemCode()== itemCode) {
						check = i;
					}
				}
				if(check != -1) {
					this.inven.get(check).setItemCnt(1);
					this.guildMoney-= money;
					System.out.println("구매 완료!");
				}
				else {
					Inventory it = new Inventory(itemCode, 1);
					this.inven.add(it);
					this.guildMoney-= money;
					System.out.println("구매 완료!");
				}
			}
			
		}
		else System.out.println("보유금액이 부족합니다.");
	}
	
	public void setGuildInven(int itemCode) {
		if(this.inven.size()==0) {
			Inventory it = new Inventory(itemCode, 1);
			this.inven.add(it);
		}
		else {
			int check = -1;
			for(int i=0; i<this.inven.size(); i++) {
				if(this.inven.get(i).getItemCode()== itemCode) {
					check = i;
				}
			}
			if(check != -1) {
				this.inven.get(check).setItemCnt(1);
			}
			else {
				Inventory it = new Inventory(itemCode, 1);
				this.inven.add(it);
			}
		}
	}
	
	public void guildTitle() {
		System.out.printf("========[%s]========\n",this.gulidName);
	}
	
	public void printGuildMoney() {
		System.out.printf("길드 보유금액 : %dg\n",this.guildMoney);
	}
	
//	길드관리
//	ㄴ 길드목록, 길드원추가, 길드원삭제, 파티원교체, 정렬
	public void guildMenu() {
		while(true) {
			System.out.println("1.길드원 목록\n2.길드원 영입\n3.길드원 해고\n4.정렬\n5.뒤로가기");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//길드원 목록
					guildList();
				}
				else if(num==2) {//길드원 영입
					guildAdd();
				}
				else if(num==3) {//길드원 해고
					guildRemove();
				}
				else if(num==4) {//정렬
					guildLineup();
				}
				else if(num==5) {//뒤로가기
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	
	public void guildSet(){ // 길드 아이템 리스트
		this.gulidName = "그린컴퓨터";
		this.guildMoney = 100000;
	}
	
	public void inventoryMenu() {
		while(true) {
			System.out.println("1.장비 목록\n2.장비 입기\n3.장비 벗기\n4.뒤로가기");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//장비 목록
					itemList();
				}
				else if(num==2) {//장비 입기
					ut.PlayerItemAdd();
				}
				else if(num==3) {//장비 벗기
					ut.PlayerItemRemove();
				}
				else if(num==4) {//뒤로가기
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void itemList(){ // 길드 아이템 리스트
		if(this.inven.size()>0) {
			for(int i=0; i<this.inven.size(); i++){
				for(int j=0; j<Shop.item.size(); j++) {
					if(this.inven.get(i).getItemCode()==Shop.item.get(j).getItemCode()) {
						if(this.inven.get(i).getItemCode()/1000==1) {//무기
							System.out.printf("(%d) [%s] 공격력 : %d / 수량 : %d개\n", (i+1), Shop.item.get(j).getName(), Shop.item.get(j).getAtk(), this.inven.get(i).getItemCnt());
						}
						else if(this.inven.get(i).getItemCode()/1000==2) {//갑옷
							System.out.printf("(%d) [%s] 방어력 : %d / 수량 : %d개\n", (i+1), Shop.item.get(j).getName(), Shop.item.get(j).getDef(), this.inven.get(i).getItemCnt());
						}
						else if(this.inven.get(i).getItemCode()/1000==3) {//반지
							System.out.printf("(%d) [%s] 공격력 : %d / 방어력 : %d / 수량 : %d개\n", (i+1), Shop.item.get(j).getName(), Shop.item.get(j).getAtk(), Shop.item.get(j).getDef(), this.inven.get(i).getItemCnt());
						}
					}
				}
			}
		}
		else System.out.println("보유중인 장비가 없습니다.");
	}
	
	public void guildList() {//길드원 목록
		System.out.println("====================================================================");
		System.out.printf("전체 길드원 : %d명\n",ut.player.size());
		ut.allPlayer();
		System.out.println("====================================================================");
	}
	
	public void guildAdd() {//길드원 영입
		ut.playerAdd();
	}
	
	public void guildRemove() {//길드원 해고
		ut.playerRemove();
	}
	
	public void guildLineup() {//정렬
		ut.PlayerLineUp();
	}
}