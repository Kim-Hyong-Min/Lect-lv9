package controller;

import models.GameManager;

// ���� 18:10
// ���� 22:11
// �ҿ� 03:21 - ���½ð� 40�� ���� ����
public class Main {
	public static void main(String[] args) {
		GameManager gm = GameManager.getInstance();
		gm.run();
	}
}
