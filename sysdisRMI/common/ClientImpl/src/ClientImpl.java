import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientImpl extends Remote {
	public void giveName() throws RemoteException ;
}
