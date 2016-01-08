package chapter5;

import java.util.Objects;

public class Manager extends Employee {
	private double bonus;
	
	public Manager(String name,double salary,int year,int month,int day)
	{
		super(name,salary,year,month,day);
		bonus=0;
	}
	//访问器
	public double getSalary()
	{
		double baseSalary=super.getSalary();
		return baseSalary+bonus;
	}
	//修改器
	public void setBonus(double bonus)
	{
		this.bonus=bonus;
	}
	@Override
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject))return false;
		Manager other=(Manager)otherObject;
		return bonus==other.bonus;
	}
	@Override
	public int hashCode() {
		return super.hashCode()+17*Objects.hash(bonus);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"[bonus="+bonus+"]";
	}
	
}
