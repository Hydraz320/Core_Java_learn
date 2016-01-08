package chapter5;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private double salary;
	private Date hireDay;
	//������
	public Employee(String name,double salary,int year,int month,int day)
	{
		this.name=name;
		this.salary=salary;
		GregorianCalendar d=new GregorianCalendar(year,month-1,day);
		hireDay=d.getTime();
	}
	//������
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}
	//��н����
	public void raiseSalary(double byPercent)
	{
		salary+=byPercent*salary/100;
	}
}
