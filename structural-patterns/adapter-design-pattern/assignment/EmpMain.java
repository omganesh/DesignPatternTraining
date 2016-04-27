/**
 Class example containing Abstract factory with a single ton instance.
**/

import java.util.*;

public class EmpMain{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int ch1=0, ch2=0;

		ArrayList<Emp> emp = new ArrayList<Emp>();

		do {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("--------------");
			System.out.println("1. Create");
			System.out.println("2.	Display");
			System.out.println("3. Raise Salary");
			System.out.println("4.	Exit ");
			System.out.println("--------------");
			System.out.print("Enter choice:-");
			ch1=sc1.nextInt();

			if(ch1==1){
				do{
					Scanner sc2= new Scanner(System.in);
					System.out.println("*************");
					System.out.println("1. Clerk");
					System.out.println("2. Programmer");
					System.out.println("3. Manager");
					System.out.println("5. CEO");
					System.out.println("4. Exit ");
					System.out.println("*************");
					System.out.print("Enter choice:-");
					ch2=sc2.nextInt();
					switch(ch2){
						case 1: emp.add(Emp.createEmployee("Clerk"));
						break;
						case 2: emp.add(Emp.createEmployee("Programmer"));
						break;
						case 3: emp.add(Emp.createEmployee("Manager"));
						break;
						case 5: Emp ceo = Emp.createEmployee("CEO");
								if (!emp.contains(ceo)){
									emp.add(ceo);
								}else{
									System.out.println(" CEO is already present ");
								}
						break;
					}
				}while(ch2!=4);
			}

			if(ch1==2){
				Iterator<Emp> i1= emp.iterator();
				while(i1.hasNext()){
					i1.next().display();
				}

			}

			if(ch1==3){
				Iterator<Emp> i1= emp.iterator();
				while(i1.hasNext()){
					i1.next().raiseSalary();
				}

			}

		}while(ch1!=4);

	}
}