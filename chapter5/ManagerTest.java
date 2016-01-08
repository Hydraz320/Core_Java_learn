package chapter5;

public class ManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager boss=new Manager("Geec",100000,1993,3,20);
		boss.setBonus(5000);
		
		Employee[] staff=new Employee[3];
		
		staff[0]=boss;
		staff[1]=new Employee("pig", 10, 2015, 1, 5);
		staff[2]=new Employee("duck",20,2015,1,7);
		
		for(Employee e:staff)
			System.out.println("name="+e.getName()+",salary="+e.getSalary());
	}

}
