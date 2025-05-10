import java.util.*;

class MyArray<T extends Comparable<T>>{
    private T arr[];

    MyArray(T arr[])
    {
        this.arr=arr;
    }

    private int partition(int low,int high)
    {
        T pivot=arr[high];
        int i=low-1;

        for(int j=low;j<=high;j++)
        {
            if(pivot.compareTo(arr[j])>0)
            {
                i++;
                
                T temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }

        T temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    public void sort(int low,int high)
    {
        if (low<high)
        {
            int pivot=partition(low, high);

            sort(low,pivot-1);
            sort(pivot+1, high);
        }
    }

    public void display()
    {
        System.out.println(Arrays.asList(arr));
    }
}


public class Quicksort {

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
        myArray.sort(0, arr.length - 1);  // Sort the array
        myArray.display();  // Display the sorted array
    }
}