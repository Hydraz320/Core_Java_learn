package chapter6;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>, Cloneable {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String name,double salary)
	{
		this.name=name;
		this.salary=salary;
	}
	public String getName()
	{
		return name;
	}
	public double getSalary()
	{
		return salary;
	}
	public void raiseSalary(double byPercent)
	{
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	@Override
	public int compareTo(Employee o) 
	{
		//Employee other=(Employee)o;
		return Double.compare(this.salary, o.salary);
	}
	@Override
	public Employee clone() throws CloneNotSupportedException {
		//就是该类相比较超类新增的域用clone()重新赋值
		//而超类里已有的域由超类自己的clone()负责赋值
		Employee cloned=(Employee)super.clone();
		cloned.hireDay=(Date)hireDay.clone();
		return cloned;
	}
	
	public void setHireDay(int year,int month,int day)
	{
		hireDay=new GregorianCalendar(year,month-1,day).getTime();
	}
	
	public String toString()
	{
		return getClass().getName()+"[name="+this.getName()+",salary="+this.getSalary()+
				",hireDay="+hireDay+"]";
	}
}
