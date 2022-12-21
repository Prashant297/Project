package DoubleLinkedList.services;

public class DoubleLinkedListImpl implements DoubleLinkedList {
    Node head = null;
    Node tail = null;
    @Override
    public void addBeg(int data) {
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            tail = newNode;
            newNode.pre = null;
            newNode.next = null;
        }else {
            tail = head;
            newNode.next=head;
            newNode.pre=null;
            head=newNode;
            newNode.next=head.next;
        }
    }

    @Override
    public int count() {
        int cout=0;
        Node current = head;
        while (current != null) {
            cout++;
            current = current.next;
        }
        return cout;}

    @Override
    public void addMid(int data) {
        Node current = head;
        Node newNode = new Node(data);
        int mid = count()/2;
        int i=1;
        while (current != null){
            Node temp = current.next;
            if(i == mid)
            {
                current.next = newNode;
                newNode.pre = current.next;
                newNode.next = temp;
            }
            i++;
            current = current.next;
        }
    }

    @Override
    public void Display() {
        Node current = head;
        while(current != null){
            System.out.println(current.data+" ");
            current = current.next;
        }
    }

    @Override
    public void addEnd(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            newNode.pre = null;
            newNode.next = null;
        }else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    @Override
    public void Rotate(int element) {
        Node current = head;
        for(int i = 1; i < element; i++)
            current = current.next;
        tail.next = head;
        head = current.next;
        head.pre = null;
        tail = current;
        tail.next = null;
    }

    @Override
    public void RotateLast(int element) {
        while (element > 0) {
            Node current = head;
            Node temp;
            for (int i = 1; i < count() - 1; i++) {
                current = current.next;
            }
            temp = current.next;
            temp.next = head;
            temp.pre = null;
            head = temp;
            tail = current;
            tail.next = null;
            element--;

        }
    }

    @Override
    public void search(int element) {
        Node current = head;
        int count=0;
        while (current.data != element){
            current=current.next;
            count++;
        }
        System.out.println(count);
    }
}
