package SingleLinkedList;

public class AddNode_DisplayNode {

       public class Node{
            int data;
            Node next;
             Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        Node head = null;
        Node tails = null;

        void AddNode(int data){

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

        void DisplayNode(){
            Node current = head;
            if(head==null){
                System.out.println("Empty");
                return;
            }

            while(current != null){
                System.out.println(current.data+" ");
                current = current.next;
            }
        }

    public static void main(String[] args) {

            AddNode_DisplayNode sll = new AddNode_DisplayNode();

            sll.AddNode(45);
            sll.AddNode(75);
            sll.DisplayNode();

    }

}
