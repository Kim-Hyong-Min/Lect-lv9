package controller;

import models.GameManager;

// ���� 18:10
// ���� 00:00
// �ҿ� 00:00
public class Main {
	public static void main(String[] args) {
		GameManager gm = GameManager.getInstance();
		gm.run();
	}
}
