import java.util.ArrayList;

public class Guild {
	ArrayList<Inventory> inven = new ArrayList<>();
	private String gulidName;
	private int playerCode;
	private int guildMoney;
	private final int maxParty = 4;
	
	public void guildTitle() {
		System.out.printf("========[%s]========\n",this.gulidName);
	}
	
	public void printGuildMoney() {
		System.out.printf("길드 보유금액 : %dg\n",this.guildMoney);
	}
	
//	길드관리
//	ㄴ 길드목록, 길드원추가, 길드원삭제, 파티원교체, 정렬
	public void guildMenu() {
		while(true) {
			System.out.println("1.길드원 목록\n2.길드원 영입\n3.길드원 해고\n4.정렬\n5.뒤로가기");
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
				else if(num==4) {//정렬
					guildLineup();
				}
				else if(num==5) {//뒤로가기
					
				}
				
			} catch (Exception e) {
			}
			
		}
	}
	
	
	public void guildSet(){ // 길드 아이템 리스트
		this.gulidName = "그린컴퓨터";
		this.guildMoney = 100000;
	}
	
	public void itemList(){ // 길드 아이템 리스트
		
	}
	  
	public void playerItem(){
		
	}
	
	
	
	public void guildList() {//길드원 목록
		
	}
	
	public void guildAdd() {//길드원 영입
		
	}
	
	public void guildRemove() {//길드원 해고
		
	}
	
	public void party() {//자동파티
		//4명설정
	}
	
	public void guildLineup() {//정렬
		
	}
}
