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
		Zombie z = new Zombie("�ֱ� ����", 100, 5, 0, rNum) {};
		zom.add(z);
		rNum = rn.nextInt(2);
		z = new Zombie("û�� ����", 200, 10, 5, rNum) {};
		zom.add(z);
		rNum = rn.nextInt(2);
		z = new Zombie("���� ����", 300, 20, 10, rNum) {};
		zom.add(z);
		rNum = rn.nextInt(2);
		z = new Zombie("�ƺ� ����", 400, 30, 15, rNum) {};
		zom.add(z);
	}
	
	public void ZombieKingSet() {
		ZombieKing z = new ZombieKing("����ŷ", 600, 40, 20, 0) {};
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
			playerCheck();
		}
		
	}
	
	public void playerCheck() {
		if(this.p.deadCheck()) {
			run = false;
		}
	}
	
	public void ending() {
		if(this.p.deadCheck()) {
			System.out.println("�밨�� %d�� �ᱹ ��� ���� ����� ��ȭ�� �����Դ�...");
		}
		else {
			
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
		else System.out.println("�ƹ��� ������...");
	}
	
	public void battle(int idx) {
		while(true) {
			if(this.zom.get(idx).deadCheck()) {
				System.out.println("�¸�!");
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
					this.p.attack();
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
		if(this.p.getState()>0) {
			this.zom.get(idx).damage(this.p.getState());
			if(!this.zom.get(idx).deadCheck()) {
				this.zom.get(idx).attack();
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
}
