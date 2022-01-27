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
		System.out.printf("���� : %d��\n�����Ͻ� �ݾ� : %dg\n�������� ��� : %d��\n",ut.player.size(), guildMoney, inven.size());
		System.out.println("====================");
	}
	
	public void setGuildMoney(String name, int atk, int def, int itemCode, int money) {
		if(this.guildMoney-money>=0) {
			if(this.inven.size()==0) {
				this.guildMoney-= money;
				Inventory it = new Inventory(name, atk, def, itemCode, 1);
				this.inven.add(it);
				System.out.println("���� �Ϸ�!");
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
					System.out.println("���� �Ϸ�!");
				}
				else {
					Inventory it = new Inventory(name, atk, def, itemCode, 1);
					this.inven.add(it);
					this.guildMoney-= money;
					System.out.println("���� �Ϸ�!");
				}
			}
			
		}
		else System.out.println("�����ݾ��� �����մϴ�.");
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
		System.out.printf("��� �����ݾ� : %dg\n",this.guildMoney);
	}
	
//	������
//	�� �����, �����߰�, ��������, ��Ƽ����ü, ����
	public void guildMenu() {
		while(true) {
			printGuild();
			System.out.println("1.���� ���\n2.���� ����\n3.���� �ذ�\n4.����\n5.�ڷΰ���");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//���� ���
					guildList();
				}
				else if(num==2) {//���� ����
					guildAdd();
				}
				else if(num==3) {//���� �ذ�
					guildRemove();
				}
				else if(num==4) {//����
					guildLineup();
				}
				else if(num==5) {//�ڷΰ���
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	
	public void guildSet(){ // ��� ������ ����Ʈ
		this.gulidName = "RPG ����";
		this.guildMoney = 100000;
	}
	
	public void guildSet(String title, int money){
		this.gulidName = title;
		this.guildMoney = money;
	}
	
	public void inventoryMenu() {
		while(true) {
			printGuild();
			System.out.println("1.��� ���\n2.��� �Ա�\n3.��� ����\n4.��� �Ǹ�\n5.�ڷΰ���");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//��� ���
					itemList();
				}
				else if(num==2) {//��� �Ա�
					PlayerItemAdd();
				}
				else if(num==3) {//��� ����
					ut.PlayerItemRemove();
				}
				else if(num==4) {//�ڷΰ���
					itemSell();
				}
				else if(num==5) {//�ڷΰ���
					break;
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void itemList(){ // ��� ������ ����Ʈ
		if(this.inven.size()>0) {
			for(int i=0; i<this.inven.size(); i++){
				if(this.inven.get(i).getItemCode()/1000==1) {//����
					System.out.printf("(%d) [%s] ���ݷ� : %d / ���� : %d��\n", (i+1), this.inven.get(i).getItemName(), this.inven.get(i).getAtk(), this.inven.get(i).getItemCnt());
				}
				else if(this.inven.get(i).getItemCode()/1000==2) {//����
					System.out.printf("(%d) [%s] ���� : %d / ���� : %d��\n", (i+1), this.inven.get(i).getItemName(), this.inven.get(i).getDef(), this.inven.get(i).getItemCnt());
				}
				else if(this.inven.get(i).getItemCode()/1000==3) {//����
					System.out.printf("(%d) [%s] ���ݷ� : %d / ���� : %d / ���� : %d��\n", (i+1), this.inven.get(i).getItemName(), this.inven.get(i).getAtk(), this.inven.get(i).getDef(), this.inven.get(i).getItemCnt());
				}
			}
		}
		else System.out.println("�������� ��� �����ϴ�.");
	}
	
	public void PlayerItemAdd() {
		itemList();
		System.out.printf("(%d) �ڷΰ���\n",(inven.size()+1));
		while(true) {
		System.out.print("��ȣ �Է� : ");
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
			else System.out.println("�߸��� ��ȣ �Դϴ�.");
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
		System.out.printf("(%d) �ڷΰ���\n",cnt);
		while(true) {
		System.out.print("��ȣ �Է� : ");
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
			else System.out.println("�߸��� ��ȣ �Դϴ�.");
		}catch (Exception e) {
		}
		}
	}
	
	public void itemSell() {
		itemList();
		System.out.printf("(%d) �ڷΰ���\n",(inven.size()+1));
		while(true) {
		System.out.print("��ȣ �Է� : ");
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
				System.out.println("�Ǹ� �Ϸ�!");
				break;
			}
			else if(num==inven.size()) {
				break;
			}
			else System.out.println("�߸��� ��ȣ �Դϴ�.");
		}catch (Exception e) {
		}
		}
	}
	
	
	public void guildList() {//���� ���
		System.out.println("====================================================================");
		System.out.printf("��ü ���� : %d��\n",ut.player.size());
		ut.allPlayer();
		System.out.println("====================================================================");
	}
	
	public void guildAdd() {//���� ����
		ut.playerAdd();
	}
	
	public void guildRemove() {//���� �ذ�
		ut.playerRemove();
	}
	
	public void guildLineup() {//����
		ut.PlayerLineUp();
	}
}