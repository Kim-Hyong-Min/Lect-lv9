
public class Player {
//이름, 레벨, 현재 체력, 최대 체력, 공격력, 방어력, 경험치, 파티여부
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int atk;
	private int def;
	private int exp;
	private boolean party;
	private int playerCode;
	private int[] playerItem = new int[3]; // 0:무기 / 1:갑옷 / 2:반지
	// 사망시 장비 인벤토리로 귀속
	
	Player() {	
	}
	
	public Player(String name, int maxHp, int atk, int def, int playerCode){//첫 생성
		this.name = name;
		this.level = 1;
		this.maxHp = maxHp;
		this.hp = this.maxHp;
		this.atk = atk;
		this.def = def;
		this.exp = 0;
		this.playerCode = playerCode;
	}
	
	public int getPlayerCode() {
		return this.playerCode;
	}
	
	public int getPlayerItem(int idx) {
		return this.playerItem[idx];
	}
	
	
	public void printPlayer() {
		System.out.printf("[%s] [Lv.%d] [HP:%d/%d] [ATK:%d] [DEF:%d] [EXP:%d] ",this.name, this.level, this.hp, this.maxHp, this.atk, this.def, this.exp);
		for(int i=0; i<this.playerItem.length; i++) {
			if(i==0) {
				System.out.print("[무기:");
			}
			else if(i==1) {
				System.out.print("[갑옷:");
			}
			else if(i==2) {
				System.out.print("[반지:");
			}
			if(this.playerItem[i]!=0) {
				for(int j=0; j<Main.sp.item.size(); j++) {
					if(this.playerItem[i]==Main.sp.item.get(j).getItemCode()) {
						System.out.printf("%s] ",Main.sp.item.get(j).getName());
					}
				}
			}
			else System.out.print("없음] ");
		}
		System.out.println();
	}
	
}
