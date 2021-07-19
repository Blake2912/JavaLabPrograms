import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    static int partition(int [] arr,int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
        int temp;
        for(int j = low; j <= high - 1; j++){
            if (arr[j] < pivot){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }
    static void quick_sort(int [] arr,int low, int high){
        if(low < high){
            int pivot = partition(arr,low, high);
            quick_sort(arr,low, pivot-1);
            quick_sort(arr,pivot+1, high);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random_number = new Random();
        int MAX,i;
        int [] arr;
        System.out.println("Enter the number of elements in the array: ");
        MAX = input.nextInt();
        arr = new int [MAX];
        input.close();
        long start_time = System.nanoTime();
        for(i=0;i<MAX;i++){
            int randno = random_number.nextInt(10000);
            arr[i] = randno;
        }
        System.out.println("\nUnsorted Array:");
        for(i=0;i<MAX;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\nSorted Array:");
        // Make the function for quick sort.
        quick_sort(arr,0, MAX-1);
        for(i=0;i<MAX;i++){
            System.out.print(arr[i] + "\t");
        }
        long end_time = System.nanoTime();

        long time_taken = end_time - start_time;
        System.out.println("\nTime at start: "+ start_time);
        System.out.println("Time at end: "+ end_time);
        System.out.println("The time taken to do quick sort is: " + time_taken);
    }
}
