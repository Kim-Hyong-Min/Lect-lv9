package source;
import java.util.Scanner;

import Manager.StudentManager;
import Manager.SubjectManager;



public class Main {
	public Scanner sc = new Scanner(System.in);
	private static Main instance = new Main();
	public static Main getInstance() {return instance;};
	// �л� ���, ���� ��û, ���� ���� - �Ϸ�
	// ������ ���
	// �� ���� ���, �л� ����(�߰�/����), ��ü ����/�л�/���� ��ȸ
	
	private void run() {
		
		SubjectManager.getInstance().setup();
		while(true) {
			System.out.println(printMenu());
			System.out.print("�Է� : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {
					StudentManager.getInstance().join();
				}
				else if(num==2) {
					StudentManager.getInstance().login();
				}
				else if(num==3) {
					System.out.println("�����մϴ�.");
					break;
				}
				else System.out.println("�߸��� �Է� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
	private String printMenu() {
		String title = "[1]�ű� �л� ���\n[2]�α���\n[3]����\n";
		return title;
	}
	
	
	public static void main(String[] args) {
		Main.instance.run();
	}
}
