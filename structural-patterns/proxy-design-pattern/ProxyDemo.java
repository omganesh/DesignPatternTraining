interface Image {
	public void display();
}

class RealImage implements Image {
	private String fileName;
	public RealImage(String fileName){
		this.fileName = fileName;
		System.out.println(" Loading file name "+fileName);
	}

	public void display(){
		System.out.println("displaying "+fileName);
	}
}

class ProxyImage implements Image {
	RealImage image;
	String fileName;

	ProxyImage(String fileName){
		this.fileName= fileName;
	}

	public void display(){
		if(image==null){
			image = new RealImage(fileName); 
		}
		image.display();
	}
}

public class ProxyDemo{
	public static void main(String args[]){

			Image  abc = new ProxyImage("xyz");
			Image cd = new ProxyImage("abc");

			abc.display();
			cd.display();
			abc.display();
			cd.display();
			cd.display();
			cd.display();
	}
}