package API_test;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class request {
    private static String covid19_API_URL="https://demo-covid-api.herokuapp.com/api/";
    private int loc_id;

    public request() { }

    public request(int i)
    {
        loc_id = i;
    }

    public static String getCovid19_API_URL() {
        return covid19_API_URL;
    }

    public void setCovid19_API_URL(String url)
    {
        covid19_API_URL = url;
    }

    public int getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }

    public HttpResponse<String> getJSON() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header( "accept", "application/json")
                .uri(URI.create(covid19_API_URL+String.valueOf(loc_id)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }
}
