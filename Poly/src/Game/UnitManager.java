package Game;

import java.util.Vector;


public class UnitManager implements input{
	private static UnitManager instance = new UnitManager();
	public static UnitManager getInstance() {return instance;}
	Vector<Player>party = new Vector<>();
	Vector<Unit>enemy = new Vector<>();
	String path = "Game.";
	String Monsters[] = {"UnitGhost" , "UnitGoblin" , "UnitOrc", "UnitSlime" ,};
	
	public void playerSetup() {
		party.add(new Player("전 사", 1000, 20, 100));
		party.add(new Player("마법사", 500, 100, 25));
		party.add(new Player("도 적", 600, 50, 70));
		party.add(new Player("힐 러", 700, 80, 30));
	}
	
	public void MonsterSetup(int cnt, int level) {
		for(int i = 0; i < cnt;  i++) {
			int num = rn.nextInt(Monsters.length);
			try {
				Class<?> list = Class.forName(path + Monsters[num]);	
				Object unit = list.newInstance();
				Unit temp = (Unit)unit;
				int Max_hp = rn.nextInt(100) + 100*level;
				int atk = rn.nextInt(10) + 10+level;
				temp.MosterSet(Max_hp, atk);
				enemy.add(temp);
			} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	public void printBattleUi() {
		System.out.println("===== 아  군 =====");
		for(int i=0; i<this.party.size(); i++) {
			this.party.get(i).printPlayerUnit();
		}
		System.out.println();
		System.out.println("===== 적  군 =====");
		for(int i=0; i<this.enemy.size(); i++) {
			this.enemy.get(i).printEnemyUnit();
		}
	}
}
