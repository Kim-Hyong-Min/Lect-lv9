package basic;

// Thread

class playGame extends Thread{ // Thread : �Ϲ� ���
	
	public boolean play;
	
	public playGame() {
		
	}
	
	@Override
	public void run() {
		play = true;
		
		while(play) {
			System.out.println("�ų��� ������ �ϴ� �� >>");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
	
}

class PlayMusic implements Runnable{ // Runnable : �������̽� ���(�ٿ뼺)
	
	boolean play;
	
	public PlayMusic() {
	}
	
	@Override
	public void run() {
		play = true;
		while(play) {
			System.out.println("������ �帣��...");
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
//		play.start(); // stop �ϱ� ������ ��� ���ư�
//		
//		for(int n=0; n<10; n++) {
//			System.out.println("n : "+n);
//			if(n==8) {
//				System.out.println("��, ������ �����ߴ�!!!");
////				play.stop(); <= ���򿡴� ��� ����.
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
					System.out.println("������ ����!!!");
					// ? stop() ���� �ʰ� -> ������ ����
					
					// music �� PlayMusic���� ����ȯ�� �����ϸ� true
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
