package game;

public class Inventory {
	private String name;
	private int atk;
	private int def;
	private int itemCode;
	private int itemCnt;
  
  Inventory(){
  }
  
  public Inventory(String name, int atk, int def, int itemCode, int itemCnt) {//Ã¹±¸¸Å
	  this.name = name;
	  this.atk =atk;
	  this.def= def;
	  this.itemCode = itemCode;
	  this.itemCnt = itemCnt;
  }
  
  public String getItemName() {
	  return this.name;
  }
  
  public int getAtk() {
	  return this.atk;
  }
  public int getDef() {
	  return this.def;
  }
  
  public int getItemCode() {
	  return this.itemCode;
  }
  
  public int getItemCnt() {
	  return this.itemCnt;
  }
  
  public int getItemType() {
	  return this.itemCode/1000;
  }
  
  public void setItemCnt(int num) {
	  this.itemCnt += num;
  }
    
}