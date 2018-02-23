package serverRmiCallBack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote{
	
	public void sayHello() throws RemoteException;
	public void Register(ClientInterface client) throws RemoteException;


}
