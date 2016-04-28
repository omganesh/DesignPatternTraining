import java.util.*;
class Person {
	private String name;

	static ArrayList<Person> arrayList = new ArrayList<Person>();

	private Person(String n){
		name = n;
	}

	public String toString(){
		System.out.println(" Person name : "+name);
		return null;
	}

	public String getName(){
		return name;
	}

	public static Person getPerson(String name){

		for(Person p : arrayList){
			if(name.equals(p.getName())){
				return p;
			}
		}
		Person temp = new Person(name);
		arrayList.add(temp);
		return temp;
	}
}


public class FlyWeightDemo{

	public static void main(String args[]){
		Person p1 = Person.getPerson("Mahesh");
		Person p2 = Person.getPerson("Mahesh1");
		Person p3 = Person.getPerson("Mahesh2");


		System.out.println(p1+" "+p1.hashCode());
		System.out.println(p2+" "+p2.hashCode());
		System.out.println(p3+" "+p3.hashCode());

	}
}