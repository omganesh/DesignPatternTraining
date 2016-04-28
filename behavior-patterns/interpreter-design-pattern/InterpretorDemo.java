/**

 Integer to 
   Binary
   Hexadecimal
   Octal

 Usage:: java InterpretorDemo "15 to Hexadecimal"

**/
class InterpreterContext{
	public String getBinaryFormat(int i){
		return Integer.toBinaryString(i);
	}

	public String getHexadecimaFormat(int i){
		return Integer.toHexString(i);
	}

	public String getOctalFormat(int i){
		return Integer.toOctalString(i);
	}
}

interface Expression {
	public String interpret(InterpreterContext ic);
}

class IntToBinaryExpression implements Expression{
	private int i;
	IntToBinaryExpression(int c){
		i=c;
	}
	public String interpret(InterpreterContext ic){
		return ic.getBinaryFormat(this.i);
	}
}

class IntToHexadecimalExpression implements Expression{
	private int i;
	public IntToHexadecimalExpression(int c){
		i=c;
	}
	public String interpret(InterpreterContext ic){
		return ic.getHexadecimaFormat(this.i);
	}
}


class IntToOctalExpression implements Expression{
	private int i;
	IntToOctalExpression(int c){
		i=c;
	}
	public String interpret(InterpreterContext ic){
		return ic.getOctalFormat(this.i);
	}
}


class InterpreterClient {
	InterpreterContext ic = null;
	public InterpreterClient(InterpreterContext ic){
		this.ic= ic;
	}

	public String interpret(String str){
		Expression exp = null;
		if(str.contains("Binary")){
			exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
			System.out.println(" int Binary"+exp);
		}else if(str.contains("Hexadecimal")){
			exp = new IntToHexadecimalExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else if(str.contains("Octal")){
			exp= new IntToOctalExpression(Integer.parseInt(str.substring(0,str.indexOf(""))));
		}else{
			return str;
		}

		return exp.interpret(ic);
	}
}

public class InterpretorDemo {
	public static void main(String args[]){

		InterpreterClient ic = new InterpreterClient (new InterpreterContext());

		System.out.println(args[0]+ ":"+ic.interpret(args[0]));

	}
}