package SingleLinkedList;

import java.util.Scanner;

public class ModulasLast{

    public class Node {
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
            tails = NewNode;
        }
        else {
            tails.next = NewNode;
            tails = NewNode;
        }

    }

   int ModuleNode(int mod){
        Node current = head;
        int temp=0;
        while(current != null){
            if(current.data%mod==0){
                temp=current.data;
            }
            current=current.next;
        }
        return temp;
   }

    public static void main(String[] args) {

        ModulasLast Listl = new ModulasLast();
        Scanner sc = new Scanner(System.in);

        Listl.AddNode(78);
        Listl.AddNode(75);
        Listl.AddNode(7);
        Listl.AddNode(8);
        Listl.AddNode(6);
        Listl.AddNode(2);

        int n,num;
        System.out.println("Enter number to find the last number divisible is ");
        num=sc.nextInt();
        n=Listl.ModuleNode(num);
        System.out.println(n);

    }
}
