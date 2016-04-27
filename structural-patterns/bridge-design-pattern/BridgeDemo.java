/**
 Inheritence example 
**/
interface Switch{
	public void on();
	public void off();
}

class Fan {
	public void start(){
		System.out.println(" Starting fan");
	}

	public void stop(){
		System.out.println(" Stopping fan");
	}
}


class FanSwitchBridge extends Fan implements Switch {

	public void on(){
		this.start();
	}

	public void off(){
		this.stop();
	}

}

public class BridgeDemo {

	public static void main(String args[]){

		Switch fsb = new FanSwitchBridge();
		fsb.on();
		fsb.off();
	}

}