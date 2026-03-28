package uri.tech;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class RestApiTutorial {
    public static void main(String[] args) throws Exception {
        
        String uri1 = "https://http.cat/404";

        Content content = new Content();
        content.setRandomBody("bob");

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(content);

        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(new URI(uri1))
            //different class takes api key from file and puts it here
            //.header("Authorization", "Config.getApiKey()")
            //.POST(BodyPublishers.ofString(jsonRequest))
            .GET()
            .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        
        HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());

        System.out.println(postResponse.body());
        //postResponse.body();

        String fileContent = postResponse.body();
        String fileName = "test";
        
        WriteToFile wtf = new WriteToFile();

        
        wtf.writeToFile(fileName,fileContent);


    }
}
