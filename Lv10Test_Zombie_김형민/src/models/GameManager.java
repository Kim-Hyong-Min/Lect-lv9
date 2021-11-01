package models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

interface input{
	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
}

public class GameManager implements input{
	private static GameManager instance = new GameManager();
	public static GameManager getInstance() {return instance;}
	public Player p;
	public ArrayList<Zombie>zom;
	public ZombieKing zk;
	private int level = 1; // 20�� ����
	private int zomLevel[] = new int [20];
	private boolean run = true;
	
	public void playerSet(String name) {//  int Max_Hp, int Atk,  int Def, int Potion
		Player u = new Player(name, 300, 10, 10, 3) {};
		this.p = u;
	}
	
	public void ZombieSet() { // String name, int Max_Hp, int Atk,  int Def, int Potion(0/1)
		zom = new ArrayList<>();
		int rNum = rn.nextInt(2);
		Zombie z = new Zombie("�ֱ� ����", 50, 5, 0, rNum) {};
		zom.add(z);
		rNum = rn.nextInt(2);
		z = new Zombie("û�� ����", 100, 10, 5, rNum) {};
		zom.add(z);
		rNum = rn.nextInt(2);
		z = new Zombie("���� ����", 200, 20, 10, rNum) {};
		zom.add(z);
		rNum = rn.nextInt(2);
		z = new Zombie("�ƺ� ����", 300, 30, 15, rNum) {};
		zom.add(z);
	}
	
	public void ZombieKingSet() {
		ZombieKing z = new ZombieKing("����ŷ", 500, 40, 20, 0) {};
		this.zk = z;
	}
	
	public void levelSet() {// 1~4 6~9 11~13 15~17 /19 = boss
		int rNum1 = rn.nextInt(4)+1;
		this.zomLevel[rNum1] = 1;
		int rNum2 = rn.nextInt(4)+6;
		this.zomLevel[rNum2] = 2;
		int rNum3 = rn.nextInt(3)+11;
		this.zomLevel[rNum3] = 3;
		int rNum4 = rn.nextInt(3)+15;
		this.zomLevel[rNum4] = 4;
	}
	
	
	public void startMenu() {
			System.out.print("�̸� �Է� : ");
			String name = sc.next();
			playerSet(name);
	}
	
	public void run() {
		startMenu();
		ZombieSet();
		ZombieKingSet();
		levelSet();
		while(run) {
			menu();
			battleStart();
			finalBattle();
			playerCheck();
			endCheck();
		}
		ending();
	}
	
	public void playerCheck() {
		if(this.p.deadCheck()) {
			run = false;
		}
	}
	
	public void endCheck() {
		if(this.level == 20) {
			run = false;
		}
	}
	
	public void ending() {
		if(!this.p.deadCheck()) {
			System.out.printf("�밨�� %s�� �ᱹ ��� ���� ����� ��ȭ�� �����Դ�...\n",this.p.getName());
		}
		else {
			System.out.printf("%s�� �ᱹ ���� �ǰ� ���Ҵ�...\n",this.p.getName());
		}
	}
	
	public void menu() {
		while(true) {
			System.out.println("================");
			printLevel();
			this.p.printUi();
			this.p.printPotion();
			System.out.println("================");
			System.out.println("[1]������\n[2]ä�´ܷ�\n[3]���ڱ�");
			System.out.print("�Է� : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					int rNum = rn.nextInt(2);
					this.p.gearUp(rNum);
					this.level++;
					break;
				}
				else if(num == 2) {
					this.p.healthUp();
					this.level++;
					break;
				}
				else if(num == 3) {
					if(this.p.getHp()!= this.p.getMax_Hp()) {
						this.p.sleep();
						this.level++;
						break;
					}
					else {
						System.out.println("���� ���� �ʽ��ϴ�...");
					}
				}
				else System.out.println("�߸��� �Է� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
	public void printLevel() {
		System.out.printf("���� ���� : %d��\n",this.level);
	}
	
	public void battleStart() {
		if(this.zomLevel[this.level-1]!=0) {
			System.out.println("���� ��Ÿ����!");
			battle(this.zomLevel[this.level-1]-1);
		}
		else {
			if(this.level<20) {
				System.out.println("�ƹ��� ������...");
			}
		}
	}
	
	public void battle(int idx) {
		while(this.level<20) {
			if(this.zom.get(idx).deadCheck()) {
				System.out.println("�¸�!");
				if(this.zom.get(this.zomLevel[this.level-1]-1).getPotion()==1) {
					this.p.setPotion(this.zom.get(this.zomLevel[this.level-1]-1).getPotion());
					System.out.println("[����]�� ȹ���ߴ�!");
				}
				break;
			}
			if(this.p.deadCheck()) {
				System.out.println("�й�...");
				break;
			}
			playerTurn(idx);
			zombieTurn(idx);
		}
	}
	
	public void playerTurn(int idx) {
		while(true) {
			System.out.println("===== �� =====");
			this.zom.get(idx).printUi();
			System.out.println("=============");
			this.p.printUi();
			this.p.printPotion();
			System.out.println("=============");
			System.out.println("[1]����\n[2]���\n[3]����");
			System.out.print("�Է� : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					this.p.attack(this.zom.get(idx).getDef());
					break;
				}
				else if(num == 2) {
					this.p.defense();
					break;
				}
				else if(num == 3) {
					if(this.p.getPotion()>0) {
						this.p.drinkPotion();
					}
					else System.out.println("������ �����ϴ�.");
				}
			} catch (Exception e) {
			}
		}
	}
	
	
	
	public void zombieTurn(int idx) {
		if(this.p.getState()>=0) {
			this.zom.get(idx).damage(this.p.getState());
			if(!this.zom.get(idx).deadCheck()) {
				this.zom.get(idx).attack(this.p.getDef());
				this.p.damage(this.zom.get(idx).getState());
			}
			this.p.setState(0);
		}
		else if(this.p.getState()==-1) {
			System.out.println("[���] ����!");
			System.out.printf("%s�� �����Ҽ��� ������...\n",this.zom.get(idx).getName());
			this.p.setState(0);
		}
	}
	
	public void finalBattle() {
		if(this.level==20) {
			while(true) {
				if(this.zk.deadCheck()) {
					System.out.println("�¸�!");
					break;
				}
				if(this.p.deadCheck()) {
					System.out.println("�й�...");
					break;
				}
				playerTurn();
				zombieKingTurn();
			}
		}
	}
	
	public void playerTurn() {
		while(true) {
			System.out.println("==== �� �� ====");
			this.zk.printUi();
			System.out.println("=============");
			this.p.printUi();
			this.p.printPotion();
			System.out.println("=============");
			System.out.println("[1]����\n[2]���\n[3]����");
			System.out.print("�Է� : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					this.p.attack(this.zk.getDef());
					break;
				}
				else if(num == 2) {
					this.p.defense();
					break;
				}
				else if(num == 3) {
					if(this.p.getPotion()>0) {
						this.p.drinkPotion();
					}
					else System.out.println("������ �����ϴ�.");
				}
			} catch (Exception e) {
			}
		}
	}
	
	public void zombieKingTurn() {
		if(this.p.getState()>=0) {
			this.zk.damage(this.p.getState());
			if(!this.zk.deadCheck()) {
				int rNum = rn.nextInt(4);
				
				if(this.zk.getState() != 1) {
					if(rNum == 0) {
						this.zk.attack(this.p.getDef());
						this.p.damage(this.zk.getState());
						this.zk.setState(0);
					}
					else if(rNum == 1) {
						this.zk.slap();
						this.p.damage(this.zk.getState());
						this.zk.setState(0);
					}
					else if(rNum == 2) {
						this.zk.lazer();
					}
					else if(rNum == 3) {
						this.zk.sleep();
					}
					
				}
				else {
					this.zk.lazer();
					this.p.damage(this.zk.getState());
					this.zk.setState(0);
				}

			}
			this.p.setState(0);
		}
		else if(this.p.getState()==-1) {
			System.out.println("[���] ����!");
			System.out.printf("%s�� �����Ҽ��� ������...\n",this.zk.getName());
			this.zk.setState(0);
			this.p.setState(0);
		}
	}
	
	
}
