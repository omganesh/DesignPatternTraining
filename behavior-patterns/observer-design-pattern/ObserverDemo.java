import java.util.*;

/**
 Implementation of Observer pattern

**/

/**
Observerable 
**/
class Subject {
	private int state;
	private List<Observer> observers = new ArrayList<Observer>();

	public int getState(){
		return state;
	}

	public void setState(int state){
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer){
		observers.add(observer);
	}

	public void notifyAllObservers(){
		for(Observer observer : observers){
			observer.update();
		}
	}
}

abstract class Observer {

	protected Subject subject;
	public abstract void update();
}

/**
Observer
**/
class BinaryObserver extends Observer {
	public BinaryObserver(Subject sub){
		subject = sub;
	}	
	public void update(){
		System.out.println(" Value : "+subject.getState()+" Binary String : "+Integer.toBinaryString(subject.getState()));
	}
}

/**
Observer
**/
class HexadecimalObserver extends Observer {
	public HexadecimalObserver(Subject sub){
		subject = sub;
	}	
	public void update(){
		System.out.println(" Value : "+subject.getState()+" Hexadecimal String : "+Integer.toHexString(subject.getState()));
	}
}

/**
Observer
**/
class OctalObserver extends Observer {
	public OctalObserver(Subject sub){
		subject = sub;
	}	
	public void update(){
		System.out.println(" Value : "+subject.getState()+" Octal String : "+Integer.toOctalString(subject.getState()));
	}
}

public class ObserverDemo {
	public static void main(String args []){

		Subject s1 = new Subject();
		s1.setState(10);


		System.out.println("---------------");
		s1.attach(new BinaryObserver(s1));
		s1.setState(20);

		s1.attach(new HexadecimalObserver(s1));
		s1.attach(new OctalObserver(s1));

		s1.setState(1000);


	}
}