package uri.tech;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class RestApiTutorial {
    public static void main(String[] args) throws Exception {
        
        String catCode = "403";
        String uri1 = "https://http.cat/"+catCode;

        Content content = new Content();
        content.setRandomBody("bob");

        Gson gson = new Gson();
        //String jsonRequest = gson.toJson(content);

       HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(new URI(uri1))
            .GET()
            .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        
        //HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
        HttpResponse<byte[]> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofByteArray());


        byte[] imageBytes = response.body();
        //postResponse.body();

        
        String fileName = "test/test"+catCode+".jpg";
        
        
        Files.write(Path.of(fileName), imageBytes);



    }
}
