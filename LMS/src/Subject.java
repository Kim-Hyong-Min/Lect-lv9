

abstract class Hakgua {
	private String HakguaName;
	private int HakguaNum;
	private int hakbun;
	private String pro_Name;
	private String subPro_Name;
	
	Hakgua(){}
	
	public Hakgua(String HakguaName, int HakguaNum, String pro_Name, String subPro_Name){
		this.HakguaName = HakguaName;
		this.HakguaNum = HakguaNum;
		this.pro_Name = pro_Name;
		this.subPro_Name = subPro_Name;
	}
	
}


public class Subject extends Hakgua {
	// 수업명, 교수명, 과목번호, 정원, 현재인원
	private String title;
	private String pro_Name;
	private int sub_Num;
	private int total_Student;
	private int now_Student;
}
