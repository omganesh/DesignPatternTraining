/**
Template pattern

Example in java 
   java.lang.EventObject
   java.io.InputStream 

   The above are good examples of the template patterns

   Template pattern forces the user to make use of Abstract classes in java 
     as a rule template pattern needs atlease one method which cannot be over ridden - hence use a final method
**/

abstract class Game {

	public abstract void tauss ();
	public abstract void startGame();
	public abstract void endGame();
	public abstract void result();
	public void interval(){

	}

	/**
	 Method cannot be over-ridden
	**/	
	public final void play() {
		System.out.println(" ------------------------- ");
		tauss();
		startGame();
		interval();
		endGame();
		result();
		System.out.println(" ------------------------- ");
	}
}



class Cricket extends Game {

	public void tauss() {
		System.out.println( " Cricket:: tauss is happening ");
	}

	public void startGame(){
		System.out.println( " Cricket:: game has started ");	
	}

	public void endGame(){
		System.out.println( " Cricket:: game has finished ");	
	}

	public void result(){
		System.out.println( " Cricket::  And winning team is ");	
	}

	public void interval(){
		System.out.println(" Cricekt:: interval");
	}

}

class Football extends Game {

	public void tauss() {
		System.out.println( " Football:: tauss is happening ");
	}

	public void startGame(){
		System.out.println( " Football:: game has started ");	
	}

	public void endGame(){
		System.out.println( " Football:: game has finished ");	
	}

	public void result(){
		System.out.println( " Football::  And winning team is ");	
	}

}
/*
class Cricket extends Game {

	public void tauss() {
		System.out.println( " Cricket:: tauss is happening ");
	}

	public void startGame(){
		System.out.println( " Cricket:: game has started ");	
	}

	public void endGame(){
		System.out.println( " Cricket:: game has finished ");	
	}

	public void result(){
		System.out.println( " Cricket::  And winning team is ");	
	}

}*/

public class TemplateDemo {
	public static void main(String args[]){
		
		Game game = new Cricket();
		game.play();

		game = new Football();
		game.play();

	}
}