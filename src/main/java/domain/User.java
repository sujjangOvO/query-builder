package domain;

public class User implements Entity {
	int no;
	String name;
	int age;

	public User(int no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
			"no=" + no +
			", name='" + name + '\'' +
			", age=" + age +
			'}';
	}
}
