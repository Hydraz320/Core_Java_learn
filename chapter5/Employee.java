package chapter5;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {
	private double salary;
	private Date hireDay;
	//构造器
	public Employee(String name,double salary,int year,int month,int day)
	{
		super(name);
		this.salary=salary;
		GregorianCalendar d=new GregorianCalendar(year,month-1,day);
		hireDay=d.getTime();
	}
	//访问器

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}
	//提薪
	public void raiseSalary(double byPercent)
	{
		salary+=byPercent*salary/100;
	}
	@Override
	public String getDiscription() {
		return String.format("an employee with a salary of %.2f", salary);
	}
}
