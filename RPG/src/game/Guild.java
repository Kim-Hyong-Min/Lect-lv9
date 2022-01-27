package game;
import java.util.ArrayList;

public class Guild {
	public static Guild instance = new Guild();
	private Shop sp = Shop.instance;
	private Unit ut = Unit.instance;
	public static ArrayList<Inventory> inven = new ArrayList<>();
	private String gulidName;
	private int guildMoney;
	private final int maxParty = 4;
	
	Guild(){
	}
	
	public void inventoryReset() {
		this.inven.clear();
	}
	
	public String getGulidName() {
		return this.gulidName;
	}
	
	public int getGuildMoney() {
		return this.guildMoney;
	}
	
	public void printGuild() {
		System.out.println("====================");
		System.out.printf("길드원 : %d명\n보유하신 금액 : %dg\n보유중인 장비 : %d개\n",ut.player.size(), guildMoney, inven.size());
		System.out.println("====================");
	}
	
	public void setGuildMoney(String name, int atk, int def, int itemCode, int money) {
		if(this.guildMoney-money>=0) {
			if(this.inven.size()==0) {
				this.guildMoney-= money;
				Inventory it = new Inventory(name, atk, def, itemCode, 1);
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
					Inventory it = new Inventory(name, atk, def, itemCode, 1);
					this.inven.add(it);
					this.guildMoney-= money;
					System.out.println("구매 완료!");
				}
			}
			
		}
		else System.out.println("보유금액이 부족합니다.");
	}
	
	public void setGuildInven(String name, int atk, int def, int itemCode) {
		if(inven.size()==0) {
			Inventory it = new Inventory(name, atk, def, itemCode, 1);
			inven.add(it);
		}
		else {
			int check = -1;
			for(int i=0; i<inven.size(); i++) {
				if(inven.get(i).getItemCode()== itemCode) {
					check = i;
				}
			}
			if(check != -1) {
				inven.get(check).setItemCnt(1);
			}
			else {
				Inventory it = new Inventory(name, atk, def, itemCode, 1);
				inven.add(it);
			}
		}
	}
	
	public void guildTitle() {
		System.out.printf("========[%s]========\n",this.gulidName);
		printGuild();
	}
	
	public void printGuildMoney() {
		System.out.printf("길드 보유금액 : %dg\n",this.guildMoney);
	}
	
//	길드관리
//	ㄴ 길드목록, 길드원추가, 길드원삭제, 파티원교체, 정렬
	public void guildMenu() {
		while(true) {
			printGuild();
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
		this.gulidName = "RPG 게임";
		this.guildMoney = 100000;
	}
	
	public void guildSet(String title, int money){
		this.gulidName = title;
		this.guildMoney = money;
	}
	
	public void inventoryMenu() {
		while(true) {
			printGuild();
			System.out.println("1.장비 목록\n2.장비 입기\n3.장비 벗기\n4.장비 판매\n5.뒤로가기");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//장비 목록
					itemList();
				}
				else if(num==2) {//장비 입기
					PlayerItemAdd();
				}
				else if(num==3) {//장비 벗기
					ut.PlayerItemRemove();
				}
				else if(num==4) {//뒤로가기
					itemSell();
				}
				else if(num==5) {//뒤로가기
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void itemList(){ // 길드 아이템 리스트
		if(this.inven.size()>0) {
			for(int i=0; i<this.inven.size(); i++){
				if(this.inven.get(i).getItemCode()/1000==1) {//무기
					System.out.printf("(%d) [%s] 공격력 : %d / 수량 : %d개\n", (i+1), this.inven.get(i).getItemName(), this.inven.get(i).getAtk(), this.inven.get(i).getItemCnt());
				}
				else if(this.inven.get(i).getItemCode()/1000==2) {//갑옷
					System.out.printf("(%d) [%s] 방어력 : %d / 수량 : %d개\n", (i+1), this.inven.get(i).getItemName(), this.inven.get(i).getDef(), this.inven.get(i).getItemCnt());
				}
				else if(this.inven.get(i).getItemCode()/1000==3) {//반지
					System.out.printf("(%d) [%s] 공격력 : %d / 방어력 : %d / 수량 : %d개\n", (i+1), this.inven.get(i).getItemName(), this.inven.get(i).getAtk(), this.inven.get(i).getDef(), this.inven.get(i).getItemCnt());
				}
			}
		}
		else System.out.println("보유중인 장비가 없습니다.");
	}
	
	public void PlayerItemAdd() {
		itemList();
		System.out.printf("(%d) 뒤로가기\n",(inven.size()+1));
		while(true) {
		System.out.print("번호 입력 : ");
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num < inven.size()) {
				ut.PlayerItemChoice(inven.get(num).getItemType()-1, inven.get(num).getItemCode());
				if(inven.get(num).getItemCnt()>1) {
					inven.get(num).setItemCnt(-1);
				}
				else {
					inven.remove(num);
				}
				break;
			}
			else if(num==inven.size()) {
				break;
			}
			else System.out.println("잘못된 번호 입니다.");
		}catch (Exception e) {
		}
		}
	}
	
	public void PlayerItemRemoveChoice(int num) {
		int cnt = 1;
		int itemList[] = new int[3];
		for(int i=0; i<3; i++) {
			if(ut.player.get(num).getPlayerItem(i) != 0) {
				itemList[cnt-1] = ut.player.get(num).getPlayerItem(i);
				System.out.println(cnt+". ["+ut.player.get(num).getPlayerItemName(i)+"]");
				cnt++;
			}
		}
		System.out.printf("(%d) 뒤로가기\n",cnt);
		while(true) {
		System.out.print("번호 입력 : ");
		String input = Shop.sc.next();
		try {
			int idx = Integer.parseInt(input);
			if(idx>0 && idx < cnt) {
				ut.player.get(num).PlayerItemRemove(itemList[idx-1]);
				ut.player.get(num).setPlayerItem(idx-1, 0);
				String name = "";
				int atk = 0;
				int def = 0;
				for(int i=0; i<sp.item.size(); i++) {
					if(this.sp.item.get(i).getItemCode() == itemList[idx-1]) {
						name = this.sp.item.get(i).getName();
						atk = this.sp.item.get(i).getAtk();
						def = this.sp.item.get(i).getDef();
					}
				}
				
				setGuildInven(name, atk, def, itemList[idx-1]);
				break;
			}
			else if(idx == cnt) {
				break;
			}
			else System.out.println("잘못된 번호 입니다.");
		}catch (Exception e) {
		}
		}
	}
	
	public void itemSell() {
		itemList();
		System.out.printf("(%d) 뒤로가기\n",(inven.size()+1));
		while(true) {
		System.out.print("번호 입력 : ");
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num < inven.size()) {
				int money = 0;
				for(int i=0; i<sp.item.size(); i++) {
					if(inven.get(num).getItemCode()==sp.item.get(i).getItemCode()) {
						money = sp.item.get(i).getPrice();
					}
				}
				inven.remove(num);
				guildMoney += money;
				System.out.println("판매 완료!");
				break;
			}
			else if(num==inven.size()) {
				break;
			}
			else System.out.println("잘못된 번호 입니다.");
		}catch (Exception e) {
		}
		}
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