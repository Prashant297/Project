package CircularLinkedList;

public class AscAndDecOrder {
   class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    Node head;
    Node tails;

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
    void  DisplayNode(){
        Node current = head;
        if(current == null){
            System.out.println("List is empty");
        }
        do{
            System.out.println(current.data);
            current = current.next;
        }while (current != head);
    }

    void ReverseOrder(Node current){

        if (current.next == head){
            System.out.println(current.data);
            return;
        }
        ReverseOrder(current.next);
        System.out.println(current.data);

    }
    public static void main(String[] args) {
        AscAndDecOrder ADlist = new AscAndDecOrder();

        ADlist.AddNode(12);
        ADlist.AddNode(121);
        ADlist.AddNode(1);
        ADlist.DisplayNode();
        ADlist.ReverseOrder(ADlist.head);


    }
}
