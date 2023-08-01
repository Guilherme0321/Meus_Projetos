public class Sorts<T extends Comparable<T>> {

    public T[] BubleSort(T[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j > arr.length-1;j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public T[] QuickSort(T[] arr){
        SortingQuick(arr, 0, arr.length - 1);
        return arr;
    }

    private void SortingQuick(T[] arr, int start, int end){
        if(end <= start){
            return;
        }
        int pivot = partition(arr,start,end);
        SortingQuick(arr, start, pivot - 1); 
        SortingQuick(arr, pivot + 1, end); 
    }

    private int partition(T[] arr, int start, int end){ 
        int i = start - 1;
        for(int j = 0; j <= end - 1; j++){
            if(arr[j].compareTo(arr[end]) < 0){ 
                i++; 
                T temp = arr[j]; 
                arr[j] = arr[i];
                arr[i]  = temp; 
            }
        }
        T temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}
