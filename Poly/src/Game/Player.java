package Game;

import java.util.Vector;

public class Player extends Unit{
	Vector<Inventory>item = new Vector<>();
	
	Player(String name , int hp , int mp ,int atk){
		super(name, hp , mp, atk);
	}
	
	public void playerUi() {
		System.out.printf("[%s] 1.[����] 2.[��ų]\n",this.name);
	}
	
	
	public void printPlayerSkill() {
		System.out.println("==== �� ų ====");
		if(this.name.equals("�� ��")) {
			System.out.println("1.[�ֵθ���] [MP:5]: ������ 150�� �������� �ش�\n2.[��Ÿ] [MP:10]: ������ 2���� �������� �ش�");
		}
		else if(this.name.equals("������")) {
			System.out.println("1.[ȭ����] [MP:20]: ��������� 20�� �������� �ش�\n2.[����â] [MP:15]: ������ 3���� �������� �ش�");
		}
		else if(this.name.equals("�� ��")) {
			System.out.println("1.[������] [MP:15]: ���� 1�ϵ��� ����\n2.[�͵�] [MP:10]: ������ 2�ϰ� ���� �Ǵ�");
		}
		else if(this.name.equals("�� ��")) {
			System.out.println("1.[ȸ��] [MP:10]: �Ʊ��� ä���� 100��ŭ ȸ����Ų��\n2.[��ü ȸ��] [MP:40]: ��� �Ʊ��� ü���� 70��ŭ ȸ���Ѵ�");
		}
	}
	
	public boolean PlayerSkillCheck(int state) {
		boolean check = false;
		if(this.name.equals("�� ��")) {
			if(state==5) { // ��� 10
				if(mp>=10) {
					this.mp-=10;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=10) { // ��Ÿ 10
					this.mp-=10;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		else if(this.name.equals("������")) {
			if(state==5) { // ȭ���� 20
				if(mp>=20) {
					this.mp-=20;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=15) { // ����â 15
					this.mp-=15;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		else if(this.name.equals("�� ��")) {
			if(state==5) { // ������ 15
				if(mp>=15) {
					this.mp-=15;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=10) { // �͵� 10
					this.mp-=10;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		else if(this.name.equals("�� ��")) {
			if(state==5) { // ȸ�� 10
				if(mp>=10) {
					this.mp-=15;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=40) { // ��üȸ�� 40
					this.mp-=40;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		return check;
	}
}
