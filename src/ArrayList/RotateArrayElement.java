package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateArrayElement {


    public static void main(String[] args) {

        ArrayList<Integer> Arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n,element,add;

        System.out.println("Enter no of element you want to enter");
        element = sc.nextInt();
        for (int i = 0; i<element; i++){
            System.out.println("Enter the element");
             Arr.add(sc.nextInt());
        }

        System.out.println("Enter number f element you want to rotate");
        n=sc.nextInt();

        for (int i=n; i<Arr.size()-1; i++) {
            int nm = 0 ,temp = 0,l = Arr.size()-1;
                temp = Arr.get(l);
                Arr.remove(l);
                Arr.add(nm,temp);
            }
        System.out.println(Arr);


    }
}
