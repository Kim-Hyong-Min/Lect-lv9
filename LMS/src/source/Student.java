package source;
import java.util.ArrayList;

import Manager.StudentManager;
import Manager.SubjectManager;

interface Manager{
	public static final String ManagerId = "qwer";
	public static final String ManagerPw = "1111";
	public boolean checkId(String inputId);
}

public class Student extends Hakgua implements Manager {
	private static Student instance = new Student();
	public static Student getInstance() {return instance;};
	// 이름, 학번, 나이, 아이디, 비밀번호, 신청과목(배열)
	private String name;
	private int hakbun;
	private int HakguaNum;
	private int age;
	private String id;
	private String pw;
	public ArrayList<Subject>subject = new ArrayList<>();
	
	Student(){}
	
	public Student(String name, int hakbun, int age, int HakguaNum, String id, String pw){
		this.name = name;
		this.hakbun = hakbun;
		this.age = age;
		this.HakguaNum = HakguaNum;
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public int getHakbun() {
		return this.hakbun;
	}
	
	public int getSubjectNum() {
		return this.subject.size();
	}
	
	public int checkSubject(String title) {
		int check = -1;
		if(this.subject.size()>0) {
			for(int i=0; i<this.subject.size(); i++) {
				if(this.subject.get(i).getTitle().equals(title)) {
					check = i;
				}
			}
		}
		return check;
	}
	
	public void addSubject(Subject subject) {
		this.subject.add(subject);
	}
	
	public void printStudent() {
		System.out.println("================");
		System.out.printf("[%s]님 어서오세요!\n",this.name);
		System.out.printf("학번 : %d | 나이 : %d\n",this.hakbun, this.age);
		String hakName = "";
		for(int i=0; i<SubjectManager.getInstance().hakgua.size(); i++) {
			if(SubjectManager.getInstance().hakgua.get(i).getHakguaNum() == HakguaNum) {
				hakName = SubjectManager.getInstance().hakgua.get(i).getHakguaName();
			}
		}
		System.out.printf("등록 학과 : %s | 등록 강의수 : %d\n",hakName, this.subject.size());
	}
	
	public void printSubject() {
		for(int i=0; i<this.subject.size(); i++) {
			System.out.printf("[%d] %s | 성적 : %d점\n",i+1,this.subject.get(i).getTitle(), this.subject.get(i).getScore());
		}
	}

	@Override
	public void checkHakgua() {
		
	}

	@Override
	public boolean checkId(String inputId) {
		if(ManagerId.equals(inputId)) {
			return false;
		}
		else {
			return true;
		}
	}

	
}
