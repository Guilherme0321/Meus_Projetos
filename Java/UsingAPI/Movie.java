import java.util.ArrayList;

public class Movie {
    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private ArrayList<Rating> ratings;
    private String metascore;
    private String imdbrating;
    private String imdbvotes;
    private String imdbid;
    private String type;
    private String dvd;
    private String boxoffice;
    private String production;
    private String website;

    public Movie(){
        title = null;
        year = null;
        rated = null;
        released = null;
        runtime = null;
        genre = null;
        director = null;
        writer = null;
        actors = null;
        plot = null;
        language = null;
        country = null;
        awards = null;
        poster = null;
        ratings = null;
        metascore = null;
        imdbrating = null;
        imdbvotes = null;
        imdbid = null;
        type = null;
        dvd = null;
        boxoffice = null;
        production = null;
        website = null;
    }

    private static String getRating(String json, int index){
        String temp = "";
        while (index < json.length() && json.charAt(index) != ']') {
            temp += json.charAt(index++);
        }
        return temp;
    }

    private static String sepInfo(String json, int index){
        String temp = "";
        while (index < json.length() && json.charAt(index) != '"') {
            temp += json.charAt(index);
            index++;
        }
        return temp;
    }

    /**
     * Converts a JSON-like string representation of a Movie object to an actual Movie object.
     *
     * @param value A string representing a JSON-like structure containing the source and value of a rating.
     * @return A Rating object created from the provided string.
     * @throws IllegalArgumentException If the input string does not match the expected format.
     */
    public static Movie toMovie(String json){
        String temp = "";
        Movie movie = new Movie();
        int compareTitle = json.indexOf("Title") + "Title".length() + 3;
        temp = sepInfo(json, compareTitle);
        movie.setTitle(temp);
        
        int compareYear = json.indexOf("Year") + "Year".length() + 3;
        temp = sepInfo(json, compareYear);
        movie.setYear(temp);
        
        int compareRated = json.indexOf("Rated") + "Rated".length() + 3;
        temp = sepInfo(json, compareRated);
        movie.setRated(temp);
        
        int compareReleased = json.indexOf("Released") + "Released".length() + 3;
        temp = sepInfo(json, compareReleased);
        movie.setReleased(temp);
        
        int compareRuntime = json.indexOf("Runtime") + "Runtime".length() + 3;
        temp = sepInfo(json, compareRuntime);
        movie.setRuntime(temp);
        
        int compareGenre = json.indexOf("Genre") + "Genre".length() + 3;
        temp = sepInfo(json, compareGenre);
        movie.setGenre(temp);
        
        int compareDirector = json.indexOf("Director") + "Director".length() + 3;
        temp = sepInfo(json, compareDirector);
        movie.setDirector(temp);
        
        int compareWriter = json.indexOf("Writer") + "Writer".length() + 3;
        temp = sepInfo(json, compareWriter);
        movie.setWriter(temp);
        
        int compareActors = json.indexOf("Actors") + "Actors".length() + 3;
        temp = sepInfo(json, compareActors);
        movie.setActors(temp);
        
        int comparePlot = json.indexOf("Plot") + "Plot".length() + 3;
        temp = sepInfo(json, comparePlot);
        movie.setPlot(temp);
        
        int compareLanguage = json.indexOf("Language") + "Language".length() + 3;
        temp = sepInfo(json, compareLanguage);
        movie.setLanguage(temp);
        
        int compareCountry = json.indexOf("Country") + "Country".length() + 3;
        temp = sepInfo(json, compareCountry);
        movie.setCountry(temp);
        
        int compareAwards = json.indexOf("Awards") + "Awards".length() + 3;
        temp = sepInfo(json, compareAwards);
        movie.setAwards(temp);
        
        int comparePoster = json.indexOf("Poster") + "Poster".length() + 3;
        temp = sepInfo(json, comparePoster);
        movie.setPoster(temp);
        
        int compareRatings = json.indexOf("Ratings") + "Ratings".length() + 2;
        temp = getRating(json, compareRatings);
        movie.setRatings(temp);
        
        int compareMetascore = json.indexOf("Metascore") + "Metascore".length() + 3;
        temp = sepInfo(json, compareMetascore);
        movie.setMetascore(temp);
        
        int compareimdbRating = json.indexOf("imdbRating") + "imdbRating".length() + 3;
        temp = sepInfo(json, compareimdbRating);
        movie.setImdbrating(temp);
        
        int compareimdbVotes = json.indexOf("imdbVotes") + "imdbVotes".length() + 3;
        temp = sepInfo(json, compareimdbVotes);
        movie.setImdbvotes(temp);
        
        int compareimdbID = json.indexOf("imdbID") + "imdbID".length() + 3;
        temp = sepInfo(json, compareimdbID);
        movie.setImdbid(temp);
        
        int compareType = json.indexOf("Type") + "Type".length() + 3;
        temp = sepInfo(json, compareType);
        movie.setType(temp);
        
        int compareDVD = json.indexOf("DVD") + "DVD".length() + 3;
        temp = sepInfo(json, compareDVD);
        movie.setDvd(temp);
        
        int compareBoxOffice = json.indexOf("BoxOffice") + "BoxOffice".length() + 3;
        temp = sepInfo(json, compareBoxOffice);
        movie.setBoxoffice(temp);
        
        int compareProduction = json.indexOf("Production") + "Production".length() + 3;
        temp = sepInfo(json, compareProduction);
        movie.setProduction(temp);
        
        int compareWebsite = json.indexOf("Website") + "Website".length() + 3;
        temp = sepInfo(json, compareWebsite);
        movie.setWebsite(temp);
        return movie;
    }
    public void setTitle(String value){
        title = value;
    }
    public void setYear(String value){
        year = value;
    }
    public void setRated(String value){
        rated = value;
    }
    public void setReleased(String value){
        released = value;
    }
    public void setRuntime(String value){
        runtime = value;
    }
    public void setGenre(String value){
        genre = value;
    }
    public void setDirector(String value){
        director = value;
    }
    public void setWriter(String value){
        writer = value;
    }
    public void setActors(String value){
        actors = value;
    }
    public void setPlot(String value){
        plot = value;
    }
    public void setLanguage(String value){
        language = value;
    }
    public void setCountry(String value){
        country = value;
    }
    public void setAwards(String value){
        awards = value;
    }
    public void setPoster(String value){
        poster = value;
    }
    public void addRatings(String value){
        if(ratings == null){
            ratings = new ArrayList<Rating>();
        }
        ratings.add(Rating.toRating(value));
    }
    public void setRatings(String value){
        Rating[] tempRatings = Rating.AlltoRatings(value);
        ratings = null;
        ratings = new ArrayList<Rating>();
        for (Rating i : tempRatings) {
            ratings.add(i);
        }
    }
    public void setMetascore(String value){
        metascore = value;
    }
    public void setImdbrating(String value){
        imdbrating = value;
    }
    public void setImdbvotes(String value){
        imdbvotes = value;
    }
    public void setImdbid(String value){
        imdbid = value;
    }
    public void setType(String value){
        type = value;
    }
    public void setDvd(String value){
        dvd = value;
    }
    public void setBoxoffice(String value){
        boxoffice = value;
    }
    public void setProduction(String value){
        production = value;
    }
    public void setWebsite(String value){
        website = value;
    }
    public String getTitle(){
        return title;
    }
    public String getYear(){
        return year;
    }
    public String getRated(){
        return rated;
    }
    public String getReleased(){
        return released;
    }
    public String getRuntime(){
        return runtime;
    }
    public String getGenre(){
        return genre;
    }
    public String getDirector(){
        return director;
    }
    public String getWriter(){
        return writer;
    }
    public String getActors(){
        return actors;
    }
    public String getPlot(){
        return plot;
    }
    public String getLanguage(){
        return language;
    }    
    public String getCountry(){
        return country;
    }
    public String getAwards(){
        return awards;
    }
    public String getPoster(){
        return poster;
    }
    public ArrayList<Rating> getRatings(){
        return ratings;
    }
    public String getMetascore(){
        return metascore;
    }
    public String getImdbrating(){
        return imdbrating;
    }
    public String getImdbvotes(){
        return imdbvotes;
    }
    public String getImdbid(){
        return imdbid;
    }
    public String getType(){
        return type;
    }
    public String getDvd(){
        return dvd;
    }
    public String getBoxoffice(){
        return boxoffice;
    }
    public String getProduction(){
        return production;
    }
    public String getWebsite(){
        return website;
    }    
    public int compareTo(String titulo){
        return this.title.compareTo(titulo);
    }
}
