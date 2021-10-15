
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
}
