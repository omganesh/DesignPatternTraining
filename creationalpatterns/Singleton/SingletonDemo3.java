class Abc{

	private static int count=0;
	private static final Abc a1;

	//private static final Abc a1 = new Abc();

	private Abc(){
		count ++;

	}

	public static Abc getObject() {

		if( count==0)
			return new Abc();
		else{
			System.out.println("Sorry Object already exists");
			return null;
		}
	}
}


public class SingletonDemo3 {

public static void main(String args[]){
	Abc a1=  Abc.getObject();
	Abc a2=  Abc.getObject();
	Abc a3=  Abc.getObject();

	System.out.println(a1.hashCode());
	System.out.println(a2.hashCode());
	System.out.println(a3.hashCode());
}
}