package DoubleLinkedList;

import DoubleLinkedList.services.DoubleLinkedListImpl;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedListImpl dlList = new DoubleLinkedListImpl();
        dlList.addBeg(4515);
        dlList.addBeg(1);
        dlList.addBeg(5);
        dlList.addMid(45);
        dlList.addEnd(2);
        dlList.RotateLast(1);

        dlList.Display();
    }
}
