package chapter5;

public class Manager extends Employee {
	private double bonus;
	
	public Manager(String name,double salary,int year,int month,int day)
	{
		super(name,salary,year,month,day);
		bonus=0;
	}
	//¸´Ð´
	public double getSalary()
	{
		double baseSalary=super.getSalary();
		return baseSalary+bonus;
	}
	//ÐÞ¸ÄÆ÷
	public void setBonus(double bonus)
	{
		this.bonus=bonus;
	}
}
