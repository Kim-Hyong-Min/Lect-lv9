import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Random rn = new Random();
	private static Scanner sc = new Scanner(System.in);
	private static Game instance = new Game();
	public Game getInstance() {return instance;}
	private Hero h;
	// ����
	// ���ݷ� or ���� ���
	// ü�� ȸ��
	
	public void start() {
		System.out.println("===================");
		System.out.println("[�������]�� �����߽��ϴ�!");
		System.out.println("===================");
	}
	
	public void ui() {
		System.out.println("[1]�Ʒ�������\n[2]�Ļ��ϱ�\n[3]��� ����");
		while(true) {
		System.out.print("�Է� : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {
				int rNum = rn.nextInt(3);
			}
			else if(num==2) {
				
			}
			else if(num==3) {
				
			}
			else System.out.println("�߸��� �Է� �Դϴ�.");
			
		} catch (Exception e) {
		}
		}
	}
	
	
}
