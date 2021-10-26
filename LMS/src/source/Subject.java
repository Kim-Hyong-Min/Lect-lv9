package source;

public class Subject extends Hakgua {
	// 수업명, 교수명, 학과 번호, 과목번호, 정원, 현재인원
	private String title;
	private String pro_Name;
	private int HakguaNum;
	private int sub_Num;
	private int total_Student;
	private int now_Student;
	private int score;
	
	public Subject(String title, String pro_Name, int HakguaNum, int sub_Num, int total_Student){
		this.title = title;
		this.pro_Name = pro_Name;
		this.HakguaNum = HakguaNum;
		this.sub_Num = sub_Num;
		this.total_Student = total_Student;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public boolean totalNumCheck() {
		if(this.total_Student>this.now_Student) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void StudentAdd() {
		this.now_Student++;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void printSubject(int num) {
		System.out.printf("[%d] 수업명 : %s /담당교수 : %s / 정원(%d/%d)\n",num+1 , this.title, this.pro_Name, this.now_Student, this.total_Student);
	}
	
	@Override
	public void checkHakgua() {
		
	}
	
	
}
