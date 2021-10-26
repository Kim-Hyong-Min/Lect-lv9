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
	// 학생 등록(아이디 비번 가입)
	
	
	
	public void join() {
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			System.out.print("비밀번호 입력 : ");
			String pw = sc.next();
			System.out.print("이름 입력 : ");
			String name = sc.next();
			System.out.print("나이 입력 : ");
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
							System.out.println("가입 완료!");
							break;
						}
					}
					else System.out.println("잘못된 나이 입니다.");
					
				} catch (Exception e) {
				}
			}
			else System.out.println("해당 아이디는 사용하실 수 없습니다.");
		}
	}
	
	public void login() {
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			System.out.print("비밀번호 입력 : ");
			String pw = sc.next();
			
			if(id.equals(Student.getInstance().ManagerId) && pw.equals(Student.getInstance().ManagerPw)) {
				//관리자 모드
				ManagerMain();
			}
			else {
				//학생 모드
				StudentMain(0);
			}
		}
	}
	
	
	private void ManagerMain() {
		while(true) {
			System.out.println("[1]수업 관리\n[2]학생 관리\n[3]전체 조회\n[4]뒤로가기\n");
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
			System.out.println("[1]수업 등록\n[2]수업 제거\n[3]수업 조회\n[4]뒤로 가기\n");
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
			System.out.println("[1]학생 등록\n[2]학생 제거\n[3]학생 조회\n[4]뒤로 가기\n");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					
				}
				else if(num == 2) {
					if(student.size()>0) {
						
					}
					else System.out.println("등록된 학생이 없습니다.");
				}
				else if(num == 3) {
					if(student.size()>0) {
						
					}
					else System.out.println("등록된 학생이 없습니다.");
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
			System.out.println("[1]수업 등록\n[2]성적 등록\n[3]성적 조회\n[4]뒤로 가기\n");
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
