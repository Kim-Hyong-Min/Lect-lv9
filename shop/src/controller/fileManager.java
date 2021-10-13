package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import models.shop;

public class fileManager {
	private String userName = "users.txt"; // ����-�̸�/
	private File userFile = new File(userName);
	
	private String cartName = "cart.txt"; // ��ٱ���
	private File cartFile = new File(cartName);
	
	private String shopName = "shop.txt"; // ����-����,ī�װ�,��ǰ
	private File shopFile = new File(shopName);
	
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
	public static fileManager instance = new fileManager();
	private userManager um = userManager.instance;
	private itemManager im = itemManager.instance;
	private shopManager sm = shopManager.instance;
	
	private String userDataSet() { // �����ڵ�/�������̵�/������й�ȣ
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
	
	private String cartDataSet() { // ī�װ��ڵ�/�������ڵ�/�����۸�/�����ۼ���/�Ѱ���
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
		for(int i=0; i<im.items.size(); i++) { // ī�װ��ڵ�/ī�װ���/�����ۼ�
			data += im.items.get(i).getCategoryCode()+"/";
			data += im.items.get(i).getCategory()+"/";
			data += im.items.get(i).getListSize()+"\n";
			if(im.items.get(i).getListSize()!=0) {
				for(int j=0; j<im.items.get(i).getListSize(); j++) { // �������ڵ�/�����۸�/�����ۼ���/�����۰���
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
	
	//����
	public void save() {
		String data = userDataSet();
		
		try { // ���� ����
			fw = new FileWriter(userFile);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}
		
		data = cartDataSet();
		
		try { // ��ٱ��� ����
			fw = new FileWriter(cartFile);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}
		
		data = shopDataSet();
		
		try { // ����,ī�װ�,������ ����
			fw = new FileWriter(shopFile);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}
	}
	
	//�ε�
}
