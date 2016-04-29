import java.util.*;

/**
Name ascending sort
**/
class NameSorter implements Comparator {
	public int compare(Object a, Object b){
		Person p1 = (Person)a;
		Person p2 = (Person)b;

		return (p1.name).compareTo(p2.name);
	}
}


/**
Age ascending sort
**/
class AgeSorter implements Comparator {
	public int compare(Object a, Object b){
		Person p1 = (Person)a;
		Person p2 = (Person)b;

		return (p1.age).compareTo(p2.age);
	}
}


/**
 Name descending sort
**/
class NameSorterDesc implements Comparator {
	public int compare(Object a, Object b){
		Person p1 = (Person)a;
		Person p2 = (Person)b;

		return (p2.name).compareTo(p1.name);
	}
}

/**
Age descending sort
**/
class AgeSorterDesc implements Comparator {
	public int compare(Object a, Object b){
		Person p1 = (Person)a;
		Person p2 = (Person)b;

		return (p2.age).compareTo(p1.age);
	}
}

