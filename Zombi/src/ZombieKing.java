
public class ZombieKing {
	private static ZombieKing instance = new ZombieKing();
	public static ZombieKing getInstance() {return instance;}
	public int Lazer() {
		int dmg = 50;
		System.out.println("������� �տ��� �������� ���!");
		System.out.println("50�� ������!");
		return dmg;
	}
	
	public int hug() {
		int dmg = 30;
		System.out.println("���ڱ� ������� ��ŭ��ŭ �ٰ��ͼ� ���ȴ´�!");
		System.out.println("30�� ������!");
		return dmg;
	}
	
	public int slap() {
		System.out.println("����� ������� �ٰ��� ���� ���ȴ�!");
		System.out.println("15�� ������!");
		int dmg = 15;
		return dmg;
	}
	
	public void LazerReady() {
		System.out.println("���ڱ� ����� �⸦ ������ �����ߴ�!");
	}
	
	public void dance() {
		System.out.println("���ڱ� ������� ���� �߱� �����ߴ�!");
	}
	
	public void nose() {
		System.out.println("������� ������ �ڸ� �İ� �ִ�!");
	}
}
