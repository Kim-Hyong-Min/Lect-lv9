package game;

import java.util.ArrayList;

public class Unit {
	public static Unit instance = new Unit();
	private Guild gd = Guild.instance;
	private Shop sp = Shop.instance;
	public static ArrayList<Player> player = new ArrayList<>();
	//ä?? : 15~20
	//???ݷ? : 5~8
	//?????? : 5~8
	
	public void playerReset() {
		this.player.clear();
	}
	
	public void playerSet() {//???? ????
		Player py = new Player("???Ǹ?", 15, 5, 6, 1001);
		this.player.add(py);
		py = new Player("??????", 17, 5, 5, 1002);
		this.player.add(py);
		py = new Player("?躸??", 20, 5, 8, 1003);
		this.player.add(py);
		py = new Player("??????", 18, 6, 7, 1004);
		this.player.add(py);
		py = new Player("???ѿ?", 19, 7, 8, 1005);
		this.player.add(py);
		partyCheck();
	}
	
	public void partyCheck() {
		int cnt = 4;
		while(cnt>0) {
			int rNum = Main.rn.nextInt(this.player.size());
			if(this.player.get(rNum).getPlayerParty()==false) {
				this.player.get(rNum).setPlayerParty();
				cnt--;
			}
		}
	}
	
	public void playerAdd() {
		String first[] = {"??", "??", "??", "??", "??", "??", "??", "??", "??"};
		String midle[] = {"??", "??", "??", "??", "??", "??", "??", "??", "??"};
		String last[] = {"??", "??", "??", "??", "??", "??", "??", "??", "??"};
		int rNum1 = Main.rn.nextInt(first.length);
		int rNum2 = Main.rn.nextInt(midle.length);
		int rNum3 = Main.rn.nextInt(last.length);
		
		String name = "";
		name += first[rNum1];
		name += midle[rNum2];
		name += last[rNum3];
		
		int maxHp = Main.rn.nextInt(5)+15;
		int atk = Main.rn.nextInt(3)+5;
		int def = Main.rn.nextInt(3)+5;
		int playerCode = 0;
		while(true) {
		int check = -1;
		playerCode = Main.rn.nextInt(8999)+1000;
		for(int i=0; i<this.player.size(); i++) {
			if(playerCode==this.player.get(i).getPlayerCode()) {
				check = i;
			}
		}
		if(check == -1) {
			break;
		}
		}
		Player py = new Player(name, maxHp, atk, def, playerCode);
		this.player.add(py);
		if(this.player.size()<=4) {
			for(int i=0; i<this.player.size(); i++) {
				if(this.player.get(i).getPlayerParty()==false) {
					this.player.get(i).setPlayerParty();
					break;
				}
			}
		}
		System.out.println("?߰? ?Ϸ?!");
	}
	
	public void playerRemove() {
		while(true) {
			int cnt = 0;
			for(int i=0; i<this.player.size(); i++) {
				System.out.printf("(%d)",(cnt+1));
				cnt++;
				this.player.get(i).printPlayer();
			}
			System.out.printf("(%d)?ڷΰ???\n",cnt+1);
			System.out.print("??ȣ ?Է? : ");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input)-1;
				if(num>=0 && num<this.player.size()) {
						for(int i=0; i<3; i++) {//???? ???? ???? ?? ?κ??丮 ?ͼ?
							if(this.player.get(num).getPlayerItem(i) != 0) {
								int check = -1;
								for(int j=0; j<gd.inven.size(); j++) {
									if(this.player.get(num).getPlayerItem(i) == gd.inven.get(j).getItemCode()) {
										gd.inven.get(j).setItemCnt(1);
										check = j;
									}
								}
								if(check == -1) {
									String name = "";
									int atk = 0;
									int def = 0;
									for(int j=0; j<sp.item.size(); j++) {
										if(this.player.get(num).getPlayerItem(i)==sp.item.get(j).getItemCode()) {
											name = sp.item.get(j).getName();
											atk = sp.item.get(j).getAtk();
											def = sp.item.get(j).getDef();
										}
									}
									Inventory item = new Inventory(name, atk, def, this.player.get(num).getPlayerItem(i), 1);
									gd.inven.add(item);
								}
							}
						}
						if(this.player.get(num).getPlayerParty()==true) {
							for(int i=0; i<this.player.size(); i++) {
								if(this.player.get(i).getPlayerParty()==false) {
									this.player.get(i).setPlayerParty();
									break;
								}
							}
							this.player.remove(num);
						}
						else {
							this.player.remove(num);
						}
						System.out.println("?ذ? ?Ϸ?!");
					break;
				}
				else if(num == this.player.size()) {
				break;	
				}
				else System.out.println("?߸??? ??ȣ ?Դϴ?.");
			}catch (Exception e) {
			}
		}
	}
	
	public void allPlayer() {
		for(int i=0; i<this.player.size(); i++) {
			this.player.get(i).printPlayer();
		}
	}
	
	public void PlayerItemChoice(int itemType, int itemCode) {
			for(int i=0; i<this.player.size(); i++) {
				System.out.printf("(%d) ",i+1);
				this.player.get(i).printPlayerItem();
			}
			System.out.printf("(%d) ?ڷΰ???\n",(this.player.size()+1));
			while(true) {
			System.out.print("??ȣ ?Է? : ");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input)-1;
				if(num>=0 && num < this.player.size()) {
					if(this.player.get(num).getPlayerItem(itemType)==0) {
						this.player.get(num).setPlayerItem(itemType, itemCode);
						this.player.get(num).PlayerItemAdd(itemCode);
						System.out.println("???? ?Ϸ?!");
						break;
					}
					else {
						System.out.println("?̹? ?????? ?????? ?????մϴ?.");
					}
				}
				else if(num==this.player.size()) {
					break;
				}
				else System.out.println("?߸??? ??ȣ ?Դϴ?.");
			}catch (Exception e) {
			}
		}
	}
	
	public void PlayerItemRemove() {
		for(int i=0; i<this.player.size(); i++) {
			System.out.printf("(%d) ",i+1);
			this.player.get(i).printPlayerItem();
		}
		System.out.printf("(%d) ?ڷΰ???\n",(this.player.size()+1));
		while(true) {
		System.out.print("??ȣ ?Է? : ");
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num < this.player.size()) {
				int check = -1;
				for(int i=0; i<3; i++) {
					if(this.player.get(num).getPlayerItem(i) != 0) {
						check=i;
					}
				}
				if(check != -1) {
					PlayerItemRemoveChoice(num);
					break;
				}
				else System.out.println("?ش? ???????? ???????? ?????? ?????ϴ?.");
			}
			else if(num==this.player.size()) {
				break;
			}
			else System.out.println("?߸??? ??ȣ ?Դϴ?.");
		}catch (Exception e) {
		}
		}
	}
	
	public void PlayerItemRemoveChoice(int num) {
		int cnt = 1;
		int itemList[] = new int[3];
		for(int i=0; i<3; i++) {
			if(player.get(num).getPlayerItem(i) != 0) {
				System.out.println(cnt+". ["+player.get(num).getPlayerItemName(i)+"]");
			}
			else {
				System.out.println(cnt+". [????]");
			}
				itemList[cnt-1] = player.get(num).getPlayerItem(i);
				cnt++;
		}
		System.out.printf("(%d) ?ڷΰ???\n",cnt);
		while(true) {
		System.out.print("??ȣ ?Է? : ");
		String input = Shop.sc.next();
		try {
			int idx = Integer.parseInt(input);
			if(idx>0 && idx < cnt) {
				if(player.get(num).getPlayerItem(idx-1) != 0) {
					player.get(num).PlayerItemRemove(itemList[idx-1]);
					player.get(num).setPlayerItem(idx-1, 0);
					String name = "";
					int atk = 0;
					int def = 0;
					for(int i=0; i<Shop.item.size(); i++) {
						if(Shop.item.get(i).getItemCode() == itemList[idx-1]) {
							name = Shop.item.get(i).getName();
							atk = Shop.item.get(i).getAtk();
							def = Shop.item.get(i).getDef();
						}
					}
					setGuildInven(name, atk, def, itemList[idx-1]);
					System.out.println("Ż?? ????!");
					break;
				}
				else System.out.println("?????? ?????? ?????ϴ?.");
			}
			else if(idx == cnt) {
				break;
			}
			else System.out.println("?߸??? ??ȣ ?Դϴ?.");
		}catch (Exception e) {
		}
		}
		
	}
	
	public void setGuildInven(String name, int atk, int def, int itemCode) {
		if(gd.inven.size()==0) {
			Inventory it = new Inventory(name, atk, def, itemCode, 1);
			gd.inven.add(it);
		}
		else {
			int check = -1;
			for(int i=0; i<gd.inven.size(); i++) {
				if(gd.inven.get(i).getItemCode()== itemCode) {
					check = i;
				}
			}
			if(check != -1) {
				gd.inven.get(check).setItemCnt(1);
			}
			else {
				Inventory it = new Inventory(name, atk, def, itemCode, 1);
				gd.inven.add(it);
			}
		}
	}
	
	public void PlayerLineUp() {
		System.out.println("(1)?̸??? ????\n(2)?????? ????\n(3)??Ƽ?? ????\n(4)?ڷΰ???");
		while(true) {
		System.out.print("??ȣ ?Է? : ");
		String input = Shop.sc.next();
		try {
			int idx = Integer.parseInt(input);
			if(idx == 1) {//?̸???
				for(int i=0; i<this.player.size(); i++) {
					for(int j=0; j<this.player.size(); j++) {
						if(this.player.get(i).getPlayerNameNum()<this.player.get(j).getPlayerNameNum()) {
							Player temp = this.player.get(i);
							this.player.set(i, this.player.get(j));
							this.player.set(j, temp);
						}
					}
				}
				System.out.println("???? ?Ϸ?!");
				break;
			}
			else if(idx == 2) {//??????
				for(int i=0; i<this.player.size(); i++) {
					for(int j=0; j<this.player.size(); j++) {
						if(this.player.get(i).getPlayerLevel()>this.player.get(j).getPlayerLevel()) {
							Player temp = this.player.get(i);
							this.player.set(i, this.player.get(j));
							this.player.set(j, temp);
						}
					}
				}
				System.out.println("???? ?Ϸ?!");
				break;
			}
			else if(idx == 3) {//??Ƽ??
				for(int i=0; i<this.player.size(); i++) {
					for(int j=0; j<this.player.size(); j++) {
						if(this.player.get(i).getPlayerParty()==true && this.player.get(j).getPlayerParty()==false) {
							Player temp = this.player.get(i);
							this.player.set(i, this.player.get(j));
							this.player.set(j, temp);
						}
					}
				}
				System.out.println("???? ?Ϸ?!");
				break;
			}
			else if(idx == 4) {
				break;
			}
			else System.out.println("?߸??? ??ȣ ?Դϴ?.");
		}catch (Exception e) {
		}
		}
	}
	
}