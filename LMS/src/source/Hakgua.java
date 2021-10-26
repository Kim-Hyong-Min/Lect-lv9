package source;

public abstract class Hakgua {
	private String HakguaName;
	private int HakguaNum;
	private int hakbun[];
	private String pro_Name;
	private String subPro_Name;
	
	Hakgua(){}
	
	public Hakgua(String HakguaName, int HakguaNum, String pro_Name, String subPro_Name){
		this.HakguaName = HakguaName;
		this.HakguaNum = HakguaNum;
		this.pro_Name = pro_Name;
		this.subPro_Name = subPro_Name;
	}
	
	
	
	public abstract void checkHakgua();
	
}
