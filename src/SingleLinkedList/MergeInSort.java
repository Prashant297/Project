package SingleLinkedList;

import java.util.Scanner;

public class MergeInSort {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    Node head = null;
    Node tails = null;

    void AddEnd(int data) {
        Node NewNode = new Node(data);
        if (head == null) {
            head = NewNode;
            tails = NewNode;
        } else {
            tails.next = NewNode;
            tails = NewNode;
        }
    }
    void Sort( Node h1){
        Node current = h1;
        int temp=0;
        while (current != null) {
            Node in = current.next;
            while (in != null) {
                if (current.data > in.data){
                    temp = current.data;
                    current.data = in.data;
                    in.data = temp;
                }  in = in.next;
            }current = current.next;
        }
    }

    void Display(){
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public static void main(String[] args) {

        MergeInSort LL1 = new MergeInSort();
        MergeInSort LL2 = new MergeInSort();

        Scanner sc = new Scanner(System.in);
        int n,m,add;

        System.out.println("Enter number of element you want in first list");
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            System.out.println("Enter element in first list");
            add = sc.nextInt();
            LL1.AddEnd(add);
        }

        System.out.println("Enter number of element you want in Second list");
        m = sc.nextInt();
        for(int i=0; i<m; i++){
            System.out.println("Enter element in Second list");
            add = sc.nextInt();
            LL2.AddEnd(add);
        }

        //Merging 2 list into 1 list
        Node current = LL2.head;
        while (current != null){
            LL1.AddEnd(current.data);
            current = current.next;
        }
        while (LL2.head != null){
           LL2.head = null;
           LL2.tails = null;
        }

        LL1.Sort(LL1.head);
        LL1.Display();
    }
}


