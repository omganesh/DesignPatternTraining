import java.util.*;
/**
Iterator example 
**/

class Item {
	private String name;
	private int price;

	public Item(String name, int price ){
		this.name=name;
		this.price = price;
	}

	public String toString(){
		System.out.println(" Name : "+name);
		System.out.println(" Price :"+price);
		return "";
	}
}

class Menu {
	List<Item> menuItem;
	public Menu(){
		menuItem = new ArrayList<Item>();

	}
	public void addItem(Item i){
		menuItem.add(i);
	}
	public void removeItem(Item i){
		menuItem.remove(i);
	}

	class MenuIterator implements Iterator{
		int currentIndex=0;
		public boolean hasNext(){
			if(currentIndex>=menuItem.size()){
				return false;
			}else{
				return true;
			}
		}
		public Item next(){
			return menuItem.get(currentIndex++);
		}
		public void remove(){
			menuItem.remove(currentIndex--);
		}
	}

	public Iterator iterator(){
		return new MenuIterator();

	}
}


public class IteratorDemo {

	public static void main(String args[]){
		Menu menu = new Menu();

		menu.addItem(new Item("Pen",25));
		menu.addItem(new Item("Pencil",25));
		menu.addItem(new Item("Notebook",25));
		menu.addItem(new Item("Duster",25));
		menu.addItem(new Item("SketchPen",15));
		menu.addItem(new Item("InkPot",55));

		Iterator i = menu.iterator();

		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}