package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompareArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,5,9));
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(9,4,5));

        Collections.sort(arr);
        Collections.sort(arr1);
         boolean equal = arr.equals(arr1);
        System.out.println(equal);



    }
}
