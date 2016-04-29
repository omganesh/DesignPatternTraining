/**
User defined example for Strategy pattern



**/


/**
Interface which defines the strategy
**/
interface Strategy {
	public int doOperation(int a, int b);
}

/**
Classes which Implement the strategy interface
**/
class OperationDiv implements Strategy {
	public int doOperation(int a, int b){
		return (a/b);
	}
}

class OperationMul implements Strategy {
	public int doOperation(int a, int b){
		return (a*b);
	}
}


class OperationAdd implements Strategy {
	public int doOperation(int a, int b){
		return (a+b);
	}
}

class OperationSub implements Strategy {
	public int doOperation(int a, int b){
		return (a-b);
	}
}


/**
The Context has a attribute which is an interface which will be helpful in
promptly selecting the appropriate values 
**/
class Context {
	private static Strategy strategy;

	public Context(Strategy str){
		strategy=str;
	}
	public int calculate(int a, int b){
		return strategy.doOperation(a,b);
	}
}

/**

**/
public class StrategyDemo2 {
	public static void main(String args[]){

		Context ctx = new Context(new OperationSub());
		System.out.println(ctx.calculate(50,10));

		Context ctx2 = new Context(new OperationMul());
		System.out.println(ctx2.calculate(100,20));

		Context ctx3 = new Context(new OperationAdd());
		System.out.println(ctx3.calculate(100,20));
	}
}