package Game;

public class Battle implements input{
	private UnitManager um = UnitManager.getInstance();
	
	Battle() {}
	
	public void battle() {
		while(true) {
			PlayerTurn();
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
					}
					else System.out.println("마나가 모자랍니다.");
				}
				else if(num==2) { // 스킬 2 시전 준비
					if(um.party.get(idx).PlayerSkillCheck(6)) {
						um.party.get(idx).setState(6);			
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
				}
				else if(um.party.get(i).getState()==5) {
					PlayerSkill_1(i);
				}
				else if(um.party.get(i).getState()==6) {
					PlayerSkill_2(i);
				}
			}
		}
	}
	
	public void PlayerAttack(int idx) {
		while(true) {
			int rNum = rn.nextInt(4);
			if(!um.enemy.get(rNum).getDead()) {
				int atk = um.party.get(idx).getAtk();
				um.enemy.get(rNum).setHp(atk);
				System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(rNum).getnName(), atk);
				break;
			}
		}
	}
	
	public void PlayerSkill_1(int idx) {
		if(idx==0) { // 전사
			// 방어 : 적의 공격을 1회 막는다
			
		}
		else if(idx==2) { // 마법사
			// 화염비 : 모든적에게 20의 데미지를 준다
			System.out.println("마법사는 [화염비]를 시전했다!");
			for(int i=0; i<um.enemy.size(); i++) {
				int atk = 20;
				if(!um.enemy.get(i).getDead()) {
					um.enemy.get(i).setHp(atk);
					System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(i).getnName(), atk);					
				}
			}
		}
		else if(idx==3) { // 도적
			// 수면제 : 적을 1턴동안 재운다
			
		}
		else if(idx==4) { // 힐러
			// 회복 : 아군의 채력을 100만큼 회복시킨다
		}
	}

	public void PlayerSkill_2(int idx) {
		if(idx==0) { // 전사
			// 강타 : 적에게 2배의 데미지를 준다
			System.out.println("전사는 [강타]를 외쳤다!");
			while(true) { 
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*2;
					System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==2) { // 마법사
			// 얼음창 : 적에게 3배의 데미지를 준다
			System.out.println("마법사는 [얼음창]을 시전했다!");
			while(true) { 
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*3;
					System.out.printf("[%s]에게 [%d]의 데미지!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==3) { // 도적
			// 맹독 : 적에게 2턴간 독을 건다
		}
		else if(idx==4) { // 힐러
			// 전체 회복 : 모든 아군의 체력을 70만큼 회복한다
		}
	}
	
	
	public void EnemyTurn() {
		
	}
}
