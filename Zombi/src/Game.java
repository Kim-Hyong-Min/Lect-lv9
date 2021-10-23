import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Random rn = new Random();
	private static Scanner sc = new Scanner(System.in);
	private static Game instance = new Game();
	public static Game getInstance() {return instance;}
	private Hero h = new Hero();
	private int MonsterFloor[] = new int [20];
	// ����
	private int floor;
	// ���ݷ� or ���� ���
	// ü�� ȸ��
	
	
	public void run() {
		start();
		while(true) {
			ui();
		}
	}
	
	private void MonsterSet() {
		int rNum1 = rn.nextInt(5)+1;//1~5
		int rNum2 = rn.nextInt(5)+6;//6~10
		int rNum3 = rn.nextInt(4)+11;//11~14
		int rNum4 = rn.nextInt(4)+15;//15~18
		MonsterFloor[rNum1] = 1;
		MonsterFloor[rNum2] = 2;
		MonsterFloor[rNum3] = 3;
		MonsterFloor[rNum4] = 4;
		MonsterFloor[19] = 5;//����
	}
	
	private void start() {
		
		this.floor++;
		System.out.println("===================");
		System.out.println("[����Ÿ��]�� �����߽��ϴ�!");
	}
	
	private void ui() {
		h.HeroUi();
		floorUp();
		System.out.println("[1]��������\n[2]�Ļ��ϱ�\n[3]��� ����");
		while(true) {
		System.out.print("�Է� : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {
				int rNum = rn.nextInt(3);
				this.floor++;
				break;
			}
			else if(num==2) {
				int rNum = rn.nextInt(10)+20;
				if(h.totalHp()==true) {
					h.heal(rNum);
					this.floor++;
				}
				else {
					System.out.println("�谡 �ҷ��� �Ļ縦 �� �� �����ϴ�.");
				}
				break;
			}
			else if(num==3) {
				int rNum1 = rn.nextInt(2);
				int rNum2 = rn.nextInt(5)+3;
				h.GearUp(rNum1, rNum2);
				this.floor++;
				break;
			}
			else System.out.println("�߸��� �Է� �Դϴ�.");
			
		} catch (Exception e) {
		}
		}
	}
	
	private void floorUp() {
		System.out.printf("���� ���� : %d��\n",this.floor);
		System.out.println("==================");
	}
}
