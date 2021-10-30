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
			System.out.println("3.[�ڷΰ���]");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) { // ��ų 1 ���� �غ�
					if(um.party.get(idx).PlayerSkillCheck(5)) {
						um.party.get(idx).setState(5);
						break;
					}
					else System.out.println("������ ���ڶ��ϴ�.");
				}
				else if(num==2) { // ��ų 2 ���� �غ�
					if(um.party.get(idx).PlayerSkillCheck(6)) {
						um.party.get(idx).setState(6);
						break;
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
				System.out.printf("[%s]�� ����!\n",um.party.get(idx).getnName());
				System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(rNum).getnName(), atk);
				break;
			}
		}
	}
	
	public void PlayerSkill_1(int idx) {
		if(idx==0) { // ����
			// �ֵθ��� : ������ 150�� �������� �ش�
			System.out.println("����� [�ֵθ���]�� �ߴ�!");
			while(true) { 
				if(EnemyCheck()==4) {
					break;
				}
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = 150;
					um.enemy.get(rNum).deadSet();
					System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==1) { // ������
			// ȭ���� : ��������� 20�� �������� �ش�
			System.out.println("������� [ȭ����]�� �����ߴ�!");
			for(int i=0; i<um.enemy.size(); i++) {
				if(EnemyCheck()==4) {
					break;
				}
				int atk = 20;
				if(!um.enemy.get(i).getDead()) {
					um.enemy.get(i).setHp(atk);
					um.enemy.get(i).deadSet();
					System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(i).getnName(), atk);					
				}
			}
		}
		else if(idx==2) { // ����
			// ������ : ���� 1�ϵ��� ����
			System.out.println("������ [������]�� �ѷȴ�!");
			for(int i=0; i<um.enemy.size(); i++) {
				if(!um.enemy.get(i).getDead()) {
					if(um.enemy.get(i).getState()==0) {
						um.enemy.get(i).setState(1);
					}
				}
			}
		}
		else if(idx==3) { // ����
			// ȸ�� : �Ʊ��� ä���� 100��ŭ ȸ����Ų��
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
		if(idx==0) { // ����
			// ��Ÿ : ������ 2���� �������� �ش�
			System.out.println("����� [��Ÿ]�� ���ƴ�!");
			while(true) { 
				if(EnemyCheck()==4) {
					break;
				}
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*2;
					um.enemy.get(rNum).deadSet();
					System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==1) { // ������
			// ����â : ������ 3���� �������� �ش�
			System.out.println("������� [����â]�� �����ߴ�!");
			while(true) { 
				if(EnemyCheck()==4) {
					break;
				}
				int rNum = rn.nextInt(4);
				if(!um.enemy.get(rNum).getDead()) {
					int atk = um.party.get(idx).getAtk()*3;
					um.enemy.get(rNum).deadSet();
					System.out.printf("[%s]���� [%d]�� ������!\n",um.enemy.get(rNum).getnName(), atk);
					um.enemy.get(rNum).setHp(atk);
					break;
				}
			}
		}
		else if(idx==2) { // ����
			// �͵� : ������ 2�ϰ� ���� �Ǵ�
			System.out.println("������ [��]�� �ѷȴ�!");
			for(int i=0; i<um.enemy.size(); i++) {
				if(!um.enemy.get(i).getDead() && um.enemy.get(i).getState()==0) {
						um.enemy.get(i).setState(3);
						break;
				}
			}
		}
		else if(idx==3) { // ����
			// ��ü ȸ�� : ��� �Ʊ��� ü���� 70��ŭ ȸ���Ѵ�
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
	
	
	public void EnemyTurn() { // 1 , 8 �� �ƴϸ� �ൿ����
		if(EnemyCheck()!=4) {
			System.out.println("===== ������ ��! =====");
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
				if(rNum==0) { // ��ų
					if(um.enemy.get(i).getnName().equals("�� ũ")) {
						UnitOrc orc = (UnitOrc) um.enemy.get(i);
						int atk = orc.getSkill();
						System.out.println("[�� ũ]�� ����!");
						System.out.println("[�� ũ]�� [�Ӹ����]�� ����ߴ�!");
						EnemyAttack(atk);
					}
					else if(um.enemy.get(i).getnName().equals("������")) {
						UnitSlime slime = (UnitSlime) um.enemy.get(i);
						int atk = slime.getSkill();
						System.out.println("[������]�� ����!");
						System.out.println("[������]�� [��Ű��]�� ����ߴ�!");
						EnemyAttack(atk);
					}
					else if(um.enemy.get(i).getnName().equals("���")) {
						UnitGoblin goblin = (UnitGoblin) um.enemy.get(i);
						int atk = goblin.getSkill();
						System.out.println("[���]�� ����!");
						System.out.println("[���]�� [��Ÿ]�� ����ߴ�!");
						EnemyAttack(atk);
					}
					else if(um.enemy.get(i).getnName().equals("�� ��")) {
						UnitGhost ghost = (UnitGhost) um.enemy.get(i);
						int atk = ghost.getSkill();
						System.out.println("[�� ��]�� ����!");
						System.out.println("[�� ��]�� [�Ű��]�� ����ߴ�!");
						EnemyAttack(atk);
					}
					PlayerCheck();
				}
				else {
					System.out.printf("[%s]�� ����!\n",um.enemy.get(i).getnName());
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
				System.out.printf("[%s]���� [%d]�� ������!\n",um.party.get(rNum).getnName(), atk);
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
