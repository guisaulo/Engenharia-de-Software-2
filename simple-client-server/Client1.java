import java.rmi.Naming;

public class Client1 { 
    public static void main(String args[]) throws Exception {
        ServerInterface obj = (ServerInterface)Naming.lookup("//localhost/Server");
        System.out.println(obj.getMessage()); 
    }
}
