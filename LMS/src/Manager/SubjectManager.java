package Manager;

import java.util.ArrayList;

import source.Hakgua;
import source.Student;
import source.Subject;

public class SubjectManager implements input{
	private static SubjectManager instance = new SubjectManager();
	public static SubjectManager getInstance() {return instance;};
	private StudentManager sm = StudentManager.getInstance();
	// 강의 등록, 학과 등록
	public ArrayList<Hakgua> hakgua = new ArrayList<>();
	public ArrayList<Subject> subject = new ArrayList<>();
	
	public void setup() {
		Hakgua h = new Hakgua("토목과", 10001, "둘리", "도우너"){};
		hakgua.add(h);
		h = new Hakgua("화학과", 10002, "고길동", "또치"){};
		hakgua.add(h);
		h = new Hakgua("미술과", 10003, "호식이", "정한울"){};
		hakgua.add(h);
		h = new Hakgua("법학과", 10004, "정기태", "진시원"){};
		hakgua.add(h);
		h = new Hakgua("철학과", 10005, "스티븐", "김보선"){};
		hakgua.add(h);
		
		Subject s = new Subject("건축학개론", "둘리", 10001, 20001, 30);
		subject.add(s);
		s = new Subject("폭탄제작법", "고길동", 10002, 20002, 25);
		subject.add(s);
		s = new Subject("동양화의 기법", "호식이", 10003, 20003, 15);
		subject.add(s);
		s = new Subject("서양 미술론", "정한울", 10003, 20004, 20);
		subject.add(s);
		s = new Subject("법학이론", "정기태", 10004, 20005, 25);
		subject.add(s);
		s = new Subject("죄와벌", "진시원", 10004, 20006, 30);
		subject.add(s);
		s = new Subject("인생이란 무엇인가", "스티븐", 10005, 20007, 40);
		subject.add(s);
	}
	
	public void joinSubject() {
		for(int i=0; i<this.subject.size(); i++) {
			subject.get(i).printSubject(i);
		}
		System.out.printf("[%d]뒤로가기\n",this.subject.size()+1);
		while(true) {
			System.out.print("입력 : ");
			String choice = sc.next();
			try {
				int num = Integer.parseInt(choice)-1;
				if(num>=0 && num<this.subject.size()) {
					if(this.subject.get(num).totalNumCheck()) {
						Subject s = this.subject.get(num);
						if(sm.student.get(sm.log).checkSubject(s.getTitle())==-1) {
							sm.student.get(sm.log).addSubject(s);
							this.subject.get(num).StudentAdd();
							System.out.println("수업 신청 완료!");
							break;							
						}
						else {
							System.out.println("이미 신청한 수업 입니다.");
						}
					}
					else System.out.println("정원 초과 입니다.");
				}
				else if(num == this.subject.size()) {
					break;
				}
				else System.out.println("잘못된 선택 입니다.");
			} catch (Exception e) {
			}
			
		}
	}
	public void SubjectRemove() {
		if(sm.student.get(sm.log).getSubjectNum()>0) {
			sm.student.get(sm.log).printSubject();
			System.out.printf("[%d] 뒤로가기\n",sm.student.get(sm.log).getSubjectNum()+1);
			while(true) {
				System.out.print("입력 : ");
				String choice = sc.next();
				try {
					int num = Integer.parseInt(choice)-1;
					if(num>=0 && num<sm.student.get(sm.log).getSubjectNum()) {
						sm.student.get(sm.log).subject.remove(num);
						System.out.println("철회 완료!");
						break;
					}
					else if(num == sm.student.get(sm.log).getSubjectNum()) {
						break;
					}
					else System.out.println("잘못된 선택 입니다.");
				}catch (Exception e) {
				}
			}
		}
		else System.out.println("등록하신 수업이 없습니다.");
	}
	
	public void SubjectScoreSet() {
		if(sm.student.get(sm.log).getSubjectNum()>0) {
			sm.student.get(sm.log).printSubject();
			System.out.printf("[%d] 뒤로가기\n",sm.student.get(sm.log).getSubjectNum()+1);
			while(true) {
				System.out.print("입력 : ");
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
					else System.out.println("잘못된 선택 입니다.");
				}catch (Exception e) {
				}
			}
		}
		else System.out.println("등록하신 수업이 없습니다.");
	}
	
	public void ScoreInput(int idx) {
		System.out.print("성적 입력 (0~100): ");
		String score = sc.next();
		try {
			int num = Integer.parseInt(score);
			if(num>=0 && num<=100) {
				sm.student.get(sm.log).subject.get(idx).setScore(num);
				System.out.println("성적 입력 완료!");
			}
			else System.out.println("잘못된 성적값 입니다.");
		}catch (Exception e) {
		}
	}
	
	public void printAllSubject() {
		if(sm.student.get(sm.log).getSubjectNum()>0) {
			sm.student.get(sm.log).printSubject();
		}
		else System.out.println("등록하신 수업이 없습니다.");
	}
	
	public void SubjectAddManager() {
			System.out.print("수업명 입력 : ");
			String name = sc.next();
			int check = -1;
			for(int i=0; i<this.subject.size(); i++) {
				if(this.subject.get(i).getTitle().equals(name)) {
					check = i;
				}
			}
			if(check == -1) {
				while(true) {
					System.out.println("====학과 선택====");
					for(int i=0; i<this.hakgua.size(); i++) {
						System.out.printf("[%d] %s\n",i+1,this.hakgua.get(i).getHakguaName());
					}
					System.out.print("입력 : ");
					String choice = sc.next();
					try {
						int cnt = Integer.parseInt(choice)-1;
						if(cnt>=0 && cnt<this.hakgua.size()) {
							
							break;
						}
						else System.out.println("잘못된 선택 입니다.");
					} catch (Exception e) {
					}
				}
			}
			else System.out.println("동일한 이름의 수업이 존재합니다.");
	}
	
	public void SubjectAddPro() {
		
	}
	
	public void SubjectRemoveManager() {
		
	}
	
	public void printSubjectManager() {
		
	}
	
}
