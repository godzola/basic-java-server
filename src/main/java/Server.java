import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    final static String SERVER_HOST = "localhost";
    final static int SERVER_PORT = 4580;
    ServerSocket serverSocket;

    // make a global read only data struct of stuff here
    // to instantiate in main or a constructor or something
    // so it can be passed along
    // volatile HashMap<Integer, String> bigReadOnlyMapOfStuff;

    public static void main(String[] args) throws Exception {

        // we'd want to instantiate and data structures
        // or connections we'd want to share among threads
        // here. then, be careful not to write to them!

        // bigReadOnlyMapOfStuff = instantiate_here();

        new Server().run();
    }

    public void run() throws Exception {
        serverSocket = new ServerSocket(SERVER_PORT);
        acceptRequests();
    }

    private void acceptRequests() throws Exception {

            while(true){
                Socket s = serverSocket.accept();
                // server handler is the thread
                ServerHandler gsh = new ServerHandler(s);
                // this starts it and calls the server handler run() method automatically
                gsh.start();
            }
    }
}
