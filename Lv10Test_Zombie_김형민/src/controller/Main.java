package controller;

import models.GameManager;

// 시작 18:10
// 종료 00:00
// 소요 00:00
public class Main {
	public static void main(String[] args) {
		GameManager gm = GameManager.getInstance();
		gm.run();
	}
}
