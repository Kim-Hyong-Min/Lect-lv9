
public class Guild {
	private int playerCode;
//	길드관리
//	ㄴ 길드목록, 길드원추가, 길드원삭제, 파티원교체, 정렬
	public void guildMenu() {
		while(true) {
			System.out.println("1.길드원 목록\n2.길드원 영입\n3.길드원 해고\n4.파티원 설정\n5.정렬\n6.뒤로가기");
			String input = Shop.sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {//길드원 목록
					guildList();
				}
				else if(num==2) {//길드원 영입
					guildAdd();
				}
				else if(num==3) {//길드원 해고
					guildRemove();
				}
				else if(num==4) {//파티원 설정
					party();
				}
				else if(num==5) {//정렬
					guildLineup();
				}
				else if(num==6) {//뒤로가기
					
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	public void guildList() {//길드원 목록
		
	}
	
	public void guildAdd() {//길드원 영입
		
	}
	
	public void guildRemove() {//길드원 해고
		
	}
	
	public void party() {//파티원 설정
		//파티원 추가
		//파티원 삭제
		//파티원 보기
	}
	
	public void guildLineup() {//정렬
		
	}
}
