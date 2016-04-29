import java.util.*;

/**
	Strategy pattern  
		Collection related strategy demo

	TreeSet is a sorted set which will not be having the 

**/


class Person {
	public String name ;
	public Integer age;
	public Person(String n, int a){
		name = n;
		age= new Integer(a);
	}

	public String toString(){
		System.out.println("Name : "+name);
		System.out.println("Age :"+age);
		return "";
	}
}

public class StrategyDemo {
	public static void main(String args[]){

		TreeSet<Person> ts = new TreeSet<Person>(new NameSorter());
		//List<Person> ts = new ArrayList<Person>();

		ts.add(new Person("Raj", 25));
		ts.add(new Person("Baljeet", 29));
		ts.add(new Person("Amar", 35));
		ts.add(new Person("Dinesh", 24));
		ts.add(new Person("Sridhar", 26));


		
		for(Person p: ts){
			System.out.println(p);
		}

		/*ts.add(new Person("Raj", 25));
		ts.add(new Person("Raj", 25));
		*/

	}
}