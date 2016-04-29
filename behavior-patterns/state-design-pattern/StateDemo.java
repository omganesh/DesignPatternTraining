/**

State pattern example 

**/


abstract class Greeting {
	protected int t;

	public abstract void greet();

	public void setTime(int t){
		this.t = t;
	}

	public static Greeting getObject(){
		return new GreetingImpl();
	}
}

class GreetingImpl extends Greeting {
	public void greet(){

		Greeting greet = new Morning();

		if (t>5 && t <12){
			greet = new Morning();
		}
		if (t>=12 && t <16){
			greet = new Afternoon();
		}
		if (t>=16 && t <19){
			greet = new Evening();
		}
		if (t>=19 && t <24){
			greet = new Night();
		}
		greet.greet();	
	}
}

class Morning extends Greeting {
	public void greet(){
		System.out.println("Good Morning .... ");
	}
}

class Afternoon extends Greeting {
	public void greet(){
		System.out.println("Good Afternoon .... ");
	}
}

class Evening extends Greeting {
	public void greet(){
		System.out.println("Good Evening .... ");
	}
}

class Night extends Greeting {
	public void greet(){
		System.out.println("Good night .... ");
	}
}

public class StateDemo {
	public static void main(String args[]){

		Greeting g1 = Greeting.getObject();
		g1.setTime(6);
		g1.greet();

		g1.setTime(14);
		g1.greet();

		g1.setTime(18);
		g1.greet();

		g1.setTime(19);
		g1.greet();

		g1.setTime(22);
		g1.greet();

	}
}