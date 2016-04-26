class Student implements Cloneable{

	String name;
	int age;
	String address;
	String grade;


	//@Override
	public String toString(){
		System.out.println(" Name : "+name);
		System.out.println(" Age : "+ age);
		System.out.println("Address :"+ address);
		System.out.println("Grade : "+grade);
		return "";
	}

	public Student getDuplicate(){
		try{
			return (Student)super.clone();		
		}catch(Exception e){
			e.printStackTrace();
		}		
		return null;
	}
}

public class PrototypeDemo {

	public static void main(String args[]){
		Student s1 = new Student();
		Student s2 = new Student();

		Student s3 = s1.getDuplicate();

		System.out.println("s1\n"+s1);
		System.out.println("s2\n"+s2);
		System.out.println("s3\n"+s3);



		Student s4=s1;

		s1.name="Raju";
		s1.age=20;
		s1.address="Banglore";
		s1.grade="5";


		System.out.println("s1\n"+s1);
		System.out.println("s2\n"+s2);
		System.out.println("s3\n"+s3);
		System.out.println("s4\n"+s4);


		System.out.println("s1 "+s1.hashCode());
		System.out.println("s2 "+s2.hashCode());
		System.out.println("s3 "+s3.hashCode());
		System.out.println("s4 " +s4.hashCode());

	}
}