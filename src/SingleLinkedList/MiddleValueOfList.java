package SingleLinkedList;

public class MiddleValueOfList {

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
                tails = NewNode;
            }
            else {
                tails.next = NewNode;
                tails = NewNode;
            }

        }

        int count(){
            Node current = head;
            int count = 0;
            while (current != null){
                count++;
                current = current.next;
            }
            return count;
        }

        void MiddleValue(int midvalue){
            Node current = head;
            while (midvalue>1){
                current=current.next;
                midvalue--;
            }
            System.out.println(current.data);

        }
        void Delmid(int mv){
            Node current = head;
            while(mv>1){
                current=current.next;
                mv--;
            }
            current.next=current.next.next;
        }
        void Display(){
            Node current = head;
            while (current!=null){
                System.out.println(current.data);
                current=current.next;
            }
        }

        public static void main(String[] args) {
            MiddleValueOfList Link = new  MiddleValueOfList();
            Link.AddNode(1);
            Link.AddNode(2);
            Link.AddNode(3);
            Link.AddNode(4);
            Link.AddNode(5);
            int n=Link.count();
            n=n/2;
            Link.MiddleValue(n);
            Link.Display();
        }
    }
