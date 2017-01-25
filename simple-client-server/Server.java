import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 

public class Server extends UnicastRemoteObject implements ServerInterface {
    
	public static final String MESSAGE = "Teste Mensagem!";

    public Server() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step, see below
    }

    public String getMessage() {
        return MESSAGE;
    }

    public static void main(String args[]) throws Exception {
		System.out.println("Server Iniciado.");

        try { //Manipulador de exceção especial para criação de Registro
            LocateRegistry.createRegistry(1099); 
            System.out.println("Registro Java RMI foi criado.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("O registro Java RMI ja existe.");
        }
           
        //Instanciando o Server
        Server obj = new Server();

        //Bind a instancia do objeto ao nome "Server"
        Naming.rebind("//localhost/Server", obj);
        System.out.println("PeerServer ligado no registro");
    }
}
