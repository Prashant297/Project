package ArrayList;

import java.util.*;

public class List {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        list.add(1);
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(2);

        list1.add(15);
        list1.add(19);
        list1.add(20);
        list1.add(40);
        list1.add(21);


        for (int i=0; i<4; i++){
            if(list.contains(list1.get(i))){
                System.out.println(list1.get(i));
            }
        }
        }

    }
