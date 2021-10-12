package models;

import java.util.Random;
import java.util.Scanner;

public class shop {
	public static Scanner sc = new Scanner(System.in);
	public static Random rn = new Random();
	private static String shopName = "¿Ã∏∂∆Æ";
	private int totalSales;
	public static int log = -1;
	
	private shop() {
	}
	
	public static String getName() {
		return shop.shopName;
	}
	
	public int getTotalSales() {
		return this.totalSales;
	}
	
	
}
