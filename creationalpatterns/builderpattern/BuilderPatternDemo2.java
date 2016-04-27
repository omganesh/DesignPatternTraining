/**
Builder pattern 
  1) The emphasis is on the object creation, based on some intrensic conditions
  2) The object is created based on some input , this input is processed & graded based on set of conditions or policies
  **/

class Degree2 {
	
	public void display(){

	}

	public static Degree2 getDegree2() {
		return new Degree2();
	}

	
	public Degree2 getDegree2Certificate(){

		if(Xth2){
			if(XIIth2){
				if(bd){
					if(md){
						if(phd){
							return new PHD();
						}
						return new MD();
					}
					return new BD();
				}
				return new XIIth2();
			}
			return new Xth2();
		}
		return null;
	}

}

class Xth2 extends Degree2{
	public void display(){
		System.out.println("Its Xth2 Degree2 certificate....");
	}
}

class XIIth2 extends Degree2{
	public Xth2 getXth2Degree2(){
		return new Xth2();
	}
	public void display(){
		System.out.println("Its XIIth2 Degree2 certificate....");
	}
}

class BD extends Degree2{

	public XIIth2 getXIIth2Degree2(){
		return new XIIth2();
	}

	public void display(){
		System.out.println("Its BD Degree2 certificate....");
	}
}

class MD extends Degree2{

	public BD getBDDegree2(){
		return new BD();
	}

	public void display(){
		System.out.println("Its MD Degree2 certificate....");
	}
}

class PHD extends Degree2{

	public MD getMDDegree2(){
		return new MD();
	}

	public void display(){
		System.out.println("Its PHD Degree2 certificate....");
	}
}

public class BuilderPatternDemo2 {

	public static void main(String args[]){

		Degree2 Degree2 = Degree2.getDegree2();
		Xth2 x = Degree2.getXth2Degree2();
		Degree2.getDegree2Certificate().display();

	}
}