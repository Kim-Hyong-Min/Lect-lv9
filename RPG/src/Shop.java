import java.util.Scanner;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	
//	����
//	�� ����, ����, ����
	
	public void shopMenu() {
		while(true) {
			System.out.println("1.����\n2.����\n3.����\n4.�ڷΰ���");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//����
					
				}
				else if(num==2) {//����
					
				}
				else if(num==3) {//����
					
				}
				else if(num==4) {//�ڷΰ���
					
				}
				
			} catch (Exception e) {
			}
			
		}
	}
}
