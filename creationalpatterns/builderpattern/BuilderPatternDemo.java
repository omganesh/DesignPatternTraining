/**
Builder pattern 
  1) The emphasis is on the object creation, based on some intrensic conditions
  2) The object is created based on some input , this input is processed & graded based on set of conditions or policies
  **/

class Degree {
	private boolean xth;
	private boolean xIIth;
	private boolean bd;
	private boolean md;
	private boolean phd;


	public void display(){

	}

	public static Degree getDegree() {
		return new Degree();
	}

	public void setXth(boolean x){
		this.xth=x;
	}
	public void setXIIth(boolean x){
		this.xIIth=x;
	}
	public void setBd(boolean x){
		this.bd=x;
	}
	public void setMd(boolean x){
		this.md=x;
	}
	public void setPhd(boolean x){
		this.phd=x;
	}


	public boolean getXth(){
		return this.xth;
	}	

	public boolean getXIIth(){
		return this.xIIth;
	}	

	public boolean getBd(){
		return this.bd;
	}	

	public boolean getMd(){
		return this.md;
	}	

	public boolean getPhd(){
		return this.phd;
	
	}

	public Degree getDegreeCertificate(){

		if(xth){
			if(xIIth){
				if(bd){
					if(md){
						if(phd){
							return new PHD();
						}
						return new MD();
					}
					return new BD();
				}
				return new XIIth();
			}
			return new Xth();
		}
		return null;
	}

}

class Xth extends Degree{
	public void display(){
		System.out.println("Its Xth Degree certificate....");
	}
}

class XIIth extends Degree{
	public void display(){
		System.out.println("Its XIIth Degree certificate....");
	}
}

class BD extends Degree{
	public void display(){
		System.out.println("Its BD Degree certificate....");
	}
}

class MD extends Degree{
	public void display(){
		System.out.println("Its MD Degree certificate....");
	}
}

class PHD extends Degree{
	public void display(){
		System.out.println("Its PHD Degree certificate....");
	}
}

public class BuilderPatternDemo {

	public static void main(String args[]){
		Degree degree = Degree.getDegree();
		degree.setXth(true);
		degree.setXIIth(true);
		degree.setBd(false);
		degree.setMd(true);
		degree.setPhd(true);

		degree.getDegreeCertificate().display();
	}

}