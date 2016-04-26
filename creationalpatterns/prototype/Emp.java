/**
Example for working of a prototype Design pattern
**/

import java.util.*;

abstract class Emp implements Cloneable
{
 	String name;
 	int age;
 	int salary;
 	String desig;

 	static Emp clerk=null;
	static Emp programmer=null;
	static Emp manager=null;

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
 			clerk=(clerk==null)?(clerk=new Clerk()): clerk.getDuplicate();
 			return clerk;
 		}

 		if("Programmer".equals(employee)){
 			programmer=(programmer==null)?(programmer=new Programmer()):programmer.getDuplicate();	
 			return programmer; 
 			
 		}

 		if("Manager".equals(employee)){
 			manager=(manager==null)?(manager=new Manager()):manager.getDuplicate();	 
 			return manager;	
 		}
 		return null;
 	}

 	/**
 	Prototype pattern working 
 	**/
 	public Emp getDuplicate(){

 		try{
 			Emp tempObject = (Emp)super.clone();
 			Scanner scD = new Scanner(System.in);
 			System.out.print(" Enter Name :");tempObject.name=scD.next();
 			System.out.print(" Enter age :");tempObject.age=scD.nextInt();
 	
 			return tempObject;
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		return null;

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
}
