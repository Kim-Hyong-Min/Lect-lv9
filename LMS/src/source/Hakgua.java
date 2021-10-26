package source;

public abstract class Hakgua {
	private String HakguaName;
	private int HakguaNum;
	private int hakbun[];
	private String pro_Name;
	private String subPro_Name;
	
	Hakgua(){};
	
	public Hakgua(String HakguaName, int HakguaNum, String pro_Name, String subPro_Name){
		this.HakguaName = HakguaName;
		this.HakguaNum = HakguaNum;
		this.pro_Name = pro_Name;
		this.subPro_Name = subPro_Name;
	}
	
	public String getHakguaName() {
		return this.HakguaName;
	}
	
	public String getPro_Name() {
		return this.pro_Name;
	}
	public String getSubPro_Name() {
		return this. subPro_Name;
	}
	
	public int getHakguaNum() {
		return this.HakguaNum;
	}
	
	public void checkHakgua() {
		
	}
	
}
