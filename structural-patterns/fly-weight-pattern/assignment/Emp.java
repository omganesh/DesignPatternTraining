import java.util.*;

abstract class Emp
{
 	String name;
 	int age;
 	int salary;
 	String desig;
 	String id;
 	String type;

 	private static ArrayList<Emp> list = new ArrayList<Emp>();

 	private Emp()
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

 	private static Emp createEmployee(String employee,String id){

 		if("Clerk".equals(employee)){
 			return getInstance(Clerk,id);	
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

 	private static Emp getInstance(Class classType, String id){
 		for(Emp tempEmp: list){
 			if(id.equals(tempEmp.id)){
 				return tempEmp;
 			}

 			Emp tempEmp = classType.newInstance();
 			tempEmp.id=id;
 			list.add(tempEmp);
 			return tempEmp;
 		}
 	}
}

class Programmer extends Emp{
	private Programmer(){
		salary=25000;
		desig="Programmer";

	}

	public void raiseSalary(){
		salary+=5000;
	}
}


class Manager extends Emp{
	private Manager(){
		salary=70000;
		desig="Manager";
	}

	public void raiseSalary(){
		salary+=10000;
	}
}

class Clerk extends Emp{
	private Clerk(){
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
}
