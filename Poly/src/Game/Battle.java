package Game;

public class Battle implements input{
	private static Battle instance = new Battle();
	public static Battle getInstance() {return instance;}
	private UnitManager um = UnitManager.getInstance();
	private int check;
	Battle() {}
	
	public int getCheck() {
		return this.check;
	}
	
	public void setCheck(int num) {
		this.check = num;
	}
	
	public void battle() {
		while(true) {
			if(EnemyCheck()==4) {
				break;
			}
			um.printBattleUi();
			PlayerTurn();
			if(EnemyCheck()==4) {
				break;
			}
			PlayerActting();
			EnemyTurn();
			if(PlayerCheck()==4) {
				break;
			}
		}
	}
	
	public void PlayerTurn() {
		for(int i=0; i<um.party.size(); i++) {
			if(um.party.get(i).getState()==0) {
			while(true) {
				System.out.println("======================");
				um.party.get(i).printPlayerUnit();
				System.out.println("1.[공격] 2.[스킬]");
				String input = sc.next();
				try {
					int num = Integer.parseInt(input);
					if(num==1) {
						um.party.get(i).setState(4);	
						break;
					}
					else if(num==2) {
						PlayerSkill(i);
						break;
					}
				} catch (Exception e) {
				}
				
			}
			}
		}
	}
	
	public void PlayerSkill(int idx) {
		while(true) {
			um.party.get(idx).printPlayerSkill();
			System.out.println("3.[뒤로가기]");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) { // 스킬 1 시전 준비
					if(um.party.get(idx).PlayerSkillCheck(5)) {
						um.party.get(idx).setState(5);
						break;
					}
					else System.out.println("마나가 모자랍니다.");
				}
				else if(num==2) { // 스킬 2 시전 준비
					if(um.party.get(idx).PlayerSkillCheck(6)) {
						um.party.get(idx).setState(6);
						break;
					}
					else System.out.println("마나가 모자랍니다.");
				}
				else if(num==3) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	public void PlayerActting() {
		for(int i=0; i<um.party.size(); i++) {// 0:정상 1:잠듦 2:기절 3:독 4: 공격 5:스킬1 6:스킬2
			if(!um.party.get(i).getDead() && um.party.get(i).getState() != 1 && um.party.get(i).getState() != 2) {
				if(um.party.get(i).getState()==4) {
					PlayerAttack(i);
					um.party.get(i).setState(0);
				}
				else if(um.party.get(i).getState()==5) {
					PlayerSkill_1(i);
					um.party.get(i).setState(0);
				}
				else if(um.party.get(i).getState()==6) {
					PlayerSkill_2(i);
					um.party.get(i).setState(0);
				}
			}
		}
	}
	
	public void PlayerAttack(int idx) {
		while(true) {
			if(EnemyCheck()==4) {
				break;
			}
			int rNum = rn.nextInt(4);
			if(!um.enemy.get(rNum).getDead()) {
				int atk = um.party.get(idx).getAtk();
				um.enemy.get(rNum).setHp(atk);
				System.out.printf("[%s]의 공격!\n",um.party.get(idx).getnName());
				System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(rNum).getnName(), atk);
				break;
			}
		}
	}
	
	public void PlayerSkill_1(int idx) {
		if(idx==0) { // 전사
			// 휘두르기 : 적에게 150의 데미지를 준다
			System.out.println("전사는 [휘두르기]를 했다!");
			while(true) { 
				if(EnemyCheck()==4) {
					break;
				}
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = 150;
					um.enemy.get(rNum).deadSet();
					System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==1) { // 마법사
			// 화염비 : 모든적에게 20의 데미지를 준다
			System.out.println("마법사는 [화염비]를 시전했다!");
			for(int i=0; i<um.enemy.size(); i++) {
				if(EnemyCheck()==4) {
					break;
				}
				int atk = 20;
				if(!um.enemy.get(i).getDead()) {
					um.enemy.get(i).setHp(atk);
					um.enemy.get(i).deadSet();
					System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(i).getnName(), atk);					
				}
			}
		}
		else if(idx==2) { // 도적
			// 수면제 : 적을 1턴동안 재운다
			System.out.println("도적은 [수면제]를 뿌렸다!");
			for(int i=0; i<um.enemy.size(); i++) {
				if(!um.enemy.get(i).getDead()) {
					if(um.enemy.get(i).getState()==0) {
						um.enemy.get(i).setState(1);
					}
				}
			}
		}
		else if(idx==3) { // 힐러
			// 회복 : 아군의 채력을 100만큼 회복시킨다
			int max = 0;
			for(int i=0; i<um.party.size(); i++) {
				if(!um.party.get(i).getDead()) {
					if(um.party.get(i).checkHp()>0 && um.party.get(i).checkHp()>um.party.get(max).checkHp()) {
						max=i;
					}
				}
			}
			um.party.get(max).heal(100);
		}
	}

	public void PlayerSkill_2(int idx) {
		if(idx==0) { // 전사
			// 강타 : 적에게 2배의 데미지를 준다
			System.out.println("전사는 [강타]를 외쳤다!");
			while(true) { 
				if(EnemyCheck()==4) {
					break;
				}
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*2;
					um.enemy.get(rNum).deadSet();
					System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==1) { // 마법사
			// 얼음창 : 적에게 3배의 데미지를 준다
			System.out.println("마법사는 [얼음창]을 시전했다!");
			while(true) { 
				if(EnemyCheck()==4) {
					break;
				}
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*3;
					um.enemy.get(rNum).deadSet();
					System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==2) { // 도적
			// 맹독 : 적에게 2턴간 독을 건다
			System.out.println("도적은 [독]을 뿌렸다!");
			for(int i=0; i<um.enemy.size(); i++) {
				if(!um.enemy.get(i).getDead() && um.enemy.get(i).getState()==0) {
						um.enemy.get(i).setState(3);
						break;
				}
			}
		}
		else if(idx==3) { // 힐러
			// 전체 회복 : 모든 아군의 체력을 70만큼 회복한다
			for(int i=0; i<um.party.size(); i++) {
				if(!um.party.get(i).getDead()) {
					um.party.get(i).heal(70);
				}
			}
		}
	}
	
	public int EnemyCheck() {
		int cnt = 0;
		for(int i=0; i<um.enemy.size(); i++) {
			if(um.enemy.get(i).getDead()) {
				um.enemy.get(i).setState(2);
				cnt++;
			}
		}
		this.check = cnt;
		return cnt;
	}
	
	
	public void EnemyTurn() { // 1 , 8 이 아니면 행동가능
		if(EnemyCheck()!=4) {
			System.out.println("===== 적군의 턴! =====");
		}
		for(int i=0; i<um.enemy.size(); i++) {
			if(!um.enemy.get(i).getDead()) {
				um.enemy.get(i).poison();
				um.enemy.get(i).sleep();
			}
		}
		for(int i=0; i<um.enemy.size(); i++) {
			if(!um.enemy.get(i).getDead() && um.enemy.get(i).getState()!=1 && um.enemy.get(i).getState()!=2 && um.enemy.get(i).getState()!=8) {
				int rNum = rn.nextInt(4);
				if(rNum==0) { // 스킬
					if(um.enemy.get(i).getnName().equals("오 크")) {
						UnitOrc orc = (UnitOrc) um.enemy.get(i);
						int atk = orc.getSkill();
						System.out.println("[오 크]의 공격!");
						System.out.println("[오 크]는 [머리찍기]를 사용했다!");
						EnemyAttack(atk);
					}
					else if(um.enemy.get(i).getnName().equals("슬라임")) {
						UnitSlime slime = (UnitSlime) um.enemy.get(i);
						int atk = slime.getSkill();
						System.out.println("[슬라임]의 공격!");
						System.out.println("[슬라임]은 [삼키기]를 사용했다!");
						EnemyAttack(atk);
					}
					else if(um.enemy.get(i).getnName().equals("고블린")) {
						UnitGoblin goblin = (UnitGoblin) um.enemy.get(i);
						int atk = goblin.getSkill();
						System.out.println("[고블린]의 공격!");
						System.out.println("[고블린]은 [강타]를 사용했다!");
						EnemyAttack(atk);
					}
					else if(um.enemy.get(i).getnName().equals("유 령")) {
						UnitGhost ghost = (UnitGhost) um.enemy.get(i);
						int atk = ghost.getSkill();
						System.out.println("[유 령]의 공격!");
						System.out.println("[유 령]은 [놀래키기]를 사용했다!");
						EnemyAttack(atk);
					}
					PlayerCheck();
				}
				else {
					System.out.printf("[%s]의 공격!\n",um.enemy.get(i).getnName());
					int atk = um.enemy.get(i).getAtk();
					EnemyAttack(atk);
					PlayerCheck();
				}
			}
		}
	}
	
	public void EnemyAttack(int atk) {
		while(true) { 
			if(PlayerCheck()==4) {
				break;
			}
			int rNum = rn.nextInt(4);
			if(!um.party.get(rNum).getDead()) {
				um.party.get(rNum).deadSet();
				System.out.printf("[%s]에게 [%d]의 데미지!\n",um.party.get(rNum).getnName(), atk);
				um.party.get(rNum).setHp(atk);
				break;
			}
		}
	}
	
	public int PlayerCheck() {
		int cnt = 0;
		for(int i=0; i<um.party.size(); i++) {
			if(um.party.get(i).getDead()) {
				um.party.get(i).setState(2);
				cnt++;
			}
		}
		this.check = -1;
		return cnt;
	}
}
