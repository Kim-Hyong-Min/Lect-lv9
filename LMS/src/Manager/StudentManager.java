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
	private SubjectManager sm = SubjectManager.getInstance();
	private Student sd = Student.getInstance();
	public static StudentManager getInstance() {return instance;};
	public ArrayList<Student>student = new ArrayList<>();
	// �л� ���(���̵� ��� ����)
	public static int log = -1;
	
	
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
							joinCheck(name, num, id, pw);
							break;
						}
						else {
							int rNum = rn.nextInt(8999)+1000;
							int hakbun = 0;
							hakguaChoice(name, rNum, num, id, pw);
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
	
	public void joinCheck(String name, int num, String id, String pw) {
		int check = -1;
		for(int i = 0; i<this.student.size(); i++) {
			if(this.student.get(i).getId().equals(id)) {
				check = 1;
			}
		}
		if(check==-1) {
			while(true) {
				int rNum = rn.nextInt(8999)+1000;
				for(int i = 0; i<this.student.size(); i++) {
					if(this.student.get(i).getHakbun() == rNum) {
						rNum = 0;
					}
				}
				if(rNum != 0) {
					hakguaChoice(name, rNum, num, id, pw);
					break;
				}
			}
		}
		else System.out.println("������ ���̵� �����մϴ�.");
	}
	
	public void hakguaChoice(String name, int rNum, int num, String id, String pw) {
		while(true) {
			System.out.println("====�а� ����====");
			for(int i=0; i<sm.hakgua.size(); i++) {
				System.out.printf("[%d] %s\n",i+1,sm.hakgua.get(i).getHakguaName());
			}
			System.out.print("�Է� : ");
			String choice = sc.next();
			try {
				int cnt = Integer.parseInt(choice)-1;
				if(cnt>=0 && cnt<sm.hakgua.size()) {
					Student s = new Student(name, rNum, num, sm.hakgua.get(cnt).getHakguaNum(), id, pw);
					student.add(s);
					System.out.println("���� �Ϸ�!");
					break;
				}
				else System.out.println("�߸��� ���� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
	public void login() {
		while(true) {
			System.out.print("���̵� �Է� : ");
			String id = sc.next();
			System.out.print("��й�ȣ �Է� : ");
			String pw = sc.next();
			
			if(id.equals(sd.ManagerId) && pw.equals(sd.ManagerPw)) {
				//������ ���
				ManagerMain();
				break;
			}
			else {
				//�л� ���
				loginCheck(id, pw);
				break;
			}
		}
	}
	
	public void loginCheck(String id, String pw) {
		int check = -1;
		for(int i = 0; i<this.student.size(); i++) {
			if(this.student.get(i).getId().equals(id) && this.student.get(i).getPw().equals(pw)) {
				check = i;
			}
		}
		if(check != -1) {
			this.log = check;
			StudentMain(check);
		}
		else System.out.println("���̵� Ȥ�� ��й�ȣ�� �ٽ� Ȯ�� ���ּ���.");
	}
	
	
	private void ManagerMain() {
		System.out.println("==== ������ �޴� ====");
		System.out.println("[1]���� ����\n[2]�л� ����\n[2]�а� ����\n[3]��ü ��ȸ\n[4]�ڷΰ���\n");
		while(true) {
			System.out.print("�Է� : ");
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
				else System.out.println("�߸��� �Է� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerSubject() {
		System.out.println("==== ���� ���� ====");
		System.out.println("[1]���� ���\n[2]���� ����\n[3]���� ��ȸ\n[4]�ڷ� ����\n");
		while(true) {
			System.out.print("�Է� : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					sm.SubjectAddManager();
				}
				else if(num == 2) {
					sm.SubjectRemoveManager();
				}
				else if(num == 3) {
					
				}
				else if(num == 4) {
					break;
				}
				else System.out.println("�߸��� �Է� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerStudent() {
		System.out.println("==== �л� ���� ====");
		System.out.println("[1]�л� ���\n[2]�л� ����\n[3]�л� ��ȸ\n[4]�ڷ� ����\n");
		while(true) {
			System.out.print("�Է� : ");
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
				else System.out.println("�߸��� �Է� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerHakgua() {
		System.out.println("==== �а� ���� ====");
		System.out.println("[1]�а� ���\n[2]�а� ����\n[3]�а� ��ȸ\n[4]�ڷ� ����\n");
		while(true) {
			System.out.print("�Է� : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					
				}
				else if(num == 2) {
					if(student.size()>0) {
						
					}
					else System.out.println("��ϵ� �а��� �����ϴ�.");
				}
				else if(num == 3) {
					if(student.size()>0) {
						
					}
					else System.out.println("��ϵ� �а��� �����ϴ�.");
				}
				else if(num == 4) {
					break;
				}
				else System.out.println("�߸��� �Է� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerPrintAll() {
		
	}
	
	private void StudentMain(int idx) {
		while(true) {
			student.get(idx).printStudent();
			System.out.println("[1]���� ��û\n[2]���� öȸ\n[3]���� ���\n[4]���� ��ȸ\n[5]�ڷ� ����\n");
			System.out.print("�Է� : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					sm.joinSubject();
				}
				else if(num == 2) {
					sm.SubjectRemove();
				}
				else if(num == 3) {
					sm.SubjectScoreSet();
				}
				else if(num == 4) {
					sm.printAllSubject();
				}
				else if(num == 5) {
					this.log = -1;
					break;
				}
				else System.out.println("�߸��� �Է� �Դϴ�.");
			} catch (Exception e) {
			}
		}
	}
	
}
