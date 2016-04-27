class Socket {

	public Volt getVolt(){
		return new Volt(120);
	}
}

class Volt {

	private int volts;
	public Volt(int v){
		this.volts=v;
	}
	public void setVolts(int v){
		volts= v;
	}

	public int getVolts(){
		return volts;
	}

}

interface SocketAdapter{
	public Volt get120V();
	public Volt get12V();
	public Volt get3V();
}

class SocketClassAdapterImpl extends Socket implements SocketAdapter{
	private Socket socket = new Socket();
	public Volt get120V(){
		return socket.getVolt();
	}

	public Volt get12V(){
		Volt v = getVolt();
		return convertVolt(v,10);
	}

	public Volt get3V(){
		return socket.getVolt();
	}

	public Volt convertVolt(Volt v, int volts){
		return new Volt(v.getVolts()/volts);
	}
}

public class AdapterDemo {

	public static void main(String args[]){

		SocketAdapter adapter = new SocketClassAdapterImpl();

		Volt v1 = adapter.getVolt();

	}

}