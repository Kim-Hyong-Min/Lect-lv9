import Manager.StudentManager;

interface Manager{
	public static final String id = "qwer";
	public static final String pw = "1111";
}

public class Student extends Hakgua implements Manager {
	private static Student instance = new Student();
	public static Student getInstance() {return instance;};
	// �̸�, �й�, ����, ���̵�, ��й�ȣ, ��û����(�迭)
	private String name;
	private int hakbun;
	private int age;
	private String id;
	private String pw;
	
	Student() {}
	
	public Student(String name, int hakbun, int age, String id, String pw){
		this.name = name;
		this.hakbun = hakbun;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}
}
