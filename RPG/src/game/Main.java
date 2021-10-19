package game;
import java.util.Random;

public class Main {
	public static Random rn = new Random();
	private Shop sp = Shop.instance;
	private Guild gd = Guild.instance;
	private Unit ut = Unit.instance;
	private file fl = file.instance;
	private boolean isRun = true;
	
// 메인메뉴
// ㄴ 길드관리, 상점, 인벤토리, 저장, 로드
	public void run() {
		ut.playerSet();
		gd.guildSet();
		sp.weaponSet();
		sp.armorSet();
		sp.ringSet();
		while(isRun) {
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
				save();
				System.out.println("저장 완료!");
			}
			else if(num==5) {//로드
				load();
				System.out.println("불러오기 완료!");
			}
			else if(num==6) {//종료
				System.out.println("종료합니다");
				this.isRun = false;
			}
			
		} catch (Exception e) {
		}
		
	}
	
	
	public void save() {
		fl.guildSave();
		fl.playerSave();
		fl.itemSave();
		fl.inventorySave();
	}
	
	public void load() {
		fl.playerLoad();
		fl.itemLoad();
		fl.guildLoad();
		fl.inventoryLoad();
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
}