package chapter6;

public class CloneTest {
	public static void main(String[] args)
	{
		try {
			Employee original=new Employee("pig", 1000);
			original.setHireDay(1993, 3, 20);
			Employee copy=original.clone();
			copy.raiseSalary(50);
			copy.setHireDay(2002, 10, 30);
			System.out.println("original="+original);
			System.out.println("copy="+copy);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
