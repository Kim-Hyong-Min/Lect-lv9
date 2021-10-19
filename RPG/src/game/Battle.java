package game;

import java.util.ArrayList;

public class Battle {
	public static Battle instance = new Battle();
	public static ArrayList<Monster> Monster = new ArrayList<>();
	
	private void monsterSet() {
		Monster py = new Monster("고블린", 1, 15, 1, 1, 10);
		Monster.add(py);
		py = new Monster("오우거", 2, 20, 2, 2, 10);
		Monster.add(py);
		py = new Monster("늑대", 3, 25, 3, 3, 10);
		Monster.add(py);
		py = new Monster("호랑이", 4, 30, 4, 4, 10);
		Monster.add(py);
		py = new Monster("슬라임", 5, 35, 5, 6, 10);
		Monster.add(py);
		py = new Monster("코끼리", 6, 40, 6, 5, 10);
		Monster.add(py);
		py = new Monster("유령", 7, 45, 7, 7, 10);
		Monster.add(py);
		py = new Monster("좀비", 8, 50, 8, 8, 10);
		Monster.add(py);
		py = new Monster("악마", 9, 65, 9, 9, 10);
		Monster.add(py);
		py = new Monster("마왕", 10, 100, 10, 10, 10);
		Monster.add(py);
	}
	
	// 사냥터 : 1,2/3,4/5,6/7,8,9/10
	
	public void battleMap() {
		System.out.println("1.초보자 사냥터(Lv.1~2)\n2.숲 사냥터(Lv.3~4)\n3.초보자 사냥터(Lv.5~6)\n4.지옥 사냥터\n5.마왕성(Lv.10)\n6.뒤로가기");
		while(true) {
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {//
				
			}
			else if(num==2) {//
				
			}
			else if(num==3) {//
				
			}
			else if(num==4) {
				
			}
			else if(num==5) {//
				
			}
			else if(num==6) {//
				
			}
			else if(num==7) {//
				
			}
			
		} catch (Exception e) {
		}
	}
	}
}
