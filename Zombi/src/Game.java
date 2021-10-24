import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Random rn = new Random();
	private static Scanner sc = new Scanner(System.in);
	private static Game instance = new Game();
	public static Game getInstance() {return instance;}
	private Hero h = new Hero();
	private int MonsterFloor[] = new int [20];
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
		Unit.getInstance().EnemySet();
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
				if(Unit.getInstance().DeadorAlive(MonsterFloor[this.floor-1]-1)){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("으악!");
					break;
				}
				Unit.getInstance().PrintEnemy(MonsterFloor[this.floor-1]-1);
				System.out.println("[1]공격\n[2]방어\n[3]포션회복");
				h.HeroUi();
				while(true) {
					System.out.print("입력 : ");
					String input = sc.next();
					try {
						int num = Integer.parseInt(input);
						if(num==1) {
							System.out.println("용사의 공격!");
							int rNum = rn.nextInt(3);
							if(rNum==0) {
								int dmg = h.getAtk()*2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								if(dmg<0) {
									dmg = 1;
								}
								System.out.printf("%d의 데미지!\n",dmg);
								Unit.getInstance().EnemyHit(MonsterFloor[this.floor-1]-1, dmg);
							}
							else {
								int rNum2 = rn.nextInt(5)+5;
								int dmg = h.getAtk()+rNum2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								System.out.printf("%d의 데미지!\n",dmg);
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
								System.out.println("적의 공격을 막지 못했다...");
								zombieTrun(MonsterFloor[this.floor-1]-1);
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
	
	private void zombieTrun(int idx) {
		int rNum = rn.nextInt(5);
		if(rNum == 0) {
			System.out.println("좀비가 멍때리고 있다...");
		}
		else {
			System.out.println("좀비의 공격!");
			int rNum2 = rn.nextInt(10)-3;
			int dmg = Unit.getInstance().EnemyAtk(idx)-h.getDef()+rNum2;
			if(dmg<=0) {
				dmg = 1;
			}
			System.out.printf("%d의 데미지!\n",dmg);
			h.damage(dmg);
		}
	}
	
	private void finalBattle() {
		if(this.floor==20) {
			System.out.println("좀비왕이 나타났다!");
			while(true) {
				if(Unit.getInstance().DeadorAlive(MonsterFloor[this.floor-1]-1)){
					break;
				}
				if(!h.DeadorAlive()){
					System.out.println("으악!");
					break;
				}
				Unit.getInstance().PrintEnemy(MonsterFloor[this.floor-1]-1);
				System.out.println("[1]공격\n[2]방어\n[3]포션회복");
				h.HeroUi();
				while(true) {
					System.out.print("입력 : ");
					String input = sc.next();
					try {
						int num = Integer.parseInt(input);
						if(num==1) {
							System.out.println("용사의 공격!");
							int rNum = rn.nextInt(3);
							if(rNum==0) {
								int dmg = h.getAtk()*2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								if(dmg<0) {
									dmg = 1;
								}
								System.out.printf("%d의 데미지!\n",dmg);
								Unit.getInstance().EnemyHit(MonsterFloor[this.floor-1]-1, dmg);
							}
							else {
								int rNum2 = rn.nextInt(5)+5;
								int dmg = h.getAtk()+rNum2-Unit.getInstance().EnemyDef(MonsterFloor[this.floor-1]-1);
								System.out.printf("%d의 데미지!\n",dmg);
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
								System.out.println("적의 공격을 막지 못했다...");
								zombieKingTrun();
							}
							else {
								if(this.lazer==1) {
									System.out.println("좀비왕이 레이져를 쏜다!");
									System.out.println("다행이 빗나간것 같다...");
									this.lazer=0;
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
			System.out.println("주머니를 뒤져보니 포션이 나왔다!");
			
		}
		else System.out.println("주머니를 뒤져봤지만 아무것도 없었다...");
	}
}
