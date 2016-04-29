/**
Memento pattern example 

  - Stores the state of the inputs and retrives the states 

**/

import java.util.*;

class Memento {
	public String name;
	public Memento(String str){
		name = str;
	}
	public String getName(){
		return name;
	}
}


class Originator {
	private String name;

	public void setName(String str){
		name = str;
	}

	public String getName(){
		return name;
	}

	public Memento saveStateToMemento(){
		return new Memento(name);
	}

	public void getStateFromMemento(Memento memento){
		name = memento.getName();
	}
}

class CareTaker {
	private List<Memento> mementoList= new ArrayList<Memento>();

	public void add(Memento m){
		mementoList.add(m);
	}

	public Memento  get(int index){
		return mementoList.get(index);
	}
}

public class MementoDemo {
	public static void main(String args[]){

		CareTaker ct = new CareTaker();

		Originator originator = new Originator();

		originator.setName("Prakash");
		originator.setName("Satish");
		originator.setName("Joginder");

		ct.add(originator.saveStateToMemento());

		originator.setName("Sunil");
		originator.setName("Suman");

		ct.add(originator.saveStateToMemento());

		originator.setName("Akash");
		originator.setName("Kishore");
		System.out.println(originator.getName());

		System.out.println(" --------- ");

		originator.getStateFromMemento(ct.get(1));
		System.out.println(originator.getName());

		System.out.println(" --------- ");
		originator.getStateFromMemento(ct.get(0));
		System.out.println(originator.getName());
		System.out.println(" --------- ");

		originator.getStateFromMemento(ct.get(1));
		System.out.println(originator.getName());
		System.out.println(" --------- ");
		

	}
}