package SingleLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listof {
    public static void main(String[] args) {
        LinkedList<String> str = new LinkedList<>();

        str.add("Sarthak");
        str.add("Prashant");
        str.add("aayush");
        str.add("Savan");
        for (String s:str) {
            System.out.println(s);
        }

       List<String> li = List.of("Sarthak","Prashant","aayush","Savan");
        for (String s : li) {
            System.out.println(s);
        }
    }
}
