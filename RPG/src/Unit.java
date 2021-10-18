
import java.util.ArrayList;

public class Unit {
	public static Unit instance = new Unit();
	ArrayList<Player> player = new ArrayList<>();
	//ä�� : 15~20
	//���ݷ� : 5~8
	//���� : 5~8
	public void playerSet() {//���� ����
		Player py = new Player("���Ǹ�", 15, 5, 6, 1001);
		this.player.add(py);
		py = new Player("������", 17, 5, 5, 1002);
		this.player.add(py);
		py = new Player("�躸��", 20, 5, 8, 1003);
		this.player.add(py);
		py = new Player("������", 18, 6, 7, 1004);
		this.player.add(py);
		py = new Player("���ѿ�", 19, 7, 8, 1005);
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
		String first[] = {"��", "��", "��", "��", "��", "��", "��", "��", "��"};
		String midle[] = {"��", "��", "��", "��", "��", "��", "��", "��", "��"};
		String last[] = {"��", "��", "��", "��", "��", "��", "��", "��", "��"};
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
		System.out.println("�߰� �Ϸ�!");
	}
	
	public void playerRemove() {
		while(true) {
			int cnt = 0;
			for(int i=0; i<this.player.size(); i++) {
				System.out.printf("(%d)",(cnt+1));
				cnt++;
				this.player.get(i).printPlayer();
			}
			System.out.printf("(%d)�ڷΰ���\n",cnt+1);
			System.out.print("��ȣ �Է� : ");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input)-1;
				if(num>=0 && num<this.player.size()) {
					if(this.player.size()>4) {
						for(int i=0; i<3; i++) {//���� ��� ���� �� �κ��丮 �ͼ�
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
					else System.out.println("��Ƽ �ο����� ���� ������ ������ �� �����ϴ�.");
				}
				else if(num == this.player.size()) {
				break;	
				}
				else System.out.println("�߸��� ��ȣ �Դϴ�.");
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
		System.out.printf("(%d)�ڷΰ���\n",(Main.gd.inven.size()+1));
		while(true) {
		System.out.print("��ȣ �Է� : ");
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input)-1;
			if(num>=0 && num < Main.gd.inven.size()) {
				
				break;
			}
			else if(num==Main.gd.inven.size()) {
				break;
			}
			else System.out.println("�߸��� ��ȣ �Դϴ�.");
		}catch (Exception e) {
		}
		}
	}
	
	public void PlayerItemCheck() {
		
	}
	
	public void PlayerItemRemove() {
		
	}
	
	
	
}