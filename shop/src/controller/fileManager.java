package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import models.shop;

public class fileManager {
	private String userName = "users.txt"; // 유저-이름/
	private File userFile = new File(userName);
	
	private String cartName = "cart.txt"; // 장바구니
	private File cartFile = new File(cartName);
	
	private String shopName = "shop.txt"; // 메장-매출,카테고리,상품
	private File shopFile = new File(shopName);
	
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
	public static fileManager instance = new fileManager();
	private userManager um = userManager.instance;
	private itemManager im = itemManager.instance;
	private shopManager sm = shopManager.instance;
	
	private String userDataSet() { // 유저코드/유저아이디/유저비밀번호
		String data = "";
		data += um.users.size()+"\n";
		for(int i=0; i<um.users.size(); i++) {
			data += um.users.get(i).getUserCode()+"/";
			data += um.users.get(i).getId()+"/";
			data += um.users.get(i).getPw()+"\n";
		}
		data.substring(0, data.length()-1);
		return data;
	}
	
	private String cartDataSet() { // 카테고리코드/아이템코드/아이템명/아이템수량/총가격
		String data = "";
		data += um.cart.size()+"\n";
		for(int i=0; i<um.cart.size(); i++) {
			data += um.cart.get(i).getCategoryCode()+"/";
			data += um.cart.get(i).getItemCode()+"/";
			data += um.cart.get(i).getItems()+"/";
			data += um.cart.get(i).getItemNum()+"/";
			data += um.cart.get(i).getTotalPrice()+"\n";
		}
		data.substring(0, data.length()-1);
		return data;
	}
	
	private String shopDataSet() {
		String data = "";
		data += shop.totalSales+"\n";
		data += im.items.size()+"\n";
		for(int i=0; i<im.items.size(); i++) { // 카테고리코드/카테고리명/아이템수
			data += im.items.get(i).getCategoryCode()+"/";
			data += im.items.get(i).getCategory()+"/";
			data += im.items.get(i).getListSize()+"\n";
			if(im.items.get(i).getListSize()!=0) {
				for(int j=0; j<im.items.get(i).getListSize(); j++) { // 아이템코드/아이템명/아이템수량/아이템가격
					data += im.items.get(i).getItemCode(j)+"/";
					data += im.items.get(i).getItems(j)+"/";
					data += im.items.get(i).getCnt(j)+"/";
					data += im.items.get(i).getPrice(j)+"\n";
				}
			}
		}
		data.substring(0, data.length()-1);
		return data;
	}
	
	//저장
	public void save() {
		String data = userDataSet();
		
		try { // 유저 정보
			fw = new FileWriter(userFile);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}
		
		data = cartDataSet();
		
		try { // 장바구니 정보
			fw = new FileWriter(cartFile);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}
		
		data = shopDataSet();
		
		try { // 상점,카테고리,아이템 정보
			fw = new FileWriter(shopFile);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}
	}
	
	//로드
}
