package Game;

import java.util.Random;
import java.util.Scanner;

interface input{
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
}

public class StageManager implements input{
	private static StageManager instance = new StageManager();
	public static StageManager getInstance() {return instance;}
	private UnitManager um = UnitManager.getInstance();
	private Battle be = Battle.getInstance();
	private int level = 1;
	
	public void StageMenu() {
		um.playerSetup();
		while(true) {
			Stagetitle();
			System.out.println("====================");
			System.out.println("[1]�������� ����\n[2]����");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {
					um.MonsterSetup(4, level);
					be.battle();
					break;
				}
				else if(num==2) {
					break;
				}
				else System.out.println("�߸��� �Է� �Դϴ�.");
				
			} catch (Exception e) {
			}
		}
		NextStageMenu();
	}
	
	
	public void NextStageMenu() {
		if(be.getCheck()==4) {
			System.out.println("�¸�!");
			while(true) {
				if(be.getCheck()==-1) {
					break;
				}
				System.out.println("====================");
				System.out.printf("�¸� Ƚ�� : %dȸ\n",this.level);
				System.out.println("[1]���� �������� ����\n[2]����");
				String input = sc.next();
				try {
					int num = Integer.parseInt(input);
					if(num==1) {
						level++;
						um.playerMpSet();
						um.MonsterSetup(4, level);
						be.battle();
					}
					else if(num==2) {
						break;
					}
					else System.out.println("�߸��� �Է� �Դϴ�.");
					
				} catch (Exception e) {
				}
			}
		}
		else if(be.getCheck()==-1) {
			System.out.println("�й�!");
			System.out.println("====================");
			System.out.printf("�� �¸� Ƚ�� : %dȸ\n",this.level);
		}
	}
	
	public void Stagetitle() {
		System.out.println("==== GREEN ������ ====");
	}
}
