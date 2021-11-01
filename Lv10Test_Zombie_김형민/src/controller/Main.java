package controller;

import models.GameManager;

// 시작 18:10
// 종료 22:11
// 소요 03:21 - 쉬는시간 40분 가량 제외
public class Main {
	public static void main(String[] args) {
		GameManager gm = GameManager.getInstance();
		gm.run();
	}
}
