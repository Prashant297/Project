package CircularLinkedList;

public class Min_Max {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    Node head=null;
    Node tails=null;
    void AddNode(int data){
        Node NewNode = new Node(data);
        if(head == null){
            head = NewNode;
            tails = NewNode;
            tails.next = head;
        }
        else {
            tails.next = NewNode;
            tails = NewNode;
            tails.next = head;
        }
    }


    void max() {
        Node current = head;
        int max = head.data;

        do{
            if (max < current.data) {
                max = current.data;
            }
            current = current.next;
        } while (current != head); {

        }
        System.out.println(max);
    }




    public static void main(String[] args) {
        Min_Max cl = new Min_Max();
        cl.AddNode(4);
        cl.AddNode(545);
        cl.AddNode(12);
        cl.AddNode(1122);
        cl.AddNode(1);

        cl.max();


    }
}
