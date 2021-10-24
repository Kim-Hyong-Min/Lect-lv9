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
		Unit.getInstance().EnemySet();
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
				if(Unit.getInstance().DeadorAlive(MonsterFloor[this.floor-1]-1)){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("����!");
					break;
				}
				Unit.getInstance().PrintEnemy(MonsterFloor[this.floor-1]-1);
				System.out.println("[1]����\n[2]���\n[3]����ȸ��");
				h.HeroUi();
				while(true) {
					System.out.print("�Է� : ");
					String input = sc.next();
					try {
						int num = Integer.parseInt(input);
						if(num==1) {
							System.out.println("����� ����!");
							int rNum = rn.nextInt(3);
							if(rNum==0) {
								int dmg = h.getAtk()*2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								if(dmg<0) {
									dmg = 1;
								}
								System.out.printf("%d�� ������!\n",dmg);
								Unit.getInstance().EnemyHit(MonsterFloor[this.floor-1]-1, dmg);
							}
							else {
								int rNum2 = rn.nextInt(5)+5;
								int dmg = h.getAtk()+rNum2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								System.out.printf("%d�� ������!\n",dmg);
								Unit.getInstance().EnemyHit(MonsterFloor[this.floor-1]-1, dmg);
							}
							if(Unit.getInstance().DeadorAlive(MonsterFloor[this.floor-1]-1)){
								break;
							}
							zombieTrun(MonsterFloor[this.floor-1]-1);
							break;
						}
						else if(num==2) {
							int rNum = rn.nextInt(3);
							if(rNum!=0) {
								System.out.println("���� ������ ���� ���ߴ�...");
								zombieTrun(MonsterFloor[this.floor-1]-1);
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
	
	private void zombieTrun(int idx) {
		int rNum = rn.nextInt(5);
		if(rNum == 0) {
			System.out.println("���� �۶����� �ִ�...");
		}
		else {
			System.out.println("������ ����!");
			int rNum2 = rn.nextInt(10)-3;
			int dmg = Unit.getInstance().EnemyAtk(idx)-h.getDef()+rNum2;
			if(dmg<=0) {
				dmg = 1;
			}
			System.out.printf("%d�� ������!\n",dmg);
			h.damage(dmg);
		}
	}
	
	private void finalBattle() {
		if(this.floor==20) {
			System.out.println("������� ��Ÿ����!");
			while(true) {
				if(Unit.getInstance().DeadorAlive(MonsterFloor[this.floor-1]-1)){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("����!");
					break;
				}
				Unit.getInstance().PrintEnemy(MonsterFloor[this.floor-1]-1);
				System.out.println("[1]����\n[2]���\n[3]����ȸ��");
				h.HeroUi();
				while(true) {
					System.out.print("�Է� : ");
					String input = sc.next();
					try {
						int num = Integer.parseInt(input);
						if(num==1) {
							System.out.println("����� ����!");
							int rNum = rn.nextInt(3);
							if(rNum==0) {
								int dmg = h.getAtk()*2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								if(dmg<0) {
									dmg = 1;
								}
								System.out.printf("%d�� ������!\n",dmg);
								Unit.getInstance().EnemyHit(MonsterFloor[this.floor-1]-1, dmg);
							}
							else {
								int rNum2 = rn.nextInt(5)+5;
								int dmg = h.getAtk()+rNum2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								System.out.printf("%d�� ������!\n",dmg);
								Unit.getInstance().EnemyHit(MonsterFloor[this.floor-1]-1, dmg);
							}
							if(Unit.getInstance().DeadorAlive(MonsterFloor[this.floor-1]-1)){
								break;
							}
							zombieKingTrun();
							break;
						}
						else if(num==2) {
							int rNum = rn.nextInt(3);
							if(rNum!=0) {
								System.out.println("���� ������ ���� ���ߴ�...");
								zombieKingTrun();
							}
							else {
								if(this.lazer==1) {
									System.out.println("������� �������� ���!");
									System.out.println("������ �������� ����...");
									this.lazer=0;
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
	
	private void zombieKingTrun() {
		if(this.lazer==0) {
			int rNum = rn.nextInt(5);
			if(rNum == 0) {
				int dmg = ZombieKing.getInstance().slap();
				h.damage(dmg);
			}
			else if(rNum==1) {
				int dmg = ZombieKing.getInstance().hug();
				h.damage(dmg);
			}
			else if(rNum==2) {
				ZombieKing.getInstance().dance();
			}
			else if(rNum==3) {
				ZombieKing.getInstance().nose();
			}
			else if(rNum==4) {
				ZombieKing.getInstance().LazerReady();
				this.lazer=1;
			}
		}
		else {
			int dmg = ZombieKing.getInstance().Lazer();
			h.damage(dmg);
			this.lazer=0;
		}
	}
	
	private void potionUp() {
		if(Unit.getInstance().EnemyPotion(MonsterFloor[this.floor-1]-1)==1) {
			h.setPotion(Unit.getInstance().EnemyPotion(MonsterFloor[this.floor-1]-1));
			System.out.println("�ָӴϸ� �������� ������ ���Դ�!");
			
		}
		else System.out.println("�ָӴϸ� ���������� �ƹ��͵� ������...");
	}
}
