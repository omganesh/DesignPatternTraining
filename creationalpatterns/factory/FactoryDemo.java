abstract class Shape
{
/*	private Shape(){

	}
	*/
	// Factory method will create an object of a class
	public static Shape getShape(String str){
		if("Circle".equals(str)){
			return new Circle();
		}
		if("Square".equals(str)){
			return new Square();
		}
		if("Triangle".equals(str)){
			return new Triangle();
		}
		if("Rectangle".equals(str)){
			return new Rectangle();
		}
	//	return new Shape();
		return null;
	}


	public static Shape getShape(int... params){
		/*
		 Complete the var args
		*/
		 if(params.length ==1){
		 	return new Circle();
		 }
		 if(params.length ==2){
		 	 int length =params[0];
		 	 int width =params[1];
		 	 if(length==width){
		 	 	return new Square();
		 	 }else{
		 	 	return new Rectangle();
		 	 }
		 }
		 if(params.length==3){
		 	return new Triangle();

		 }
		 return null;
	}

	abstract public void area();
}

class Circle extends Shape{
		public void area(){
			System.out.println(" Area of a circle");
		}
}

class Square extends Shape{
		public void area(){
			System.out.println(" Area of a Square");
		}
}

class Triangle extends Shape{
		public void area(){
			System.out.println(" Area of a Triangle");
		}
}

class Rectangle extends Shape{
		public void area(){
			System.out.println(" Area of a Rectangle");
		}
}


public class FactoryDemo{
	public static void main(String[] args) {
		//Shape s1= Shape.getShape("Circle");

		
		Shape rect= Shape.getShape("Rectangle");
		rect.area();
		  Shape.getShape("Square");
		   Shape.getShape("Triangle");
		    Shape.getShape("Circle");
		    
		    Shape rectangle = Shape.getShape(10,20);
		    rectangle.area();
	}
}