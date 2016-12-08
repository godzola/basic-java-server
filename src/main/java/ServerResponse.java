
public class ServerResponse {

    ServerRequest req;
    String respStr;

    final static String twoHundredResp = "HTML/1.1 200 \r\n";
    final static String fourOhFour = "HTML/1.1 404 \r\n";
    final static String fiveHundred = "HTML/1.1 500 \r\n";
    final static String serverName = "Server: Server/1.0 \r\n";
    final static String contentType = "Content-Type: application/json \r\n";
    final static String closeConnection = "Connection: close \r\n";
    final static String blankHeaderLine = "\r\n";


    // here, we could do routing, too
    // if we don't do it in the Request or Handler

    public ServerResponse(ServerRequest req){
        this.req = req;
        String fakeJson = "{ \"qry\": \"" + req.pathAndQuery + "\"}\n";

        respStr = twoHundredResp;
        respStr += contentType;
        respStr += serverName;
        respStr += closeConnection;
        respStr += "Content-Length: " + fakeJson.length();
        respStr += blankHeaderLine;
        respStr += fakeJson;

        System.out.println("Response:");
        System.out.println(respStr);
    }
}
