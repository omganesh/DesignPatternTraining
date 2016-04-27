/**
 Bridge Composition example 
**/



class Bulb {
	public void glow(){
		System.out.println( " Swithcing on glow bulb ");
	}

	public void dim (){
		System.out.println(" Dimming the glowing bulb");
	}
}


class FanSwitchBridgeComp implements Switch {

	Fan fan = new Fan();
	Bulb bulb= new Bulb();

	public void on(){
		fan.start();
		bulb.glow();
	}

	public void off(){
		fan.stop();
		bulb.dim();
	}

}


public class BridgeCompositDemo {

	public static void main(String args[]){

		Switch fsb = new FanSwitchBridgeComp();
		fsb.on();
		fsb.off();
	}

}