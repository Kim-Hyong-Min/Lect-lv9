import controller.BankManager;
import models.Bank;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * atm
		 * 
		 * 1. 회원가입/탈퇴 v
		 * 2. 로그인 v
		 * 3. 계좌개설/철회 (회원당 3개 계좌 제한) v
		 * 4. 뱅킹기능 (입금/출금/이체/조회) v
		 * 5. 파일처리 (저장/로드) v
		 * 6. 관리자모드 (admin/0000 -> 전체유저조회/전체계좌조회 v
		 */
		
		/*
		 * models 패키지 안에 객체화할 클래스들을 정의
		 * ㄴ User v
		 * ㄴ Account v
		 * ㄴ Bank v
		 */
		
		/*
		 * controller 패키지 안에 객체 처리를 할 기능(메소드) 정의
		 * ㄴ UserManager (User 타입의 객체배열) v
		 * ㄴ AccountManager (Account 타입의 객체배열) v
		 * ㄴ BankManager v
		 * ㄴ FileManager v
		 */
		
		Bank.setName("GREEN");
		BankManager.instance.run();
	}

}
