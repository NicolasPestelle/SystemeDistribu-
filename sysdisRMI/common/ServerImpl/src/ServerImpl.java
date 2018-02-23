import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerImpl extends Remote{

	public String RepeteMessage(String message) throws RemoteException;
	public void Register(ClientImpl client) throws RemoteException;
}
