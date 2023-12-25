import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class UsingAPI {

    public static String removeSpace(String x){
        String res = "";
        for(char i : x.toCharArray()){
            if(i != ' '){
                res += i;
            }
        }
        return res;
    }

    public static String search(String key, String title){
        String url = "https://www.omdbapi.com/?apikey=" + key + "&t=" + title;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = null;
        HttpResponse<String> res = null;
        try{
            req = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            res = client.send(req, HttpResponse.BodyHandlers.ofString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return res.body();
    }

    public static ArrayList<Movie> getMovies(String key, String[] title){
        String[] movies = new String[title.length];
        ArrayList<Movie> arrmovies = new ArrayList<>();
        for(int i = 0; i < title.length; i++){
            movies[i] = search(key, title[i] + "");
        }
        for(String i : movies){
            arrmovies.add(Movie.toMovie(i));
        }
        return arrmovies;
    }
}
