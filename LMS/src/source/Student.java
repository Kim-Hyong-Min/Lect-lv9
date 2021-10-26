package source;
import Manager.StudentManager;

interface Manager{
	public static final String ManagerId = "qwer";
	public static final String ManagerIw = "1111";
	public boolean checkId(String inputId);
}

public class Student extends Hakgua implements Manager {
	private static Student instance = new Student();
	public static Student getInstance() {return instance;};
	// 이름, 학번, 나이, 아이디, 비밀번호, 신청과목(배열)
	private String name;
	private int hakbun;
	private int HakguaNum;
	private int age;
	private String id;
	private String pw;
	
	Student(){}
	
	public Student(String name, int hakbun, int age, String id, String pw){
		this.name = name;
		this.hakbun = hakbun;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}

	@Override
	public void checkHakgua() {
		
	}

	@Override
	public boolean checkId(String inputId) {
		if(ManagerId.equals(inputId)) {
			return false;
		}
		else {
			return true;
		}
	}

	
}
