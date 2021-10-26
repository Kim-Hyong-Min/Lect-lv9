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
	// 학생 등록(아이디 비번 가입)
	
	
	
	public void join() {
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		String age = sc.next();
		
		if(student.size()>0) {
			
		}
		else {
			
		}
	}
}
