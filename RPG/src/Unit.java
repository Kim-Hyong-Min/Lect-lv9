
import java.util.ArrayList;

public class Unit {
	public static Unit instance = new Unit();
	ArrayList<Player> player = new ArrayList<>();
	//채력 : 15~20
	//공격력 : 5~8
	//방어력 : 5~8
	public void playerSet() {//기존 유닛
		Player py = new Player("강건마", 15, 5, 6, 1001);
		this.player.add(py);
		py = new Player("김형민", 17, 5, 5, 1002);
		this.player.add(py);
		py = new Player("김보선", 20, 5, 8, 1003);
		this.player.add(py);
		py = new Player("정기태", 18, 6, 7, 1004);
		this.player.add(py);
		py = new Player("정한울", 19, 7, 8, 1005);
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
		String first[] = {"김", "이", "최", "박", "정", "한", "진", "고", "유"};
		String midle[] = {"영", "상", "명", "문", "민", "형", "기", "우", "기"};
		String last[] = {"삼", "하", "희", "수", "경", "민", "한", "리", "태"};
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
		System.out.println("추가 완료!");
	}
	
	public void playerRemove() {
		while(true) {
			int cnt = 0;
			for(int i=0; i<this.player.size(); i++) {
				System.out.printf("(%d)",(cnt+1));
				cnt++;
				this.player.get(i).printPlayer();
			}
			System.out.printf("(%d)뒤로가기\n",cnt+1);
			System.out.print("번호 입력 : ");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input)-1;
				if(num>=0 && num<this.player.size()) {
					if(this.player.size()>4) {
						for(int i=0; i<3; i++) {//착용 장비 해제 후 인벤토리 귀속
							if(this.player.get(num).getPlayerItem(i) != 0) {
								int check = -1;
								for(int j=0; j<Main.gd.inven.size(); j++) {
									if(this.player.get(num).getPlayerItem(i) == Main.gd.inven.get(j).getItemCode()) {
										Main.gd.inven.get(j).setItemCnt(1);
										check = j;
									}
								}
								if(check == -1) {
									Inventory item = new Inventory(this.player.get(num).getPlayerItem(i), 1);
									Main.gd.inven.add(null);
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
					}
					else System.out.println("파티 인원보다 적은 길드원을 가지실 수 없습니다.");
				}
				else if(num == this.player.size()) {
				break;	
				}
				else System.out.println("잘못된 번호 입니다.");
			}catch (Exception e) {
			}
		}
	}
	
	public void allPlayer() {
		for(int i=0; i<this.player.size(); i++) {
			this.player.get(i).printPlayer();
		}
	}
	
	public void PlayerItemAdd() {
		Main.gd.itemList();
		System.out.printf("(%d) 뒤로가기\n",(Main.gd.inven.size()+1));
		while(true) {
		System.out.print("번호 입력 : ");
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num < Main.gd.inven.size()) {
				PlayerItemChoice(Main.gd.inven.get(num).getItemType()-1, Main.gd.inven.get(num).getItemCode());
				if(Main.gd.inven.get(num).getItemCnt()>1) {
					Main.gd.inven.get(num).setItemCnt(-1);
				}
				else {
					Main.gd.inven.remove(num);
				}
				break;
			}
			else if(num==Main.gd.inven.size()) {
				break;
			}
			else System.out.println("잘못된 번호 입니다.");
		}catch (Exception e) {
		}
		}
	}
	
	public void PlayerItemChoice(int itemType, int itemCode) {
			for(int i=0; i<this.player.size(); i++) {
				System.out.printf("(%d) ",i+1);
				this.player.get(i).printPlayerItem();
			}
			System.out.printf("(%d) 뒤로가기\n",(this.player.size()+1));
			while(true) {
			System.out.print("번호 입력 : ");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input)-1;
				if(num>=0 && num < this.player.size()) {
					if(this.player.get(num).getPlayerItem(itemType)==0) {
						this.player.get(num).setPlayerItem(itemType, itemCode);
						this.player.get(num).PlayerItemAdd(itemCode);
						System.out.println("착용 완료!");
						break;
					}
					else {
						System.out.println("이미 착용한 장비가 존재합니다.");
					}
				}
				else if(num==this.player.size()) {
					break;
				}
				else System.out.println("잘못된 번호 입니다.");
			}catch (Exception e) {
			}
		}
	}
	
	public void PlayerItemRemove() {
		for(int i=0; i<this.player.size(); i++) {
			System.out.printf("(%d) ",i+1);
			this.player.get(i).printPlayerItem();
		}
		System.out.printf("(%d) 뒤로가기\n",(this.player.size()+1));
		while(true) {
		System.out.print("번호 입력 : ");
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
				else System.out.println("해당 길드원이 착용중인 장비가 없습니다.");
			}
			else if(num==this.player.size()) {
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
			if(this.player.get(num).getPlayerItem(i) != 0) {
				itemList[cnt-1] = this.player.get(num).getPlayerItem(i);
				System.out.println(cnt+". ["+this.player.get(num).getPlayerItemName(i)+"]");
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
				this.player.get(num).PlayerItemRemove(itemList[idx-1]);
				this.player.get(num).setPlayerItem(idx-1, 0);
				Main.gd.setGuildInven(itemList[idx-1]);
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
	
	
	
}