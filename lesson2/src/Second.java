
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Second {
    public static void main(String args[]) {
//        int[] arr; // int arr[];
//        arr = new int[5];
//        int[] arr2 = {1, 2, 3, 4, 5}; // -X-> 4
//        System.out.println(arr.length);
//        System.out.println(arr[4]);
//        System.out.println(Arrays.toString(arr2));
        
        Array arr = new Array(5);
        arr.append(1);
        arr.append(5);
        arr.append(5);
//        System.out.println(arr);
        arr.append(4);
        arr.append(-5);
//        arr.append(6);
//        arr.append(7);
//        arr.append(8);
//        System.out.println(arr);
//        arr.remove();
//        arr.remove();
//        System.out.println(arr);
        arr.countingSort();
//        System.out.println(arr);
    }
}
