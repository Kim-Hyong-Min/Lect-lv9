package Manager;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import source.Student;

interface input {
	public Scanner sc = new Scanner(System.in);
	public Random rn = new Random();
}

public class StudentManager implements input{
	private static StudentManager instance = new StudentManager();
	public static StudentManager getInstance() {return instance;};
	private ArrayList<Student>student = new ArrayList<>();
	// �л� ���(���̵� ��� ����)
	
	
	
	public void join() {
		while(true) {
			System.out.print("���̵� �Է� : ");
			String id = sc.next();
			System.out.print("��й�ȣ �Է� : ");
			String pw = sc.next();
			System.out.print("�̸� �Է� : ");
			String name = sc.next();
			System.out.print("���� �Է� : ");
			String age = sc.next();
			
			if(Student.getInstance().checkId(id)) {
				try {
					int num = Integer.parseInt(age);
					if(num>0) {
						if(student.size()>0) {
							
						}
						else {
							int rNum = rn.nextInt(8999)+1000;
							int hakbun = 0;
							
							
							Student s = new Student(name, rNum, num, id, pw);
							student.add(s);
							System.out.println("���� �Ϸ�!");
							break;
						}
					}
					else System.out.println("�߸��� ���� �Դϴ�.");
					
				} catch (Exception e) {
				}
			}
			else System.out.println("�ش� ���̵�� ����Ͻ� �� �����ϴ�.");
		}
	}
	
	public void login() {
		while(true) {
			System.out.print("���̵� �Է� : ");
			String id = sc.next();
			System.out.print("��й�ȣ �Է� : ");
			String pw = sc.next();
			
			if(id.equals(Student.getInstance().ManagerId) && pw.equals(Student.getInstance().ManagerPw)) {
				//������ ���
				ManagerMain();
			}
			else {
				//�л� ���
				StudentMain(0);
			}
		}
	}
	
	
	private void ManagerMain() {
		while(true) {
			System.out.println("[1]���� ����\n[2]�л� ����\n[3]��ü ��ȸ\n[4]�ڷΰ���\n");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					ManagerSubject();
				}
				else if(num == 2) {
					ManagerStudent();
				}
				else if(num == 3) {
					ManagerPrintAll();
				}
				else if(num == 4) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerSubject() {
		while(true) {
			System.out.println("[1]���� ���\n[2]���� ����\n[3]���� ��ȸ\n[4]�ڷ� ����\n");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					
				}
				else if(num == 2) {
					
				}
				else if(num == 3) {
					
				}
				else if(num == 4) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerStudent() {
		while(true) {
			System.out.println("[1]�л� ���\n[2]�л� ����\n[3]�л� ��ȸ\n[4]�ڷ� ����\n");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					
				}
				else if(num == 2) {
					if(student.size()>0) {
						
					}
					else System.out.println("��ϵ� �л��� �����ϴ�.");
				}
				else if(num == 3) {
					if(student.size()>0) {
						
					}
					else System.out.println("��ϵ� �л��� �����ϴ�.");
				}
				else if(num == 4) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerPrintAll() {
		
	}
	
	private void StudentMain(int idx) {
		while(true) {
			student.get(idx).printStudent();
			System.out.println("[1]���� ���\n[2]���� ���\n[3]���� ��ȸ\n[4]�ڷ� ����\n");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					
				}
				else if(num == 2) {
					
				}
				else if(num == 3) {
					
				}
				else if(num == 4) {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
}
