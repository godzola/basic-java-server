import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerHandler extends Thread {

    Socket s;
    BufferedReader br;
    PrintWriter pw;



    public ServerHandler(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pw = new PrintWriter(s.getOutputStream());
    }

    @Override
    public void run(){
        try {
            String reqStr = "";

            while (br.ready() || reqStr.length() == 0) {
                reqStr += (char) br.read();
            }

            System.out.println("Request:");
            System.out.println(reqStr);

            ServerRequest req = new ServerRequest(reqStr);

            // this is the thread, so we could
            // do routing here, then pass the request
            // to the correct handler instead of generic "ServerResponse()"
            ServerResponse resp = new ServerResponse(req);

            pw.write(resp.respStr.toCharArray());

            // close these in the correct order
            // first the streams, then the socket
            pw.close();
            br.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
