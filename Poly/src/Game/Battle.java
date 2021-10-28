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
				System.out.println("1.[����] 2.[��ų]");
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
			System.out.println("3.[�ڷΰ���]");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) { // ��ų 1 ���� �غ�
					if(um.party.get(idx).PlayerSkillCheck(5)) {
						um.party.get(idx).setState(5);						
					}
					else System.out.println("������ ���ڶ��ϴ�.");
				}
				else if(num==2) { // ��ų 2 ���� �غ�
					if(um.party.get(idx).PlayerSkillCheck(6)) {
						um.party.get(idx).setState(6);			
					}
					else System.out.println("������ ���ڶ��ϴ�.");
				}
				else if(num==3) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	public void PlayerActting() {
		for(int i=0; i<um.party.size(); i++) {// 0:���� 1:��� 2:���� 3:�� 4: ���� 5:��ų1 6:��ų2
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
				System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(rNum).getnName(), atk);
				break;
			}
		}
	}
	
	public void PlayerSkill_1(int idx) {
		if(idx==0) { // ����
			// ��� : ���� ������ 1ȸ ���´�
			
		}
		else if(idx==2) { // ������
			// ȭ���� : ��������� 20�� �������� �ش�
			System.out.println("������� [ȭ����]�� �����ߴ�!");
			for(int i=0; i<um.enemy.size(); i++) {
				int atk = 20;
				if(!um.enemy.get(i).getDead()) {
					um.enemy.get(i).setHp(atk);
					System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(i).getnName(), atk);					
				}
			}
		}
		else if(idx==3) { // ����
			// ������ : ���� 1�ϵ��� ����
			
		}
		else if(idx==4) { // ����
			// ȸ�� : �Ʊ��� ä���� 100��ŭ ȸ����Ų��
		}
	}

	public void PlayerSkill_2(int idx) {
		if(idx==0) { // ����
			// ��Ÿ : ������ 2���� �������� �ش�
			System.out.println("����� [��Ÿ]�� ���ƴ�!");
			while(true) { 
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*2;
					System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==2) { // ������
			// ����â : ������ 3���� �������� �ش�
			System.out.println("������� [����â]�� �����ߴ�!");
			while(true) { 
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*3;
					System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==3) { // ����
			// �͵� : ������ 2�ϰ� ���� �Ǵ�
		}
		else if(idx==4) { // ����
			// ��ü ȸ�� : ��� �Ʊ��� ü���� 70��ŭ ȸ���Ѵ�
		}
	}
	
	
	public void EnemyTurn() {
		
	}
}
