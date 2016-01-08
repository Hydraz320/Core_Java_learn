package chapter5;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

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

	@Override
	public boolean equals(Object otherObject) {
		if(this==otherObject)return true;
		if(otherObject==null)return false;
		if(getClass()!=otherObject.getClass())
			return false;
		Employee other=(Employee)otherObject;
		return Objects.equals(this.getName(), other.getName())
				&&salary==other.salary
				&&Objects.equals(hireDay, other.hireDay);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getName(),salary,hireDay);
	}

	@Override
	public String toString() {
		return getClass().getName()+"[name="+this.getName()+
				",salary="+salary+",hireDay="+hireDay+"]";
	}
	
	
}
