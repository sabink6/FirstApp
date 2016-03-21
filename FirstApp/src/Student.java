
public class Student {
	
	private String name;
	private String address;
	private int age;
	private String subject;
	
	public Student() {
		super();
	}
	
	public Student(String name, String address, int age, String subject) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", age=" + age + ", subject=" + subject + "]";
	}

	

}
