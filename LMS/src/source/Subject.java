package source;

public class Subject extends Hakgua {
	// 수업명, 교수명, 학과 번호, 과목번호, 정원, 현재인원
	private String title;
	private String pro_Name;
	private int HakguaNum;
	private int sub_Num;
	private int total_Student;
	private int now_Student;
	
	public Subject(String title, String pro_Name, int HakguaNum, int sub_Num, int total_Student){
		this.title = title;
		this.pro_Name = pro_Name;
		this.HakguaNum = HakguaNum;
		this.sub_Num = sub_Num;
		this.total_Student = total_Student;
	}
	
	@Override
	public void checkHakgua() {
		
	}
	
	
}
