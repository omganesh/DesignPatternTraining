import java.util.*;

/**
Example of Command pattern 
	
**/


interface Order {
	public void execute();
}



class Stock {
	private String stockName;
	private int quantity;

	public Stock(String stockName, int quantity){
		this.stockName= stockName;
		this.quantity= quantity;
	}

	public void buy(){
		System.out.println(" Buy the stock "+stockName+" quantity :"+quantity);
	}

	public void sell(){
		System.out.println(" Sell the stock "+stockName+" quantity :"+quantity);
	}

}

class BuyStock implements Order {
	private Stock xyzStock; 

	public BuyStock(Stock buyStock){
		this.xyzStock = buyStock;
	}

	public void execute(){
		xyzStock.buy();
	}
	
}

class SellStock implements Order {
	private Stock xyzStock; 

	public SellStock(Stock buyStock){
		this.xyzStock = buyStock;
	}

	public void execute(){
		xyzStock.sell();
	}
}

class Broker {

	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order){
		orderList.add(order);
	}

	public void placeOrder(){
		for(Order order: orderList){
			order.execute();
		}
		orderList.clear();
	}

}

public class CommandPatternDemo{
	public static void main(String args[]){

		Stock s1 = new Stock("SBI",2);
		Stock s2 = new Stock("HDFC",5);
		Stock s3 = new Stock("Ambani",100);
		Stock s4 = new Stock("Godrej",300);

		BuyStock bs = new BuyStock(s1);

		BuyStock bs2 = new BuyStock(s2);
		BuyStock bs3 = new BuyStock(s3);

		SellStock ss1 = new SellStock(s4);
		SellStock ss2 = new SellStock(s1);

		Broker br = new Broker();
		br.takeOrder(bs);
		br.takeOrder(bs2);
		br.takeOrder(bs3);
		br.takeOrder(ss1);
		br.takeOrder(ss2);

		br.placeOrder();
	}
}