package chapter6;

import java.util.Arrays;

public class EmployeeSortTest {

	public static void main(String[] args) {
		Employee[] staff=new Employee[3];
		
		staff[0]=new Employee("pig", 11);
		staff[1]=new Employee("dog", 199);
		staff[2]=new Employee("duck", 22);
		
		Arrays.sort(staff);
		
		for(Employee e:staff)
			System.out.println("name="+e.getName()+",salary="+e.getSalary());
	}

}
