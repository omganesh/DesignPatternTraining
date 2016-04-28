import java.util.*;

/**


**/

interface ChatMediator{
	public void sendMessage(String msg, User user);
	public void addUser(User user);
}

abstract class User {

	public String name;
	ChatMediator mediator;
	public User(ChatMediator cm , String nm){
		mediator=cm;
		name = nm;
	}
	abstract public void receive(String message);
	abstract public void send(String message);
}

class UserImpl extends User {
	public UserImpl(ChatMediator cm, String nm){
		super(cm,nm);
	}
	public void send(String msg){
		System.out.println("\n\n");
		System.out.println("--------------------");
		System.out.println(name+":"+msg);
		System.out.println("--------------------");
		mediator.sendMessage(msg,this);
	}
	public void receive(String msg){
		System.out.println("Received"+name+":"+msg);
	}
}

class ChatMediatorImpl implements ChatMediator {
	List<User> users;
	public ChatMediatorImpl(){
		users = new ArrayList<User>();
	}
	public void addUser(User user){
		users.add(user);
	}
	public void sendMessage(String msg, User user){
		for(User u:users){
			if(u!=user){
				u.receive(msg);
			}
		}
	}
}

public class MediatorDemo {

	public static void main(String args[]){
		ChatMediatorImpl mediator = new ChatMediatorImpl();

		User u1= new UserImpl(mediator,"Praveen");
		User u2= new UserImpl(mediator,"Anand");

		User u4= new UserImpl(mediator,"Praveen- u1");
		User u5= new UserImpl(mediator,"Anand- u5");


		mediator.addUser(u1);
		mediator.addUser(u2);
		mediator.addUser(u4);
		mediator.addUser(u5);

		u1.send("HI");
		u2.send("Helllo");
		u4.send("BYE");

	}
}