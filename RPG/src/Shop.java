import java.util.Scanner;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	
//	상점
//	ㄴ 무기, 갑옷, 반지
	
	public void shopMenu() {
		while(true) {
			System.out.println("1.무기\n2.갑옷\n3.반지\n4.뒤로가기");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//무기
					
				}
				else if(num==2) {//갑옷
					
				}
				else if(num==3) {//반지
					
				}
				else if(num==4) {//뒤로가기
					
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void weapon() {//무기
		
	}
	
	public void armor() {//갑옷
		
	}
	
	public void ring() {//반지
		
	}
}
