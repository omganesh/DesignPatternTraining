
/**
Assignment for Bridge pattern 
  where class Company & Account classes are included within the 
display method.

**/
import java.util.*;

abstract class Emp
{
 	String name;
 	int age;
 	int salary;
 	String desig;
 	companyAccountBridge compDetails = new companyAccountBridge();


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
 		compDetails.display(salary);

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
}


class Company {
	String companyName;
	String companyAddress;

	public Company(String name){
		this.companyName=name;
	}

	public displayCompanyName() {
		System.out.println(" Company Name: "+this.companyName);
	}
}

class Account {

	private final double ta_perc=0.1;
	private final double da_perc=0.2;
	private final double hra_perc=0.3;

	public int getDa(int sal){
		return (sal * da_perc);
	}

	public int getTa(int sal){
		return (sal * ta_perc);
	}

	public int getHra(int sal){
		return (sal * hra_perc);
	}

	public void display(int sal){
		Sysetem.out.println("The salary break-up   \nHRA "+getTa(sal)+"\n DA ::"+getDa(sal)+"\n Ta ::"+getTa(sal));
	}
}


class companyAccountBridge {
	Company company;
	Account account;

	public void display(int sal){
		company.display();
		salary.display(sal);
	}
}
