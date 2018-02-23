import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements ServerImpl {

	@Override
	public String RepeteMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("" + message);
		return message;
	}

	@Override
	public void Register(ClientImpl client) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public Server(){
		try {
			String name = "testServer";
			ServerImpl stub = (ServerImpl) UnicastRemoteObject.exportObject(this,0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(name, stub);
			
			System.out.println("Serveur en écoute !");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		 new Server() ;
	}

}
