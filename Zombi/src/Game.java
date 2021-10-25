import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static Random rn = new Random();
	private static Scanner sc = new Scanner(System.in);
	private static Game instance = new Game();
	public static Game getInstance() {return instance;}
	private static Hero h = new Hero();
	public static Hero getHero() {return h;}
	private int MonsterFloor[] = new int [20];
	private ArrayList<Unit> enemy = new ArrayList<>();
	// ����
	private int floor;
	private boolean gameRun;
	private int lazer;
	
	public void run() {
		start();
		MonsterSet();
		while(!gameRun) {
			ui();
			battle();
			finalBattle();
			win();
			dead();
		}
	}
	
	public void damageSet(int idx, int dmg) {
		this.enemy.get(idx).damage(dmg);
	}
	
	public void EnemySet() {
		Unit z = new Unit("�ֱ� ����", 30, 10, 5, 0);
		this.enemy.add(z);
		z = new Unit("��2 ����", 50, 20, 7, 0);
		this.enemy.add(z);
		z = new Unit("���л� ����", 80, 30, 10, 1);
		this.enemy.add(z);
		z = new Unit("� ����", 100, 40, 12, 1);
		this.enemy.add(z);
		z = new Unit("�����", 350, 50, 15, 0);
		this.enemy.add(z);
	}
	
	private void dead() {
		if(!h.DeadorAlive()) {
			System.out.println("���� ���� �ǰ� ���Ҵ�!");
			System.out.println("=================");
			System.out.println("====GAME OVER====");
			System.out.println("=================");
			this.gameRun = true;
		}
	}
	
	private void win() {
		if(this.floor==20 && h.DeadorAlive()) {
			System.out.println("���̻� ���� ���� ����!");
			System.out.println("�̷ν� ����Ÿ���� ��ȭ�� �����ߴ�...");
			System.out.println("=================");
			System.out.println("=====THE END=====");
			System.out.println("=================");
			this.gameRun = true;
		}
	}
	
	private void MonsterSet() {
		int rNum1 = rn.nextInt(3)+3;//3~5
		int rNum2 = rn.nextInt(3)+8;//8~10
		int rNum3 = rn.nextInt(2)+13;//13~14
		int rNum4 = rn.nextInt(2)+16;//16~17
		MonsterFloor[rNum1] = 1;
		MonsterFloor[rNum2] = 2;
		MonsterFloor[rNum3] = 3;
		MonsterFloor[rNum4] = 4;
		MonsterFloor[19] = 5;//����
	}
	
	private void start() {
		EnemySet();
		this.floor++;
		System.out.println("===================");
		System.out.println("[����Ÿ��]�� �����߽��ϴ�!");
	}
	
	private void ui() {
		h.HeroUi();
		floorUp();
		System.out.println("[1]ä�´ܷ�\n[2]�Ļ��ϱ�\n[3]��� ����");
		while(true) {
		System.out.print("�Է� : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {
				int rNum = rn.nextInt(10)+1;
				h.HealthUp(rNum);
				System.out.println("���̻��� �� ���� ����. ���� �ö���...");
				this.floor++;
				break;
			}
			else if(num==2) {
				int rNum = rn.nextInt(10)+20;
				if(h.totalHp()==true) {
					h.heal(rNum);
					System.out.println("���̻��� �� ���� ����. ���� �ö���...");
					this.floor++;
				}
				else {
					System.out.println("�谡 �ҷ��� �Ļ縦 �� �� �����ϴ�.");
				}
				break;
			}
			else if(num==3) {
				int rNum1 = rn.nextInt(2);
				int rNum2 = rn.nextInt(5)+1;
				h.GearUp(rNum1, rNum2);
				System.out.println("���̻��� �� ���� ����. ���� �ö���...");
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
	
	private void battle() {
		if(MonsterFloor[this.floor-1]!=0 && this.floor<20) {
			System.out.println("���� ������!");
			while(true) {
				if(enemy.get(MonsterFloor[this.floor-1]-1).DeadorAlive()){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("����!");
					break;
				}
				enemy.get(MonsterFloor[this.floor-1]-1).PrintEnemy();
				System.out.println("[1]����\n[2]���\n[3]����ȸ��");
				h.HeroUi();
				while(true) {
					System.out.print("�Է� : ");
					String input = sc.next();
					try {
						int num = Integer.parseInt(input);
						if(num==1) {
							h.attack(MonsterFloor[this.floor-1]-1, enemy.get(MonsterFloor[this.floor-1]-1).getDef());
							if(enemy.get(MonsterFloor[this.floor-1]-1).DeadorAlive()){
								break;
							}
							enemy.get(MonsterFloor[this.floor-1]-1).attack(MonsterFloor[this.floor-1]-1, h.getDef());
							break;
						}
						else if(num==2) {
							int rNum = rn.nextInt(3);
							if(rNum!=0) {
								System.out.println("���� ������ ���� ���ߴ�...");
								enemy.get(MonsterFloor[this.floor-1]-1).attack(MonsterFloor[this.floor-1]-1, h.getDef());
							}
							else {
								System.out.println("���� ������ ���Ҵ�!");
							}
							break;
						}
						else if(num==3) {
							if(h.getHp()!=h.getMaxHp()) {
								if(h.getPotion()>0) {
									h.setPotion(-1);
									int rNum = rn.nextInt(10)+25;
									h.heal(rNum);
								}
								else System.out.println("������ �����ϴ�!");
							}
							else System.out.println("ü���� �̸� �� á���ϴ�.");
							break;
						}
						else System.out.println("�߸��� �Է� �Դϴ�.");
						
					} catch (Exception e) {
					}
				}
			}
			potionUp();
		}
		else {
			System.out.println("�ƹ��� ���°� ����....");
		}
	}

	private void finalBattle() {
		if(this.floor==20) {
			System.out.println("������� ��Ÿ����!");
			while(true) {
				if(enemy.get(MonsterFloor[this.floor-1]-1).DeadorAlive()){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("����!");
					break;
				}
				enemy.get(MonsterFloor[this.floor-1]-1).PrintEnemy();
				System.out.println("[1]����\n[2]���\n[3]����ȸ��");
				h.HeroUi();
				int lazer = 0;
				while(true) {
					System.out.print("�Է� : ");
					String input = sc.next();
					try {
						int num = Integer.parseInt(input);
						if(num==1) {
							h.attack(MonsterFloor[this.floor-1]-1, enemy.get(MonsterFloor[this.floor-1]-1).getDef());
							if(enemy.get(MonsterFloor[this.floor-1]-1).DeadorAlive()){
								break;
							}
							ZombieKing.getInstance().attack(0, 0);
							break;
						}
						else if(num==2) {
							int rNum = rn.nextInt(3);
							if(rNum!=0) {
								System.out.println("���� ������ ���� ���ߴ�...");
								ZombieKing.getInstance().attack(0, 0);
							}
							else {
								if(ZombieKing.getInstance().getCheck()==1) {
									System.out.println("������� �������� ���!");
									System.out.println("������ �������� ����...");
									ZombieKing.getInstance().setCheck();
								}
								else {
									System.out.println("���� ������ ���Ҵ�!");
								}
							}
							break;
						}
						else if(num==3) {
							if(h.getHp()!=h.getMaxHp()) {
								if(h.getPotion()>0) {
									h.setPotion(-1);
									int rNum = rn.nextInt(10)+25;
									h.heal(rNum);
								}
								else System.out.println("������ �����ϴ�!");
							}
							else System.out.println("ü���� �̸� �� á���ϴ�.");
							break;
						}
						else System.out.println("�߸��� �Է� �Դϴ�.");
						
					} catch (Exception e) {
					}
				}
			}
		}
	}
	
	private void potionUp() {
		if(enemy.get(MonsterFloor[this.floor-1]-1).getPotion()==1) {
			h.setPotion(enemy.get(MonsterFloor[this.floor-1]-1).getPotion());
			System.out.println("�ָӴϸ� �������� ������ ���Դ�!");
			
		}
		else System.out.println("�ָӴϸ� ���������� �ƹ��͵� ������...");
	}
}
