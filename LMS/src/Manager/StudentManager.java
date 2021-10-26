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
	// 학생 등록(아이디 비번 가입)
	public static int log = -1;
	
	
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
					else System.out.println("잘못된 나이 입니다.");
					
				} catch (Exception e) {
				}
			}
			else System.out.println("해당 아이디는 사용하실 수 없습니다.");
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
		else System.out.println("동일한 아이디가 존재합니다.");
	}
	
	public void hakguaChoice(String name, int rNum, int num, String id, String pw) {
		while(true) {
			System.out.println("====학과 선택====");
			for(int i=0; i<sm.hakgua.size(); i++) {
				System.out.printf("[%d] %s\n",i+1,sm.hakgua.get(i).getHakguaName());
			}
			System.out.print("입력 : ");
			String choice = sc.next();
			try {
				int cnt = Integer.parseInt(choice)-1;
				if(cnt>=0 && cnt<sm.hakgua.size()) {
					Student s = new Student(name, rNum, num, sm.hakgua.get(cnt).getHakguaNum(), id, pw);
					student.add(s);
					System.out.println("가입 완료!");
					break;
				}
				else System.out.println("잘못된 선택 입니다.");
			} catch (Exception e) {
			}
		}
	}
	
	public void login() {
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			System.out.print("비밀번호 입력 : ");
			String pw = sc.next();
			
			if(id.equals(sd.ManagerId) && pw.equals(sd.ManagerPw)) {
				//관리자 모드
				ManagerMain();
				break;
			}
			else {
				//학생 모드
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
		else System.out.println("아이디 혹은 비밀번호를 다시 확인 해주세요.");
	}
	
	
	private void ManagerMain() {
		System.out.println("==== 관리자 메뉴 ====");
		System.out.println("[1]수업 관리\n[2]학생 관리\n[2]학과 관리\n[3]전체 조회\n[4]뒤로가기\n");
		while(true) {
			System.out.print("입력 : ");
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
				else System.out.println("잘못된 입력 입니다.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerSubject() {
		System.out.println("==== 수업 관리 ====");
		System.out.println("[1]수업 등록\n[2]수업 제거\n[3]수업 조회\n[4]뒤로 가기\n");
		while(true) {
			System.out.print("입력 : ");
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
				else System.out.println("잘못된 입력 입니다.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerStudent() {
		System.out.println("==== 학생 관리 ====");
		System.out.println("[1]학생 등록\n[2]학생 제거\n[3]학생 조회\n[4]뒤로 가기\n");
		while(true) {
			System.out.print("입력 : ");
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
				else System.out.println("잘못된 입력 입니다.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerHakgua() {
		System.out.println("==== 학과 관리 ====");
		System.out.println("[1]학과 등록\n[2]학과 제거\n[3]학과 조회\n[4]뒤로 가기\n");
		while(true) {
			System.out.print("입력 : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num == 1) {
					
				}
				else if(num == 2) {
					if(student.size()>0) {
						
					}
					else System.out.println("등록된 학과가 없습니다.");
				}
				else if(num == 3) {
					if(student.size()>0) {
						
					}
					else System.out.println("등록된 학과가 없습니다.");
				}
				else if(num == 4) {
					break;
				}
				else System.out.println("잘못된 입력 입니다.");
			} catch (Exception e) {
			}
		}
	}
	
	private void ManagerPrintAll() {
		
	}
	
	private void StudentMain(int idx) {
		while(true) {
			student.get(idx).printStudent();
			System.out.println("[1]수강 신청\n[2]수강 철회\n[3]성적 등록\n[4]성적 조회\n[5]뒤로 가기\n");
			System.out.print("입력 : ");
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
				else System.out.println("잘못된 입력 입니다.");
			} catch (Exception e) {
			}
		}
	}
	
}
