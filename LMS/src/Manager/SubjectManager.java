package Manager;

import java.util.ArrayList;

import source.Hakgua;
import source.Student;
import source.Subject;

public class SubjectManager implements input{
	private static SubjectManager instance = new SubjectManager();
	public static SubjectManager getInstance() {return instance;};
	private StudentManager sm = StudentManager.getInstance();
	// ���� ���, �а� ���
	public ArrayList<Hakgua> hakgua = new ArrayList<>();
	public ArrayList<Subject> subject = new ArrayList<>();
	
	public void setup() {
		Hakgua h = new Hakgua("����", 10001, "�Ѹ�", "�����"){};
		hakgua.add(h);
		h = new Hakgua("ȭ�а�", 10002, "��浿", "��ġ"){};
		hakgua.add(h);
		h = new Hakgua("�̼���", 10003, "ȣ����", "���ѿ�"){};
		hakgua.add(h);
		h = new Hakgua("���а�", 10004, "������", "���ÿ�"){};
		hakgua.add(h);
		h = new Hakgua("ö�а�", 10005, "��Ƽ��", "�躸��"){};
		hakgua.add(h);
		
		Subject s = new Subject("�����а���", "�Ѹ�", 10001, 20001, 30);
		subject.add(s);
		s = new Subject("��ź���۹�", "��浿", 10002, 20002, 25);
		subject.add(s);
		s = new Subject("����ȭ�� ���", "ȣ����", 10003, 20003, 15);
		subject.add(s);
		s = new Subject("���� �̼���", "���ѿ�", 10003, 20004, 20);
		subject.add(s);
		s = new Subject("�����̷�", "������", 10004, 20005, 25);
		subject.add(s);
		s = new Subject("�˿͹�", "���ÿ�", 10004, 20006, 30);
		subject.add(s);
		s = new Subject("�λ��̶� �����ΰ�", "��Ƽ��", 10005, 20007, 40);
		subject.add(s);
	}
	
	public void joinSubject() {
		for(int i=0; i<this.subject.size(); i++) {
			subject.get(i).printSubject(i);
		}
		System.out.printf("[%d]�ڷΰ���\n",this.subject.size()+1);
		while(true) {
			System.out.print("�Է� : ");
			String choice = sc.next();
			try {
				int num = Integer.parseInt(choice)-1;
				if(num>=0 && num<this.subject.size()) {
					if(this.subject.get(num).totalNumCheck()) {
						Subject s = this.subject.get(num);
						if(sm.student.get(sm.log).checkSubject(s.getTitle())==-1) {
							sm.student.get(sm.log).addSubject(s);
							this.subject.get(num).StudentAdd();
							System.out.println("���� ��û �Ϸ�!");
							break;							
						}
						else {
							System.out.println("�̹� ��û�� ���� �Դϴ�.");
						}
					}
					else System.out.println("���� �ʰ� �Դϴ�.");
				}
				else if(num == this.subject.size()) {
					break;
				}
				else System.out.println("�߸��� ���� �Դϴ�.");
			} catch (Exception e) {
			}
			
		}
	}
	public void SubjectRemove() {
		if(sm.student.get(sm.log).getSubjectNum()>0) {
			sm.student.get(sm.log).printSubject();
			System.out.printf("[%d] �ڷΰ���\n",sm.student.get(sm.log).getSubjectNum()+1);
			while(true) {
				System.out.print("�Է� : ");
				String choice = sc.next();
				try {
					int num = Integer.parseInt(choice)-1;
					if(num>=0 && num<sm.student.get(sm.log).getSubjectNum()) {
						sm.student.get(sm.log).subject.remove(num);
						System.out.println("öȸ �Ϸ�!");
						break;
					}
					else if(num == sm.student.get(sm.log).getSubjectNum()) {
						break;
					}
					else System.out.println("�߸��� ���� �Դϴ�.");
				}catch (Exception e) {
				}
			}
		}
		else System.out.println("����Ͻ� ������ �����ϴ�.");
	}
	
	public void SubjectScoreSet() {
		if(sm.student.get(sm.log).getSubjectNum()>0) {
			sm.student.get(sm.log).printSubject();
			System.out.printf("[%d] �ڷΰ���\n",sm.student.get(sm.log).getSubjectNum()+1);
			while(true) {
				System.out.print("�Է� : ");
				String choice = sc.next();
				try {
					int num = Integer.parseInt(choice)-1;
					if(num>=0 && num<sm.student.get(sm.log).getSubjectNum()) {
						ScoreInput(num);
						break;
					}
					else if(num == sm.student.get(sm.log).getSubjectNum()) {
						break;
					}
					else System.out.println("�߸��� ���� �Դϴ�.");
				}catch (Exception e) {
				}
			}
		}
		else System.out.println("����Ͻ� ������ �����ϴ�.");
	}
	
	public void ScoreInput(int idx) {
		System.out.print("���� �Է� (0~100): ");
		String score = sc.next();
		try {
			int num = Integer.parseInt(score);
			if(num>=0 && num<=100) {
				sm.student.get(sm.log).subject.get(idx).setScore(num);
				System.out.println("���� �Է� �Ϸ�!");
			}
			else System.out.println("�߸��� ������ �Դϴ�.");
		}catch (Exception e) {
		}
	}
	
	public void printAllSubject() {
		if(sm.student.get(sm.log).getSubjectNum()>0) {
			sm.student.get(sm.log).printSubject();
		}
		else System.out.println("����Ͻ� ������ �����ϴ�.");
	}
	
	public void SubjectAddManager() {
			System.out.print("������ �Է� : ");
			String name = sc.next();
			int check = -1;
			for(int i=0; i<this.subject.size(); i++) {
				if(this.subject.get(i).getTitle().equals(name)) {
					check = i;
				}
			}
			if(check == -1) {
				while(true) {
					System.out.println("====�а� ����====");
					for(int i=0; i<this.hakgua.size(); i++) {
						System.out.printf("[%d] %s\n",i+1,this.hakgua.get(i).getHakguaName());
					}
					System.out.print("�Է� : ");
					String choice = sc.next();
					try {
						int cnt = Integer.parseInt(choice)-1;
						if(cnt>=0 && cnt<this.hakgua.size()) {
							
							break;
						}
						else System.out.println("�߸��� ���� �Դϴ�.");
					} catch (Exception e) {
					}
				}
			}
			else System.out.println("������ �̸��� ������ �����մϴ�.");
	}
	
	public void SubjectAddPro() {
		
	}
	
	public void SubjectRemoveManager() {
		
	}
	
	public void printSubjectManager() {
		
	}
	
}
