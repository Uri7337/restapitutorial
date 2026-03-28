package uri.tech;

import java.net.URI;
import java.net.http.HttpRequest;

public class RestApiTutorial {
    public static void main(String[] args) {
        
        String uri1 = "https://http.cat/";

        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(new URI(uri1))
            //different class takes api key from file and puts it here
            //.header("Authorization", "here->apikey")
            

    }
}
