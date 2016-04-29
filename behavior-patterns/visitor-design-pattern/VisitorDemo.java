
abstract class ComputerPart {
	int price;
	public abstract void accept(ComputerPartVisitor cpv);
}

class KeyBoard extends ComputerPart {
	KeyBoard(int price){
		this.price=price;
	}
	public void accept(ComputerPartVisitor cpv){
		cpv.visit(this);
	}
}

class Mouse extends ComputerPart {
	Mouse(int price){
		this.price=price;
	}
	public void accept(ComputerPartVisitor cpv){
		cpv.visit(this);
	}
}

class MotherBoard extends ComputerPart {
	MotherBoard(int price){
		this.price=price;
	}
	public void accept(ComputerPartVisitor cpv){
		cpv.visit(this);
	}
}

class Monitor extends ComputerPart {
	Monitor(int price){
		this.price=price;
	}

	public void accept(ComputerPartVisitor cpv){
		cpv.visit(this);
	}
}

class Computer extends ComputerPart {
	ComputerPart parts[];

	public Computer(){
		parts = new ComputerPart[] {new Mouse(3000), new KeyBoard(4000), new MotherBoard(50000), new Monitor(30000)};
		for(int i = 0;i<parts.length;i++){
			price+= parts[i].price;
		}
	}

	public void accept(ComputerPartVisitor cpv){
		for(int i=0;i<parts.length;i++){
			parts[i].accept(cpv);
		}
		cpv.visit(this);
	}
}

interface ComputerPartVisitor{
	public void visit(Mouse m);
	public void visit(KeyBoard m);
	public void visit(MotherBoard m);
	public void visit(Monitor m);
	public void visit(Computer m);
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor{
	public void visit(Mouse m){
		System.out.println(" Mouse available"+" Price: "+m.price);
	}
	public void visit(KeyBoard m){
		System.out.println(" KeyBoard available"+" Price: "+m.price);
	}
	public void visit(Monitor m){
		System.out.println(" Monitor available"+" Price: "+m.price);
	}
	public void visit(MotherBoard m){
		System.out.println(" MotherBoard available"+" Price: "+m.price);
	}
	public void visit(Computer m){	
		System.out.println(" Computer Accessories......"+" Price: "+m.price);
	}
}


class ComputerPriceDisplayVisitor implements ComputerPartVisitor{
	static int total=0;
	public void visit(Mouse m){
		System.out.println(" Mouse available");

		total+=m.price;
	}
	public void visit(KeyBoard m){
		System.out.println(" KeyBoard available");
		total+=m.price;
	}
	public void visit(Monitor m){
		System.out.println(" Monitor available");
		total+=m.price;
	}
	public void visit(MotherBoard m){
		System.out.println(" MotherBoard available");
		total+=m.price;
	}
	public void visit(Computer m){	
		System.out.println(" Computer Accessories......");
		total+=m.price;
	}
}


public class VisitorDemo {
	public static void main(String args[]){

		Computer computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());


		computer.accept(new ComputerPriceDisplayVisitor());

	}
}