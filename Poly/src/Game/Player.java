package Game;

public class Player extends Unit{
	Player(String name , int hp , int mp ,int atk){
		super(name, hp , mp, atk);
	}
	
	public void playerUi() {
		
	}
	
	public void playerSkill() {
		if(this.name.equals("�� ��")) {
			System.out.println("1.[���] : ���� ������ 1ȸ ���´�\n2.[��Ÿ] : 2���� ���ݷ����� �����Ѵ�\n3.[]");
		}
		else if(this.name.equals("������")) {
			
		}
		else if(this.name.equals("�� ��")) {
			
		}
		else if(this.name.equals("�� ��")) {
			
		}
	}
}
