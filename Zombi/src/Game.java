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
	// 층수
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
		Unit z = new Unit("애기 좀비", 30, 10, 5, 0);
		this.enemy.add(z);
		z = new Unit("중2 좀비", 50, 20, 7, 0);
		this.enemy.add(z);
		z = new Unit("대학생 좀비", 80, 30, 10, 1);
		this.enemy.add(z);
		z = new Unit("어른 좀비", 100, 40, 12, 1);
		this.enemy.add(z);
		z = new Unit("좀비왕", 350, 50, 15, 0);
		this.enemy.add(z);
	}
	
	private void dead() {
		if(!h.DeadorAlive()) {
			System.out.println("용사는 좀비가 되고 말았다!");
			System.out.println("=================");
			System.out.println("====GAME OVER====");
			System.out.println("=================");
			this.gameRun = true;
		}
	}
	
	private void win() {
		if(this.floor==20 && h.DeadorAlive()) {
			System.out.println("더이상 오를 곳이 없다!");
			System.out.println("이로써 좀비타워는 평화를 맞이했다...");
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
		MonsterFloor[19] = 5;//보스
	}
	
	private void start() {
		EnemySet();
		this.floor++;
		System.out.println("===================");
		System.out.println("[좀비타워]에 입장했습니다!");
	}
	
	private void ui() {
		h.HeroUi();
		floorUp();
		System.out.println("[1]채력단련\n[2]식사하기\n[3]장비 손질");
		while(true) {
		System.out.print("입력 : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {
				int rNum = rn.nextInt(10)+1;
				h.HealthUp(rNum);
				System.out.println("더이상은 할 것이 없군. 위로 올라가자...");
				this.floor++;
				break;
			}
			else if(num==2) {
				int rNum = rn.nextInt(10)+20;
				if(h.totalHp()==true) {
					h.heal(rNum);
					System.out.println("더이상은 할 것이 없군. 위로 올라가자...");
					this.floor++;
				}
				else {
					System.out.println("배가 불러서 식사를 할 수 없습니다.");
				}
				break;
			}
			else if(num==3) {
				int rNum1 = rn.nextInt(2);
				int rNum2 = rn.nextInt(5)+1;
				h.GearUp(rNum1, rNum2);
				System.out.println("더이상은 할 것이 없군. 위로 올라가자...");
				this.floor++;
				break;
			}
			else System.out.println("잘못된 입력 입니다.");
			
		} catch (Exception e) {
		}
		}
	}
	
	private void floorUp() {
		System.out.printf("현재 층수 : %d층\n",this.floor);
		System.out.println("==================");
	}
	
	private void battle() {
		if(MonsterFloor[this.floor-1]!=0 && this.floor<20) {
			System.out.println("적을 만났다!");
			while(true) {
				if(enemy.get(MonsterFloor[this.floor-1]-1).DeadorAlive()){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("으악!");
					break;
				}
				enemy.get(MonsterFloor[this.floor-1]-1).PrintEnemy();
				System.out.println("[1]공격\n[2]방어\n[3]포션회복");
				h.HeroUi();
				while(true) {
					System.out.print("입력 : ");
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
								System.out.println("적의 공격을 막지 못했다...");
								enemy.get(MonsterFloor[this.floor-1]-1).attack(MonsterFloor[this.floor-1]-1, h.getDef());
							}
							else {
								System.out.println("적의 공격을 막았다!");
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
								else System.out.println("포션이 없습니다!");
							}
							else System.out.println("체력이 이마 다 찼습니다.");
							break;
						}
						else System.out.println("잘못된 입력 입니다.");
						
					} catch (Exception e) {
					}
				}
			}
			potionUp();
		}
		else {
			System.out.println("아무도 없는것 같다....");
		}
	}

	private void finalBattle() {
		if(this.floor==20) {
			System.out.println("좀비왕이 나타났다!");
			while(true) {
				if(enemy.get(MonsterFloor[this.floor-1]-1).DeadorAlive()){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("으악!");
					break;
				}
				enemy.get(MonsterFloor[this.floor-1]-1).PrintEnemy();
				System.out.println("[1]공격\n[2]방어\n[3]포션회복");
				h.HeroUi();
				int lazer = 0;
				while(true) {
					System.out.print("입력 : ");
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
								System.out.println("적의 공격을 막지 못했다...");
								ZombieKing.getInstance().attack(0, 0);
							}
							else {
								if(ZombieKing.getInstance().getCheck()==1) {
									System.out.println("좀비왕이 레이져를 쏜다!");
									System.out.println("다행이 빗나간것 같다...");
									ZombieKing.getInstance().setCheck();
								}
								else {
									System.out.println("적의 공격을 막았다!");
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
								else System.out.println("포션이 없습니다!");
							}
							else System.out.println("체력이 이마 다 찼습니다.");
							break;
						}
						else System.out.println("잘못된 입력 입니다.");
						
					} catch (Exception e) {
					}
				}
			}
		}
	}
	
	private void potionUp() {
		if(enemy.get(MonsterFloor[this.floor-1]-1).getPotion()==1) {
			h.setPotion(enemy.get(MonsterFloor[this.floor-1]-1).getPotion());
			System.out.println("주머니를 뒤져보니 포션이 나왔다!");
			
		}
		else System.out.println("주머니를 뒤져봤지만 아무것도 없었다...");
	}
}
