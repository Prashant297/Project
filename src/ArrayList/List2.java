package ArrayList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class List2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(6);
        arr.add(5);
        arr.add(8);
        arr.add(10);

        Collections.sort(arr);
        int n = arr.get(arr.size() - 1);
        for (int i = 0; i < n; i++) {
            if (!arr.contains(i)) {
                arr.add(i);
            }
            Collections.sort(arr, Collections.reverseOrder());
        }
        System.out.println(arr);
    }
}
