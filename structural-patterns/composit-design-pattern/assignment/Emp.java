import java.util.*;

abstract class Emp
{
 	String name;
 	int age;
 	int salary;
 	String desig;

 	List<Employee> subbordinates = new ArrayList<Employee>();

 	public Emp()
 	{
 		Scanner sc = new Scanner(System.in);
 		System.out.print(" Enter name : ");
 		name= sc.next();

 		System.out.print("Enter age: ");
 		age=sc.nextInt();
 	}

 	public void display(){

 		System.out.println("Name : "+name);
 		System.out.println("Age :"+age);
 		System.out.println("Salary: "+salary);
 		System.out.println("Designation : "+ desig);
 		System.out.println();
 	}

 	public abstract void raiseSalary();

 	public static Emp createEmployee(String employee){

 		if("Clerk".equals(employee)){
 			return new Clerk();	
 		}

 		if("Programmer".equals(employee)){
 			return new Programmer();	
 		}

 		if("Manager".equals(employee)){
 			return new Manager();	
 		}

 		if("CEO".equals(employee)){
 			return CEO.getInstance();
 		}
 		return null;
 	}


 	public void addSubbordinates(Emp employee){
 		subbordinates.addSubbordinates(employee);
 	} 	
}

class Programmer extends Emp{
	public Programmer(){
		salary=25000;
		desig="Programmer";
	}

	public void raiseSalary(){
		salary+=5000;
	}
}


class Manager extends Emp{
	public Manager(){
		salary=70000;
		desig="Manager";
	}

	public void raiseSalary(){
		salary+=10000;
	}
}

class Clerk extends Emp{
	public Clerk(){
		salary=8000;
		desig="Clerk";
	}

	public void raiseSalary(){
		salary+=2000;
	}

class CEO extends Emp {
	private static int count=0;
	private static CEO ceo =null;
	private CEO() {
		salary=15000;
		desig="CEO";
		count++;

	}

	public void raiseSalary(){
		salary+=20000;
	} 

 	public static CEO getInstance(){
 		if(count==0){
 			ceo= new CEO();
 		}
 		return ceo;

 	}
}


class pManager extends Manager {
	private subbordinateProgrammers ;

}

class cManager extends Manager{
	
}
