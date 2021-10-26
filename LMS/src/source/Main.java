package source;
import java.util.Scanner;

import Manager.StudentManager;
import Manager.SubjectManager;



public class Main {
	public Scanner sc = new Scanner(System.in);
	private static Main instance = new Main();
	public static Main getInstance() {return instance;};
	// 학생 등록, 수강 신청, 성적 관리 - 완료
	// 관리자 모드
	// ㄴ 수업 등록, 학생 관리(추가/삭제), 전체 수업/학생/성적 조회
	
	private void run() {
		
		SubjectManager.getInstance().setup();
		while(true) {
			System.out.println(printMenu());
			System.out.print("입력 : ");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {
					StudentManager.getInstance().join();
				}
				else if(num==2) {
					StudentManager.getInstance().login();
				}
				else if(num==3) {
					System.out.println("종료합니다.");
					break;
				}
				else System.out.println("잘못된 입력 입니다.");
			} catch (Exception e) {
			}
		}
	}
	
	private String printMenu() {
		String title = "[1]신규 학생 등록\n[2]로그인\n[3]종료\n";
		return title;
	}
	
	
	public static void main(String[] args) {
		Main.instance.run();
	}
}
