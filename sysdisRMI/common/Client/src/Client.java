import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client implements ClientImpl {

	String name;

	@Override
	public void giveName() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(this.name);
		
	}
	
	public Client(){
		try {
			ServerImpl server = (ServerImpl) Naming.lookup("rmi://localhost/testServer");
			System.out.println(server.RepeteMessage("ceci est un test"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public static void main(String[] args) {
		 System.out.println("Client demarre");
		 new Client() ;
	}
}
