class Main{
    public static void main(String[] args) {
        String[] array = {"ola","mundo"};
        Sorts<String> sort = new Sorts<>();

        array = sort.QuickSort(array);
        for(String a : array){
            System.out.printf("%s ", a);
        }
    }


}