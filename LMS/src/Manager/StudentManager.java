package Manager;

import java.util.ArrayList;

public class StudentManager {
	private static StudentManager instance = new StudentManager();
	public static StudentManager getInstance() {return instance;};
	// �л� ���(���̵� ��� ����)
	private ArrayList<Student>student = new ArrayList<>();
	
	
	
	public void join() {
		System.out.print("���̵� �Է� : ");
		System.out.print("��й�ȣ �Է� : ");
		System.out.print("�̸� �Է� : ");
		System.out.print("���� �Է� : ");
	}
}
