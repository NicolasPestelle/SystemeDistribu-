import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


import serverRmiCallBack.ServerInterface;

public class Server  implements ServerInterface {

	ClientInterface client ;

	@Override
	public void sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Hellooooooo !") ;
		
	}

	@Override
	public void Register(ClientInterface client) throws RemoteException {
		// TODO Auto-generated method stub
		this.client = client ;
		client.showYourName() ;
	}
	
	public Server() {
		try{
			
			String name = "server" ;
			ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(this, 0) ;
			Registry registry = LocateRegistry.createRegistry(1099) ;
			System.out.println("Server bound") ;
		}catch (Exception e) {
			 e.printStackTrace() ;
		}
	}
	
	public static void main(String[] args) {
		 new Server() ;
	}

	@Override
	public void Register(serverRmiCallBack.ClientInterface client) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
