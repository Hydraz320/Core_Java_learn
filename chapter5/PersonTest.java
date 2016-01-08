package chapter5;
/**
 * 测试抽象基类
 * @author Geec
 * @version 1.0
 */
public class PersonTest {

	public static void main(String[] args) {
		Person[] people=new Person[2];
		people[0]=new Employee("Geec",10000,1993,3,20);
		people[1]=new Student("dog","CS");
		
		for(Person p:people)
			System.out.println(p.getName()+", "+p.getDiscription());
	}

}
