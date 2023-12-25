import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HTMLGenerator {

    private final PrintWriter writer;

    public HTMLGenerator(PrintWriter writer){
        this.writer = writer;
    }

    private final String head = """
                                    <head>
                                        <meta charset=\"utf-8\">
                                        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                                        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
                                        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.18.0/font/bootstrap-icons.css">				
                                    </head>
                                """;
    private final String divTemplate =  """
                                        <div class="col mb-4">
                                            <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                                                <h4 class=\"card-header\">%s</h4>
                                                <div class=\"card-body\">
                                                    <img class=\"card-img\" src=\"%s\">
                                                    <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                                                </div>
                                            </div>
                                        </div>
                                        """;

    public void generate(ArrayList<Movie> movies){
        writer.println("<html>");
        writer.println(head);
        writer.println("<body class=\"row row-cols-1 row-cols-md-2 row-cols-lg-3\">");
        generateBody(movies);
        writer.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\"></script>\r\n" + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js\"></script>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    private void generateBody(ArrayList<Movie> list){
        Comparator comp = Comparator.comparing(Movie::getTitle);
        Collections.sort(list, comp);
        for (Movie movie : list) {
            String tmp = "<ul>";
            for (Rating i : movie.getRatings()) {
                tmp += "<li>" + i.getValue() + "</li>";
            }
            tmp += "</ul>";
            writer.printf(divTemplate, movie.getTitle(), movie.getPoster(), tmp, movie.getYear());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // replace <key> by your key and <new String[]{}> with your search Parameters
        ArrayList<Movie> movies = UsingAPI.getMovies("<key>", new String[]{"h","i","j","k","a","b","c","e","f","g","d","t","u","v","w","x","y","z","l","m","n","o","p","q","r","s"});
        PrintWriter writer = new PrintWriter("movie_list.html");
        new HTMLGenerator(writer).generate(movies);
    }

}
