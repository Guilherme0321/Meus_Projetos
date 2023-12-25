public class Rating {
    private String source;
    private String value;

    public Rating(){
        source = null;
        value = null;
    }

    public Rating(String json){
        Rating temp = toRating(json);
        this.source = temp.getSource();
        this.value = temp.getValue();
    }

    public Rating(String source, String value){
        this.source = source;
        this.value = value;
    }
    
    public void setSource(String value){
        source = value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String  getSource(){
        return source;
    }

    public String getValue(){
        return value;
    }
    /**
     * Converts a JSON string containing an array of Rating objects into an array of Rating objects.
     *
     * @param json A JSON string representing an array of Rating objects.
     * @return An array of Rating objects parsed from the JSON string.
     * @throws IllegalArgumentException If the input JSON format is invalid.
     */
    public static Rating[] AlltoRatings(String json){
        String[] tmp = splitObjects(json);
        Rating[] notas = new Rating[tmp.length];
        for(int i = 0; i < tmp.length; i++){
            notas[i] = toRating(tmp[i]);
        }
        return notas;
    }
    /**
     * Counts the number of JSON objects within a given JSON string.
     *
     * @param obj A JSON string to count the objects in.
     * @return The number of JSON objects in the input string.
     * @throws IllegalArgumentException If the input JSON format is invalid.
     */
    private static int countObjs(String obj){
        int tempOpen = 0;
        int tempClose = 0;
        for(int i = 0; i < obj.length(); i++){
            if(obj.charAt(i) == '{'){
                tempOpen++;
            }else if(obj.charAt(i) == '}'){
                tempClose++;
            }
        }
        if((tempOpen - tempClose) == 0){
            return tempClose;
        }else{
            throw new IllegalArgumentException("Invalid format. Expected format: {\"Ratings\":[{...},{...},...]}");
        }
    }
    /**
     * Splits a JSON string into an array of individual JSON objects.
     *
     * @param json A JSON string containing an array of objects.
     * @return An array of strings, each representing a single JSON object.
     * @throws IllegalArgumentException If the input JSON format is invalid.
     */
    private static String[] splitObjects(String json){
        int i = 0, len = countObjs(json);
        String[] objs = new String[len];
        while (i < json.length() && json.charAt(i) != '[') {
            i++;
        }
        if(i == json.length()){
            throw new IllegalArgumentException("Invalid format. Expected format: {\"Ratings\":[{...},{...},...]}");
        }
        i++;
        int arrayIndex = 0;
        while (i < json.length() && json.charAt(i) != ']') {
            objs[arrayIndex] += json.charAt(i);
            if(json.charAt(i) == '}'){
                arrayIndex++;
            }
            i++;
        }
        return objs;
    }

    /**
     * Converts a JSON-like string representation of a Rating object to an actual Rating object.
     *
     * The input string should have the following format:
     * {
     *     "Source":"<source>",
     *     "Value":"<value>"
     * }
     * Where "<source>" represents the source of the rating, and "<value>" represents the numerical value of the rating.
     *
     * @param value A string representing a JSON-like structure containing the source and value of a rating.
     * @return A Rating object created from the provided string.
     * @throws IllegalArgumentException If the input string does not match the expected format.
     */
    public static Rating toRating(String value){
        String source = "Source", val = "Value";
        int indexSource = value.indexOf(source);
        int indexValue = value.indexOf(val);

        if(indexSource == -1 || indexValue == -1){
            throw new IllegalArgumentException("Invalid format. Expected format: {\"Source\":\"<source>\",\"Value\":\"<value>\"}");
        }

        int i = indexSource, j = indexValue;

        String tempSouce = "", tempVal = "";

        while (i < value.length() && value.charAt(i) != ':') {
            i++;
        }
        i += 2;
        while (i < value.length() && value.charAt(i) != '"') {
            tempSouce += value.charAt(i);
            i++;
        }
        while (j < value.length() && value.charAt(j) != ':') {
            j++;
        }
        j += 2;
        while (j < value.length() && value.charAt(j) != '"') {
            tempVal += value.charAt(j);
            j++;
        }
        return new Rating(tempSouce, tempVal);
    }

    @Override
    public String toString(){
        return "{\"Source\":\"" + this.source + ",\"Value\":\""+ this.value + "\"}";
    }

}
