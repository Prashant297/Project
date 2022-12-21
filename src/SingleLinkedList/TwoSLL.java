package SingleLinkedList;

import java.util.Scanner;

public class TwoSLL {
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
    void AddBeg(int data){
        Node NewNode = new Node(data);
        if(head == null){
            head = NewNode;
            tails = NewNode;
        }
        else{
            NewNode.next = head;
            head = NewNode;
        }
    }
    //Adding two node
    int  AddTwoNode(Node head,Node head1){
        TwoSLL sll = new TwoSLL();

        int total = 0,tt = 0;

        //Adding First list element
        while (head != null ){
            total = (total * 10) + head.data;
            head = head.next;
        }

        //Adding Second list element
        while (head1 != null ){
            tt = (tt * 10) + head1.data;
            head1 = head1.next;
        }

        //Total of 1 & 2 list elemenyt
        total = total + tt;
        while (total > 0){
            int n = total % 10;
            sll.AddBeg(n);
            total = total / 10;
        }
        sll.Display();
        return 0;
    }
    void Display(){
        Node current = head;
            while (current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }

    public static void main(String[] args) {
        TwoSLL ll = new TwoSLL();
        TwoSLL sll = new TwoSLL();

        Scanner sc = new Scanner(System.in);
        int n,m,add;

        System.out.println("Enter number of element you want in first list");
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            System.out.println("Enter element in first list");
            add = sc.nextInt();
            ll.AddEnd(add);
        }

        System.out.println("Enter number of element you want in Second list");
        m = sc.nextInt();
        for(int i=0; i<m; i++){
            System.out.println("Enter element in Second list");
            add = sc.nextInt();
            sll.AddEnd(add);
        }

        sll.AddTwoNode(ll.head, sll.head);
    }
}
