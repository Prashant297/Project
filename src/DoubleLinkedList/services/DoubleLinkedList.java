package DoubleLinkedList.services;

public interface DoubleLinkedList {
    void addBeg(int data);
    int   count();
    void addMid(int data);
    void Display();
    void addEnd(int data);

    void Rotate(int element);
    void RotateLast(int element);
    void search(int element);



}
