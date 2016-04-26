abstract class AbstractShapeFactory{
	public static AbstractShapeFactory getDimenison(int d, String shape){
		if(d==2)
			return Shape2D.get2DShapes(shape);
		if(d==3)
			return Shape3D.get3DShapes(shape);
		return null;
	}

	public abstract void area();
}

abstract class Shape2D extends AbstractShapeFactory  {

	public static Shape2D get2DShapes(String str){
		if("Circle".equals(str))
			return new Circle();	
		if(str.equals("Rectangle"))
			return new Rectangle();
		if("Triangle".equals(str))
			return new Triangle();

		return null;
	}
}

class Circle extends Shape2D {
	public void area(){
		System.out.println("Area of Circle");
	}
}


class Triangle extends Shape2D {
	public void area(){
		System.out.println("Area of Triangle");
	}
}

class Rectangle extends Shape2D {
	public void area(){
		System.out.println("Area of Rectangle");
	}
}


abstract class Shape3D extends AbstractShapeFactory{
	public static Shape3D get3DShapes(String str){
		if("Circle".equals(str)){
			return new Sphere();

		}
		if("Rectangle".equals(str)){
			return new Cube();
		}
		if("Triangle".equals(str)){
			return new Pyramid();
		}			
		return null;
	}
}


class Sphere extends Shape3D {
	public void area(){
		System.out.println(" Volume of Sphere");
	}
}

class Cube extends Shape3D {
	public void area(){
		System.out.println(" Volume of Cube");
	}
}

class Pyramid extends Shape3D {
	public void area(){
		System.out.println(" Volume of Pyramid");
	}
}

public class AbstractFactoryDemo {

	public static void main(String args[]){
		int d = Integer.parseInt(args[0]);
		String shape= args[1];
		AbstractShapeFactory shapeObject = AbstractShapeFactory.getDimenison(d,shape);
		shapeObject.area();
	}
}