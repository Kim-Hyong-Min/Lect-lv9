
public class Inventory {
	private int itemCode;
	private int itemCnt;
	private int playerCode;
  
  Inventory(){
  }
  
  public Inventory(int itemCode, int itemCnt) {//ù����
	  this.itemCode = itemCode;
	  this.itemCnt = itemCnt;
  }
  
  public int getItemCode() {
	  return this.itemCode;
  }
  
  public int getItemCnt() {
	  return this.itemCnt;
  }
  
  public void setItemCnt(int num) {
	  this.itemCnt += num;
  }
  

    
}