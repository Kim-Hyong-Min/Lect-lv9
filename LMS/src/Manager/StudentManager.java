package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import source.Student;

interface input {
	public Scanner sc = new Scanner(System.in);
}

public class StudentManager implements input{
	private static StudentManager instance = new StudentManager();
	public static StudentManager getInstance() {return instance;};
	private ArrayList<Student>student = new ArrayList<>();
	// �л� ���(���̵� ��� ����)
	
	
	
	public void join() {
		System.out.print("���̵� �Է� : ");
		String id = sc.next();
		System.out.print("��й�ȣ �Է� : ");
		String pw = sc.next();
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� �Է� : ");
		String age = sc.next();
		
		if(student.size()>0) {
			
		}
		else {
			
		}
	}
}
