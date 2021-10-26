package Manager;

import java.util.ArrayList;

import source.Hakgua;
import source.Student;
import source.Subject;

public class SubjectManager implements input{
	private static SubjectManager instance = new SubjectManager();
	public static SubjectManager getInstance() {return instance;};
	
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
	
	public void hakguaChoice() {
		while(true) {
			for(int i=0; i<hakgua.size(); i++) {
				
			}
		}
	}
	
	
	public void printAllSubject() {
		
	}
	
}
