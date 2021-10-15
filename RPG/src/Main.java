import java.util.Random;

public class Main {
	public static Random rn = new Random();
	public static Shop sp = new Shop();
	public static Guild gd = new Guild();
	private Unit ut = Unit.instance;
	
// 메인메뉴
// ㄴ 길드관리, 상점, 인벤토리, 저장, 로드
	public void run() {
		ut.playerSet();
		gd.guildSet();
		sp.weaponSet();
		sp.armorSet();
		sp.ringSet();
		while(true) {
			gd.guildTitle();
			printMenu();
			menuInput();
		}
	}
	
	public void printMenu() {
		System.out.println("1.길드관리\n2.상점\n3.인벤토리\n4.저장\n5.로드\n6.종료");
	}
	
	public void menuInput() {
		String input = Shop.sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {//길드관리
				gd.guildMenu();
			}
			else if(num==2) {//상점
				sp.shopMenu();
			}
			else if(num==3) {//인벤토리
				gd.inventoryMenu();
			}
			else if(num==4) {//저장
				
			}
			else if(num==5) {//로드
				
			}
			else if(num==6) {//종료
				
			}
			
		} catch (Exception e) {
		}
		
	}
	

	
//	번호, 이름, 레벨, 채력, 공격력, 방어력, 파티여부
	
	

	
//	번호, 이름, 공격력, 가격
	
//	인벤토리
//	ㄴ 착용, 판매
	
//	이름, 레벨, 체력, 공격력, 방어력, 파티여부
//	무기
//	방어구
//	반지
	
	
//	파일
//	길드
//	인벤토리
//	아이템
//	상점
//	플레이어
//	메인
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
}
