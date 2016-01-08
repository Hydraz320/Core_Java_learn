package chapter5;

public class Student extends Person {
	private String major;
	public Student(String name,String major) {
		super(name);
		this.major=major;
	}
	@Override
	public String getDiscription() {
		return "a student majoring in "+major;
	}
}
