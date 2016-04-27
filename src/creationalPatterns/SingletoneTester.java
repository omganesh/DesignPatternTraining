package creationalPatterns;

class SingleToneB{
	static int a = 34;
			
}

class SingleTone {
	static int num = 0;
	
		
	private SingleTone(){
		System.out.println(" The single tone got intialized");
	}
	
	private static class SingleToneHelper {
		 static final SingleTone INSTANCE = new SingleTone();
	}
	
	public static SingleTone getInstance(int nuum){
		num = nuum;
		return SingleToneHelper.INSTANCE;
	}
}

public class SingletoneTester {
	 
	static int a =20;
	
	public static void main(String args[]){
		SingleTone.getInstance(5);
		System.out.println(" value is "+SingleTone.num);
	}

}