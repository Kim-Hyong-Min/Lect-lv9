
public class Guild {
	
//	길드관리
//	ㄴ 길드목록, 길드원추가, 길드원삭제, 파티원교체, 정렬
	public void guildMenu() {
		while(true) {
			System.out.println("1.길드원 목록\n2.길드원 영입\n3.길드원 해고\n4.파티원 교체\n5.정렬\n6.뒤로가기");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//길드원 목록
					
				}
				else if(num==2) {//길드원 영입
					
				}
				else if(num==3) {//길드원 해고
					
				}
				else if(num==4) {//파티원 교체
					
				}
				else if(num==5) {//정렬
					
				}
				else if(num==6) {//뒤로가기
					
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	
}
