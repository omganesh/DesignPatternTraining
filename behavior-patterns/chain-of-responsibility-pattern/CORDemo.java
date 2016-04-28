/**
Chain of Responsibility Demo
  Usage 
  		java CORDemo 2400
  expected output :
		Dispensing:2 notes of Rs.1000
		Dispensing:4 notes of Rs.100

Explanation: 

   The linking happens in the ATM Dispenser which will see if it can handle the amount in Curr 
    if not will pass responsibility to the next object 
     DispenseChain->chain 
    so here the COR logic coded in ATMDispenser is 
    Rupee1000Dispenser -> Rupee500Dispenser -> Rupee100Dispenser

    Examples of COR in java 
       Error or Exception handeling
**/

class Currency{
	private int amount;
	public Currency(int amt){
		amount = amt;
	}
	public int getAmount(){
		return amount;
	}
}

interface DispenseChain{
	public void dispense(Currency curr);
	public void setNext(DispenseChain nextChain);
}

class Rupee1000Dispenser implements DispenseChain {
	DispenseChain chain;
	public void dispense(Currency cur){
		if(cur.getAmount()>=1000){
			int num=cur.getAmount()/1000;
			int remainder = cur.getAmount()%1000;
			System.out.println("Dispensing:"+num+" notes of Rs.1000");
			if(remainder!=0){
				chain.dispense(new Currency(remainder));
			}
		}else{
				chain.dispense(cur);
		}
	}

	public void setNext(DispenseChain nextChain){
		chain = nextChain;
	}
}

class Rupee500Dispenser implements DispenseChain {
	DispenseChain chain;
	public void dispense(Currency cur){
		if(cur.getAmount()>=500){
			int num=cur.getAmount()/500;
			int remainder = cur.getAmount()%500;
			System.out.println("Dispensing:"+num+" notes of Rs.500");
			if(remainder!=0){
				chain.dispense(new Currency(remainder));
			}
		}else{
				chain.dispense(cur);
		}
	}

	public void setNext(DispenseChain nextChain){
		chain = nextChain;
	}

}
class Rupee100Dispenser implements DispenseChain {
	DispenseChain chain;
	public void dispense(Currency cur){
		if(cur.getAmount()>=100){
			int num=cur.getAmount()/100;
			int remainder = cur.getAmount()%100;
			System.out.println("Dispensing:"+num+" notes of Rs.100");
			if(remainder!=0){
				chain.dispense(new Currency(remainder));
			}
		}else{
				chain.dispense(cur);
		}
	}
	public void setNext(DispenseChain nextChain){
		chain = nextChain;
	}

}

class ATMDispenser {
	DispenseChain c1;

	public ATMDispenser(){
		c1= new Rupee1000Dispenser();
		DispenseChain c2 = new Rupee500Dispenser();
		DispenseChain c3 = new Rupee100Dispenser();
		
		c1.setNext(c2);
		c2.setNext(c3);
	}
}

public class CORDemo {

	public static void main(String args[]){
		ATMDispenser d1 = new ATMDispenser();

		Currency curr = new Currency(Integer.parseInt(args[0]));
		d1.c1.dispense(curr);

	}
	
}