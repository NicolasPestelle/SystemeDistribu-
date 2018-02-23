
import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.rmi.Naming;
 import java.rmi.RemoteException;
 import java.rmi.server.UnicastRemoteObject;

 import javax.swing.JButton;
 import javax.swing.JFrame;

 import common.ClientInterface;
 import common.ServerInterface;

 public class Client implements ClientInterface {

 JFrame frm = new JFrame() ;
 JButton b ;

 ServerInterface serv ;
 ClientInterface stub ;

 @Override
 public void showYourName() throws RemoteException {
 String name = "Greg is ze Best" ;
 System.out.println(name);
 frm.setTitle(name) ;
 b.setText(name) ;
 }

 public Client() {

 try {

 stub = (ClientInterface) UnicastRemoteObject.exportObject(this, 0) ;

 serv = (ServerInterface) Naming.lookup("rmi://localhost/server") ;

 System.out.println("Client.Client()");
 } catch (Exception e) {
 e.printStackTrace() ;
 }

 buildUI() ;

 }

 private void buildUI() {
 frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 b = new JButton("!!! click !!!") ;
 b.addActionListener(new ActionListener() {

 @Override
 public void actionPerformed(ActionEvent arg0) {
 try {
 serv.sayHello() ;
 serv.register(stub) ;
 } catch (RemoteException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }
 }) ;
 frm.getContentPane().add(b) ;

 frm.setSize(300, 200) ;
 frm.setVisible(true) ;

 }

 /**
 * @param args
 */
 public static void main(String[] args) {
 System.out.println("Client demarre");
 new Client() ;
 }

 }