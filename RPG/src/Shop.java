import java.util.Scanner;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	
//	»óÁ¡
//	¤¤ ¹«±â, °©¿Ê, ¹ÝÁö
	
	public void shopMenu() {
		while(true) {
			System.out.println("1.¹«±â\n2.°©¿Ê\n3.¹ÝÁö\n4.µÚ·Î°¡±â");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//¹«±â
					
				}
				else if(num==2) {//°©¿Ê
					
				}
				else if(num==3) {//¹ÝÁö
					
				}
				else if(num==4) {//µÚ·Î°¡±â
					
				}
				
			} catch (Exception e) {
			}
			
		}
	}
}
