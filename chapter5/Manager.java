package chapter5;

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
}
