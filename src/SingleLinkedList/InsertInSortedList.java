package SingleLinkedList;
import java.util.Scanner;

public class InsertInSortedList {

    class Node {
        int data;
        Node next;

       Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    Node tails = null;

    public void AddNode(int data){
        Node NewNode = new Node(data);
        if(head == null){
            head = NewNode;
        }
        else {
            tails.next = NewNode;
            tails = NewNode;
        }
    }
    int InsertInSortNord(int num){
        Node temp = new Node(num);
        if(head == null || head.data>num){
            head = temp;
            tails = temp;
        }
        Node current = head;
        int n = 0;
        while (current.next != null && n == 0){
            if(num < current.next.data){
               temp.next = current.next;
                current.next = temp;
                n++;
            }
            current=current.next;
        }
        while (current.next == null && n == 0){
            temp.next = null;
            current.next = temp;
            current = current.next;
            n++;
            }
        return 0;
    }

    void Ascending(){
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    void Decendind(Node current){
        if(current.next ==null){
            System.out.println(current.data);
            return;
        }
        Decendind(current.next);
        System.out.println(current.data);
    }

    public static void main(String[] args) {

        InsertInSortedList list = new InsertInSortedList();
        Scanner sc = new Scanner(System.in);

        int num,n;
        list.AddNode(1);


        System.out.println("Enter a number");
        num=sc.nextInt();

        list.InsertInSortNord(num);

        System.out.println("press  1.Add   2.Display   3.Exit");
        n=sc.nextInt();
        while (n<3 && n>0){
            switch (n){
                case 1: System.out.println("Enter a number");
                    num=sc.nextInt();
                    list.InsertInSortNord(num);
                    break;
                case 2: {
                    System.out.println("Display data 1.Asccending   2.Decessending");
                    int d = sc.nextInt();
                    switch (d) {
                        case 1:
                            System.out.println("Data Display in Asscending order");
                            list.Ascending();
                            break;
                        case 2: System.out.println("Data Display in Descending order");
                            list.Decendind(list.head);
                            break;
                    }
                }

                break;
            }
            System.out.println("press   1.Add  2.Display   3.Exit");
            n=sc.nextInt();

        }
        System.out.println("Program Exit");
    }

}

/*int count(){
        Node current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }*/
 /*  int DisplayNode(int d){
        Node current = head;
        int len=count();
        int i=0;
        int[] dec = new int[len];

        while(current!=null){
            dec[i++]=current.data;
            current=current.next;
        }
        if(d==2) {
            for (int arr = dec.length - 1; arr >= 0; arr--) {
                System.out.println(dec[arr]);
            }
        }
        if(d==1) {
            for (int arr =0 ; arr <= dec.length - 1; arr++) {
                System.out.println(dec[arr]);
            }
        }
        return 0;
    }*/