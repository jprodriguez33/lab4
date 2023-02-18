/*
John Paul Rodriguez
Lab 4
Sorting and De-duplicating using the quicksort method.
*/
public class Main {
    public static void main(String[] args) {
        int array[] = {50,11,33,21,40,50,40,40,21};
        //null error handling
        if (array == null) {
            System.out.println("Array is null");
        }
        int n = array.length;
        quickSort(array, 0, n-1);
        n = duplicates(array,n);

        //function to print out array elements
        System.out.print("[");
        for (int i=0; i<n; i++) {
            //if elements of array were to be input by user
            //Null error handling
            System.out.print(array[i] + ",");
        }System.out.print("]");
    }
    static void quickSort(int[] arr, int left, int right){
        //quicksort function
        // pivot is set after it calls the partition function
        if (left < right){
            int pivot = partition(arr,left,right);
            //sort elements before and after the pivot
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
    }
    static void swap(int[] arr, int i, int j){
        // function to swap elements from the partition function
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int left, int right ) {

        int pivot = arr[right];
        //pivot is set as last bound of the array
        int i = (left - 1);
        // for loop which iterates through the array and begins the swap process
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                //increment until smaller index is equal to pivot
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return (i + 1);
    }
    static int duplicates(int array[], int length){
        // function which handles duplicates
        // edge cases are tested first, if the length of the array is 0 or 1
        // it will return the element of the array
        if(length == 0 || length == 1)
            return length;
        int index = 0;

        //iterates through the array to check whether current index is equal to next index
        for(int i = 0; i < length-1; i++){
            if(array[i] != array[i+1]){
                array[index++] = array[i];
            }
        }
        array[index++] = array[length-1];
        return index;
    }

}