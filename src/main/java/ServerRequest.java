
public class ServerRequest {

    String requestType;
    String pathAndQuery;
    String httpVersion;


    public ServerRequest(String req){

        String[] requestLines = req.split("\n");

        // make sure we get the request encoded
        String[] reqLine = requestLines[0].split(" ");
        requestType = reqLine[0];
        pathAndQuery = reqLine[1];
        httpVersion = reqLine[2];

        // could get fancy here and put things like
        // the body in their own objects

        // Since we're parsing the request, we could also do
        // routing here, if we don't do it in SeverHandler()

    }

}
