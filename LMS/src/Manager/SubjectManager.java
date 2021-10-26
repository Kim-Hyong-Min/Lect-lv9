package Manager;

import java.util.ArrayList;

import source.Hakgua;
import source.Student;
import source.Subject;

public class SubjectManager implements input{
	private static SubjectManager instance = new SubjectManager();
	public static SubjectManager getInstance() {return instance;};
	
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
	
	public void hakguaChoice() {
		while(true) {
			for(int i=0; i<hakgua.size(); i++) {
				
			}
		}
	}
	
	
	public void printAllSubject() {
		
	}
	
}
