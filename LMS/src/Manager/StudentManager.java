package Manager;

import java.util.ArrayList;

public class StudentManager {
	private static StudentManager instance = new StudentManager();
	public static StudentManager getInstance() {return instance;};
	// 학생 등록(아이디 비번 가입)
	private ArrayList<Student>student = new ArrayList<>();
	
	
	
	public void join() {
		System.out.print("아이디 입력 : ");
		System.out.print("비밀번호 입력 : ");
		System.out.print("이름 입력 : ");
		System.out.print("나이 입력 : ");
	}
}
