import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import interfacage.Parrot;
 
public class ParrotImpl implements Parrot{
 
    @Override
    public void repete(String msg) throws RemoteException {
        System.out.println("Je repete " + msg);
    }
 
    @Override
    public Date quelleHeureEstIl() throws RemoteException {
        Date d = new Date();
        System.out.println("J'envoie la date : " + d);
        return d ;
    }
 
    public ParrotImpl() {
        try{
            String name = "Jacquot" ;
            Parrot stub = (Parrot)
            UnicastRemoteObject.exportObject(this, 0) ;
            Registry registry = LocateRegistry.createRegistry(1099) ; // si port changé -> lespécifier dans le client
            registry.rebind(name, stub) ;
 
            System.out.println("Parrot à l'ecoute.");
        }catch (Exception e) {
            e.printStackTrace() ;
        }
    }
 
    public static void main(String[] args) {
        new ParrotImpl() ;
    }
 
}