package game;


public class Player {
	private Shop sp = Shop.instance;
	
//�̸�, ����, ���� ü��, �ִ� ü��, ���ݷ�, ����, ����ġ, ��Ƽ����
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int atk;
	private int def;
	private int exp;
	private boolean party;
	private int playerCode;
	private int[] playerItem = new int[3]; // 0:���� / 1:���� / 2:����
	// ����� ��� �κ��丮�� �ͼ�
	
	Player() {	
	}
	
	public Player(String name, int maxHp, int atk, int def, int playerCode){//ù ����
		this.name = name;
		this.level = 1;
		this.maxHp = maxHp;
		this.hp = this.maxHp;
		this.atk = atk;
		this.def = def;
		this.exp = 0;
		this.playerCode = playerCode;
	}
	
	public Player(String name, int level, int Hp, int maxHp, int atk, int def, int exp, String party, int playerCode, int item1, int item2, int item3 ) {
		this.name = name;
		this.level = level;
		this.hp = Hp;
		this.maxHp = maxHp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
		if(party.equals("true")) {
			this.party = true;
		}
		else if(party.equals("false")) {
			this.party = false;
		}
		this.playerCode = playerCode;
		this.playerItem[0] = item1;
		this.playerItem[1] = item1;
		this.playerItem[2] = item1;
	}
	
	
	public String getPlayerName() {
		return this.name;
	}
	
	public int getPlayerLevel() {
		return this.level;
	}
	
	public int getPlayerHp() {
		return this.hp;
	}
	
	public int getPlayerMaxHp() {
		return this.maxHp;
	}
	
	public int getPlayerAtk() {
		return this.atk;
	}
	
	public int getPlayerDef() {
		return this.def;
	}
	
	public int getPlayerExp() {
		return this.exp;
	}
	
	public int getPlayerCode() {
		return this.playerCode;
	}
	
	public boolean getPlayerParty() {
		return this.party;
	}
	
	public int getPlayerNameNum() {
		int num = this.name.charAt(0);
		return num;
	}
	
	public int getPlayerItem(int idx) {
		return this.playerItem[idx];
	}
	
	 public String getPlayerItemName(int idx) {
		  String item = "";
		  for(int i=0; i<sp.item.size(); i++) {
			  if(this.playerItem[idx] == sp.item.get(i).getItemCode()) {
				  item += sp.item.get(i).getName();
			  }
		  }
		  return item;
	  }
	
	public void setPlayerParty() {
		this.party = true;
	}
	
	public void setPlayerItem(int idx, int itemCode) {
		this.playerItem[idx] = itemCode;
	}
	
	
	public void printPlayer() {
		if(this.party==true) {
			System.out.print("[��Ƽ] ");
		}
		System.out.printf("[%s] [Lv.%d] [HP:%d/%d] [ATK:%d] [DEF:%d] [EXP:%d] ",this.name, this.level, this.hp, this.maxHp, this.atk, this.def, this.exp);
		for(int i=0; i<this.playerItem.length; i++) {
			if(i==0) {
				System.out.print("[����:");
			}
			else if(i==1) {
				System.out.print("[����:");
			}
			else if(i==2) {
				System.out.print("[����:");
			}
			if(this.playerItem[i]!=0) {
				for(int j=0; j<sp.item.size(); j++) {
					if(this.playerItem[i]==sp.item.get(j).getItemCode()) {
						System.out.printf("%s] ",sp.item.get(j).getName());
					}
				}
			}
			else System.out.print("����] ");
		}
		System.out.println();
	}
	
	public void printPlayerItem() {
		System.out.printf("[%s] [Lv.%d] [HP:%d/%d] [ATK:%d] [DEF:%d] [EXP:%d] ",this.name, this.level, this.hp, this.maxHp, this.atk, this.def, this.exp);
		for(int i=0; i<this.playerItem.length; i++) {
			if(i==0) {
				System.out.print("[����:");
			}
			else if(i==1) {
				System.out.print("[����:");
			}
			else if(i==2) {
				System.out.print("[����:");
			}
			if(this.playerItem[i]!=0) {
				for(int j=0; j<sp.item.size(); j++) {
					if(this.playerItem[i]==sp.item.get(j).getItemCode()) {
						System.out.printf("%s] ",sp.item.get(j).getName());
					}
				}
			}
			else System.out.print("����] ");
		}
		System.out.println();
	}
	
	public void PlayerItemAdd(int itemCode) {
		for(int i=0; i<sp.item.size(); i++) {
			if(itemCode==sp.item.get(i).getItemCode()) {
				this.atk += sp.item.get(i).getAtk();
				this.def += sp.item.get(i).getDef();
				break;
			}
		}
	}
	
	public void PlayerItemRemove(int itemCode) {
		for(int i=0; i<sp.item.size(); i++) {
			if(itemCode==sp.item.get(i).getItemCode()) {
				this.atk -= sp.item.get(i).getAtk();
				this.def -= sp.item.get(i).getDef();
				break;
			}
		}
	}
	
}