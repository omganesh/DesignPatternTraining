/**
 Iterator example 2 
   Here have written own example of  Iterator which has following fucntions
      getLast();
      getFirst()
      getItem(index);
      getPrevious()

    on call of all the above methods it resets the index to the position which item was got from 

    In the function 

     
**/
class Item2 {
	private String name;
	private int price;
	public Item2(String n,int p){
		name = n;
		price= p;
	}
	public String toString(){
		System.out.println(" Name: "+name);
		System.out.println(" Price: "+price);
		return "";
	}
}

interface ItemIterator {
	public Item2 getFirst();
	public Item2 getLast();
	public Item2 get(int index);
	public int getCount();
	public Item2 next();
	//public boolean hasNext();
	public Item2 previous();

}

class Menu2 {
	int count=0;
	int index=0;

	final int size=50;	

	Item2 menuItem[] = new Item2[size];

	public void addItem(Item2 i){
		menuItem[count++]=i;
	}

	class MenuIterator implements ItemIterator {
		public Item2 getFirst(){
			index=0;
			return menuItem[index];
		}

		public Item2 getLast(){
			index = count -1;
			return menuItem[index];
		}

		public Item2 get(int ind){
			if(ind<count){
				index=ind;
				return menuItem[index];
			}else
			{
				return null;
			}
		}

		public int getCount(){
			return count;
		}

		public Item2 next(){
			index++;
			if(index >= count){
				index = 0;
			}
			return menuItem[index];
		}

		public Item2 previous(){
			index--;
			if(index<0){
				index=count-1;
			}
			return menuItem[index--];
		}
	}

	public MenuIterator getIterator(){
		return new MenuIterator();
	}


}

public class IteratorDemo2{
	public static void main(String args[]){
		Menu2 menu = new Menu2();

		menu.addItem(new Item2("Pen",25));
		menu.addItem(new Item2("Pencil",25));
		menu.addItem(new Item2("Notebook",25));
		menu.addItem(new Item2("Duster",25));
		menu.addItem(new Item2("SketchPen",15));
		menu.addItem(new Item2("InkPot",55));

		ItemIterator ii = menu.getIterator();
		System.out.println(ii.getLast());
		System.out.println(ii.getFirst());
		System.out.println(ii.get(3));
		System.out.println(ii.previous());

	}
}