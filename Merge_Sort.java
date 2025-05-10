import java.util.*;  
//SORTS THE ARRAY IN O(N*LOG(N)) TIME USING MERGE SORT

// A generic class that performs merge sort on an array of type T, which extends Comparable
class MyArray<T extends Comparable<T>> {
    private T arr[];  

    MyArray(T arr[]) {
        this.arr = arr;
    }

    // Method to perform merge sort on the array from 'left' to 'right' index
    public void MergeSort(int left, int right) {
        if (left < right) {
            int mid = left - (left - right) / 2;  

            // Recursive calls to sort the left and right halves
            MergeSort(left, mid);
            MergeSort(mid + 1, right);

            // Merging the two sorted halves
            merge_two_SortedArrays(left, mid, right);
        }
    }

    // Helper method to merge two sorted halves of the array
    private void merge_two_SortedArrays(int left, int mid, int right) {
        List<T> l1 = new LinkedList<>();  // List to store elements from left half
        List<T> l2 = new LinkedList<>();  // List to store elements from right half

        // Copy elements from left subarray to l1
        for (int i = 0; i < mid - left + 1; i++) {
            l1.add(arr[left + i]);
        }
        // Copy elements from right subarray to l2
        for (int i = 0; i < right - mid; i++) {
            l2.add(arr[mid + 1 + i]);
        }

        int k = left;  

        while (!l1.isEmpty() && !l2.isEmpty()) {
            if (l1.get(0).compareTo(l2.get(0)) <= 0) {  // Compare first elements of l1 and l2
                arr[k] = l1.remove(0);  // Place the smaller element in the array and remove it from l1
            } else {
                arr[k] = l2.remove(0);  // Place the smaller element in the array and remove it from l2
            }
            k++;
        }

        // Copy remaining elements from l1, if any
        while (!l1.isEmpty()) {
            arr[k] = l1.remove(0);
            k++;
        }
        
        // Copy remaining elements from l2, if any
        while (!l2.isEmpty()) {
            arr[k] = l2.remove(0);
            k++;
        }
    }

    // Method to display the array elements
    void display() {
        System.out.println(Arrays.asList(arr));
    }
}

// Main class to test the MyArray class functionality
public class Merge_Sort {

    public static void main(String[] args) {

        System.out.println("For Integers");
        DisplayMain(new Integer[]{669, 72, -109, 0, 89, -99999, 85, 66, 69, -200});
        System.out.println();

        System.out.println(("For Strings"));
        DisplayMain(new String[]{"Megh", "Patel", "Ahmedabad", "India", "Sort"});
        System.out.println();

        System.out.println("For Doubles");
        DisplayMain(new Double[]{40000.00, 69.6969, 96.9669, 0.0000000078});

        System.out.println();
        System.out.println("This Practical is made by 23CS069-Megh Patel");
    }

    // Generic method to display the original and sorted array
    public static <T extends Comparable<T>> void DisplayMain(T arr[]) {
        MyArray<T> myArray = new MyArray<>(arr);  // Create an instance of MyArray
        System.out.println("Original Array :-");
        myArray.display();  // Display the original array
        System.out.println("Sorted Array :-");
        myArray.MergeSort(0, arr.length - 1);  // Sort the array
        myArray.display();  // Display the sorted array
    }
}