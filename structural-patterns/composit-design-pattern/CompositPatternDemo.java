import java.util.*;

class TeachingStaff {

	String name ;
	int age;
	int salary;
	String subject;
	String desig;


	List<TeachingStaff> subordinates ;


	public TeachingStaff(){
		subordinates= new ArrayList<TeachingStaff>();
	}

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}

	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return this.age;
	}

	public void setSalary(int salary){
		this.salary=salary;
	}
	public int getSalary(){
		return this.salary;
	}

	public void setSubject(String subject){
		this.subject=subject;
	}

	public String getSubject(){
		return this.subject;
	}

	public void setDesignation(String desig){
		this.desig=desig;
	}
	public String getDesignation(){
		return this.desig;
	}

	public void addSubbordinateStaff(TeachingStaff staff){
		subordinates.add(staff);
	}
	public void removeSubbordinateStaff(TeachingStaff staff){
		subordinates.remove(staff);
	}

	public List<TeachingStaff> getSubbordinate(){
		return subordinates;
	}

	public String toString(){
		System.out.println(" Staff details : \n Name :"+name+
											 "\n Age :"+age+
											 "\n Salary :"+salary+
											 "\n Subject :"+subject+
											 "\n Designation :"+desig);
	}

	public void getSubbordinateDetails(){
		for(TeachingStaff staff: subordinates){
			System.out.println(staff);
		}
	}
}


public class CompositPatternDemo {
	public static void main(String args[]){
		TeachingStaff principal = new TeachingStaff();
		principal.setName("Rajendra");
		principal.setAge(55);
		principal.setSalary(60000);
		principal.setSubject("Maths");
		principal.setDesignation("Principal");

		TeachingStaff hod1 = new TeachingStaff();
		hod1.setName("Harish");
		hod1.setAge(35);
		hod1.setSalary(30000);
		hod1.setSubject("Biology");
		hod1.setDesignation("HOD");

		TeachingStaff hod2 = new TeachingStaff();
		hod1.setName("Manish");
		hod1.setAge(38);
		hod1.setSalary(33000);
		hod1.setSubject("Physics");
		hod1.setDesignation("HOD");

		TeachingStaff hod1 = new TeachingStaff();
		hod1.setName("Suresh");
		hod1.setAge(32);
		hod1.setSalary(34000);
		hod1.setSubject("Chemistry");
		hod1.setDesignation("HOD");

		TeachingStaff lecutre1 = new TeachingStaff();
		lecutre1.setName("Harish");
		lecutre1.setAge(35);
		lecutre1.setSalary(30000);
		lecutre1.setSubject("Botney");
		lecutre1.setDesignation("Lectrer");

		TeachingStaff lecture2 = new TeachingStaff();
		lecture2.setName("Harish");
		lecture2.setAge(35);
		lecture2.setSalary(30000);
		lecture2.setSubject("Zoolagy");
		lecture2.setDesignation("Lectrer");

		TeachingStaff lecture3 = new TeachingStaff();
		lecture3.setName("Harish");
		lecture3.setAge(35);
		lecture3.setSalary(30000);
		lecture3.setSubject("Organic Chemistry");
		lecture3.setDesignation("Lectrer");

		

		hod1.addSubbordinateStaff(lecutre1);
		hod1.addSubbordinateStaff(lecture2);


		hod2.addSubbordinateStaff(lecture2);
		hod2.addSubbordinateStaff(lecture3);

		principal.addSubbordinateStaff(hod1);
		principal.addSubbordinateStaff(hod2);


		principal.getSubbordinateDetails();	



	}
}
