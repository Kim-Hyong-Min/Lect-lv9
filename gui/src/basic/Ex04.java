package basic;

// Thread

class playGame extends Thread{ // Thread : 일반 상속
	
	public boolean play;
	
	public playGame() {
		
	}
	
	@Override
	public void run() {
		play = true;
		
		while(play) {
			System.out.println("신나게 게임을 하는 중 >>");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
	
}

class PlayMusic implements Runnable{ // Runnable : 인터페이스 상속(다용성)
	
	boolean play;
	
	public PlayMusic() {
	}
	
	@Override
	public void run() {
		play = true;
		while(play) {
			System.out.println("음악이 흐르고...");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
		
	}
	
	
}

public class Ex04 {

	public static void main(String[] args) {
		playGame play = new playGame();
		
////		play.run();
//		play.start(); // stop 하기 전까지 계속 돌아감
//		
//		for(int n=0; n<10; n++) {
//			System.out.println("n : "+n);
//			if(n==8) {
//				System.out.println("앗, 엄마가 등장했다!!!");
////				play.stop(); <= 요즘에는 사용 안함.
//				play.play = false;
//			}
//			
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//			}
//		}
		
		
//		PlayMusic que = new PlayMusic();
//		que.run();
		
		Runnable music = new PlayMusic();
		Thread thread = new Thread(music);
		thread.start();
		while(true) {
			for(int n=0; n<10; n++) {
				System.out.println("n : "+n);
				
				if(n==7) {
					System.out.println("선생님 등장!!!");
					// ? stop() 쓰지 않고 -> 스레드 종료
					
					// music 이 PlayMusic으로 형변환이 가능하면 true
					if(music instanceof  PlayMusic) { 
						PlayMusic stop = (PlayMusic) music;
						stop.play = false;
					}
				}
				
				try {
					Thread.sleep(1000);
				}catch (Exception e) {
				}
			}
			if(music instanceof  PlayMusic) { 
				PlayMusic start = (PlayMusic) music;
				start.play = true;
			}
		}
		
	}

}
