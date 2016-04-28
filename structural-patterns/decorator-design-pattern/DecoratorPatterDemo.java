import java.util.*;


interface Car {
	
	public void assemble();
}

class BasicCar implements Car{

	public void assemble(){
		System.out.println("This is basic car");
	}
}

class CarDecorator extends BasicCar {
	Car car;
	public CarDecorator(Car c){
		car = c;
	}
	public void assemble(){
		car.assemble();
	}
}

class Luxurycar extends CarDecorator{
	public Luxurycar(Car c){
		super(c);
	}

	public void assemble(){
		car.assemble();
		System.out.println("Adding Luxury car functionality");
	}
}

class SportsCar extends CarDecorator{
	public SportsCar(Car car){
		super(car);
	}
	public void assemble(){
		car.assemble();
		System.out.println("Adding Sports Car functionality");
	}
}

public class DecoratorPatterDemo {

	public static void main(String args[]){

		//Car mycar = new Luxurycar(new BasicCar());

		Car mycar = new SportsCar(new BasicCar());
		mycar.assemble();
	}

}