package chapter5;
/**
 * 抽象基类
 * @author Geec
 * @version 1.0
 */
abstract public class Person {
	//抽象方法
	public abstract String getDiscription();
	
	private String name;

	public Person(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
}
