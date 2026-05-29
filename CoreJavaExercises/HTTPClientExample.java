// Q36: HTTP Client API (Java 11+)
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClientExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/octocat"))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("\nResponse Body:");
        System.out.println(response.body());

        // Optional: simple key extraction without external library
        String body = response.body();
        extractField(body, "login");
        extractField(body, "name");
        extractField(body, "public_repos");
    }

    static void extractField(String json, String key) {
        String search = "\"" + key + "\":";
        int idx = json.indexOf(search);
        if (idx == -1) return;
        int start = idx + search.length();
        int end = json.indexOf(",", start);
        if (end == -1) end = json.indexOf("}", start);
        System.out.println(key + " -> " + json.substring(start, end).trim());
    }
}
